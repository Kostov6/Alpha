
$(document).ready(function(){
	$.getJSON( "http://localhost:8080/Alpha-Build/projects", function( jsonArray ) {
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#container").append(createProjectElement(jsonObject)) ;
				$("#container").append(createProjectElement(jsonObject)) ;
				
			}
		);
	});
});


function createProjectElement(jsonObject)
{
	return "<div style=\"display:inline; width: 350px; padding:15px\">"+
		"<div class=\"w3-card-4\"><div class=\"w3-container\"><h2>"+
		jsonObject.name+"</h2></div><a href=\""+getLink(jsonObject.id)+"\"><img src=\""+jsonObject.image+"\" alt=\"\" style=\"width: 300px; height:185px\"></a>"+
		"<div class=\"w3-container\"><p class=\"w3-tag w3-yellow\">"+jsonObject.lang+
		 "</p></div></div></div>";
}

function getLink(projecId)
{
	return "http://localhost:8080/Alpha-Build/first-prototype/AiProjects.html?projectId="+projecId;
}