window.onload=function(){
	document.getElementById("model-form").addEventListener("submit", function(event) {
		event.preventDefault();
		var user=document.getElementById("user");
		var repo=document.getElementById("repo");
		var project=document.getElementById("project");
		var jsonModel=
		{
			projectId: parseInt(project.value),
			name:user.value,
			repo:repo.value,
			gitUrl:"https://github.com/"+user.value+"/"+repo.value,
			gitStars:0
		};
		addModel(jsonModel);
		console.log(jsonModel);
	});
}

function addModel(jsonModel)
{
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/Alpha-Build/models/addModel",
		contentType: "application/json",
		data: JSON.stringify(jsonModel)
	});
}