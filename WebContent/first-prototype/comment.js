
var commentUrl="http://localhost:8080/Alpha-Build/comments/getByProjectId/"+getProjectId();

function getProjectId()
{
	var url_string = window.location.href
	var url = new URL(url_string);
	var c = url.searchParams.get("projectId");
	console.log(c);
	return c;
}

$(document).ready(function(){
		
	$.getJSON(commentUrl, function( jsonArray ) {
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#comments").append(getComment(jsonObject)) ;
			}
		);
	});
	loggedUser.listeners.push(function(oldvalue,newValue){
		if(newValue!=null)
		{
			$("#comment-form-box").append(getCommentForm({name:newValue.user,avatarUrl:newValue.avatarUrl}));
		}
	});
	
});



function getComment(jsonObject)
{
	return "<div class='comment-container'><a href='"+getUserGitUrl(jsonObject)+
			"'><img class='avatar-image' src='"+getUserAvatarUrl(jsonObject)+
			"'/></a><div class='comment-box'><div class='w3-bar w3-border w3-light-grey'><div class='w3-bar-item'>"+
			getUserName(jsonObject)+"</div></div><div style='color:black'>"+
			getCommentContent(jsonObject)+"</div></div></div>";
}

function getCommentForm(jsonUser)
{
	return "<div class='comment-container'><a href='"+getUserGitUrl(jsonUser)+
			"'><img id='commentBox-img' class='avatar-image' src='"+getUserAvatarUrl(jsonUser)+
			"'/></a><div class='comment-box'><div class='w3-bar w3-border w3-light-grey'><div id='commentBox-user' class='w3-bar-item'>"+
			getUserName(jsonUser)+"</div><button class='w3-bar-item' style='float: right;' onclick='putComment()' onmouseenter='this.style.setProperty(\"background-color\",\"#99ffcc\")' onmouseleave='this.style.setProperty(\"background-color\",\"buttonface\")'>Comment</button></div><div style='color:black'>"+
			"<textarea id='commentBox-comment' rows='5' style='width:100%'></textarea>"+"</div></div></div>";
}

function putComment()
{
	
	var jsonComment;
	var projectId=getProjectId();
	var user=document.getElementById("commentBox-user").innerHTML;
	var avatarUrl=document.getElementById("commentBox-img").getAttribute("src");
	var comment=document.getElementById("commentBox-comment").value;
	var jsonComment={
		projectId: parseInt(projectId),
		name: user,
		avatarUrl: avatarUrl,
		comment: comment
	};
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/Alpha-Build/comments/add",
		contentType: "application/json",
		data: JSON.stringify(jsonComment)
	});
	window.alert("Comment added to this project");
	console.log(jsonComment);
}

function getUserName(jsonObject)
{
	return jsonObject.name;
}

function getUserAvatarUrl(jsonObject)
{
	return jsonObject.avatarUrl;
}

function getUserGitUrl(jsonObject)
{
	return "https://github.com/"+jsonObject.name;
}

function getCommentContent(jsonObject)
{
	return jsonObject.comment;
}