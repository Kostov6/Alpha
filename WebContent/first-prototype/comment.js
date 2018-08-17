
var commentUrl="http://localhost:8080/Alpha-Build/comments/getByProjectId/"+getProjectId();

function getProjectId()
{
	var url_string = window.location.href
	var url = new URL(url_string);
	var c = url.searchParams.get("projectId");
	console.log(c);
	return c;
}

$.getJSON(commentUrl, function( jsonArray ) {
	$(document).ready(function(){
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#comments").append(getComment(jsonObject)) ;
			}
		);
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