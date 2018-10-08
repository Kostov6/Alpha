function getProjectId()
{
	var url_string = window.location.href
	var url = new URL(url_string);
	var c = url.searchParams.get("projectId");
	console.log(c);
	return c;
}

$(document).ready(function(){
	document.getElementById("model-form").addEventListener("submit", function(event) {
		if(loggedUser.value==null)
		{
			//window.alert("You haven't logged in yet");
			window.open("https://github.com/login/oauth/authorize?client_id=099b3b26927004bc8273&scope=user:email%20public_repo","_self");
			return;
		}
		event.preventDefault();
		var user=loggedUser.value.user;
		var repo=document.getElementById("repo").value;
		var projectId=getProjectId();
		var language=document.getElementById("language").value;
		commitLanguage(language);
		
		var jsonModel=
		{
			projectId: parseInt(projectId),
			name:user,
			repo:repo,
			readme: "README.md",
			otherImgSrc: "no",
			gitUrl:"https://github.com/"+user+"/"+repo,
			language:language
		};
		addModel(jsonModel);
		
		var avatarUrl=loggedUser.value.avatarUrl;
		var comment=document.getElementById("description").value;
		var jsonComment={
			projectId: parseInt(projectId),
			name: "Description: "+user,
			avatarUrl: avatarUrl,
			comment: comment
		};
		addDescription(jsonComment);
		window.open("http://localhost:8080/Alpha-Build/first-prototype/AiProjects.html?projectId="+projectId,"_self");
		
	});
});

function addModel(jsonModel)
{
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/Alpha-Build/models/addModel",
		contentType: "application/json",
		data: JSON.stringify(jsonModel)
	});
}

function addDescription(jsonComment)
{
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/Alpha-Build/comments/add",
		contentType: "application/json",
		data: JSON.stringify(jsonComment)
	});
}

function commitLanguage(lang)
{

	$.ajax({
		type: "POST",
		url: "http://localhost:8080/Alpha-Build/projects/newLanguageString/"+getProjectId()+"/"+lang
	});

}