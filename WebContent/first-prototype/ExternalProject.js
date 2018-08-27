$(document).ready(function(){
	document.getElementById("model-form").addEventListener("submit", function(event) {
		event.preventDefault();
		var user=document.getElementById("user").value;
		var repo=document.getElementById("repo");
		var project=document.getElementById("project");
		var jsonModel=
		{
			projectId: parseInt(project.value),
			name:user,
			repo:repo.value,
			gitUrl:"https://github.com/"+user.value+"/"+repo.value,
			gitStars:0
		};
		addExternalModel(jsonModel);
	});
});

function addExternalModel(jsonModel)
{
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/Alpha-Build/models/addModel",
		contentType: "application/json",
		data: JSON.stringify(jsonModel)
	});
}