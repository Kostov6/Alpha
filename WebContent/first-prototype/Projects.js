
$.getJSON( "http://localhost:8080/Alpha-Build/projects", function( jsonArray ) {
	$(document).ready(function(){
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#container").append(createProjectElement(jsonObject)) ;
				
				console.log(createProjectElement(jsonObject));
			}
		);
	});
});


function createProjectElement(jsonObject)
{
	return "<a href=\""+getLink(jsonObject.id)+"\" style=\"text-decoration:none; width: 300px; margin:15px\">"+
		"<div class=\"w3-card-4\"><div class=\"w3-container\"><h2>"+
		jsonObject.name+"</h2></div><img src=\""+jsonObject.image+"\" alt=\"Norway\" style=\"width:100%\">"+
		"<div class=\"w3-container\"><p class=\"w3-tag w3-yellow\">"+jsonObject.lang+
		 "</p></div></div></a>";
}

function getLink(projecId)
{
	return "http://localhost:8080/Alpha-Build/first-prototype/AiProjects.html?projectId="+projecId;
}