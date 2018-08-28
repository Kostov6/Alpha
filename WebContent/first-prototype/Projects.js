
$(document).ready(function(){
	$.getJSON( "http://localhost:8080/Alpha-Build/projects", function( jsonArray ) {
			$.each(
				jsonArray ,
				function(i,jsonObject) {
					$("#container").append(createProjectElement(jsonObject,["Java",""])) ;
					$("#container").append(createProjectElement(jsonObject,["Java","Python",""])) ;					
				}
			);
		});
});


function createProjectElement(jsonObject,langs)
{
	var top = "<div style=\"display:inline; width: 350px; padding:15px\">"+
		"<div class=\"w3-card-4\"><div class=\"w3-container\"><h2>"+
		jsonObject.name+"</h2></div><a href=\""+getLink(jsonObject.id)+"\"><img src=\""+jsonObject.image+"\" alt=\"\" style=\"width: 300px; margin-left:10px; height:185px\"></a>"+
		"<div class=\"w3-container\">";
		for(var i=0;i<langs.length-1;i++)
		{
			var color="w3-yellow";
			if(langs[i].localeCompare("Python")==0)
				color="w3-blue";
			var link=getLink(jsonObject.id)+"&lang="+langs[i];
			top+="<button onclick='window.open(\""+link+"\",\"_self\")' class=\"w3-button w3-small w3-padding-small "+color+"\" style='margin:10px 5px 10px 5px;'>"+langs[i]+"</button>";
		}
		
		 return top+"</div></div></div>";
}

function getLink(projecId)
{
	return "http://localhost:8080/Alpha-Build/first-prototype/AiProjects.html?projectId="+projecId;
}
