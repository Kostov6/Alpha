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
			return
		event.preventDefault();
		var user=loggedUser.value.user;
		var repo=document.getElementById("repo");
		var project=getProjectId();
		var jsonModel=
		{
			projectId: parseInt(project.value),
			name:user,
			repo:repo.value,
			gitUrl:"https://github.com/"+user.value+"/"+repo.value,
			gitStars:0
		};
		addModel(jsonModel);
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