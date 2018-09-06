

$(document).ready(function(){
	$.getJSON( "http://localhost:8080/Alpha-Build/projects/featured", function( jsonArray ) {
		$.each(
			jsonArray ,
			function(i,jsonObject) {
					$("#featured-container").append(createFeaturedProjectElement(jsonObject)) ;
			}
		);
	});
});

function createFeaturedProjectElement(jsonObject)
{
	var out= "<div class='col-md-4'><div class='entry'><div class='entry-media'>"+
  			"<a href='"+getLink(jsonObject.id)+"' title=''><span class='absolute-wrapper'></span>"+
  			"<img src='"+jsonObject.image+"' alt='' class='img-responsive' /></a></div><h3 class='entry-title'>"+
  			"<a href='"+getLink(jsonObject.id)+"' title='"+jsonObject.name+"'>"+jsonObject.name+"</a></h3>"
  			+"<div class=\"w3-container\">";
  	var langs=jsonObject.lang.split(";");
  	for(var i=0;i<langs.length-1;i++)
	{
		var color="w3-yellow";
		if(langs[i].localeCompare("Python")==0)
			color="w3-blue";
		if(langs[i].localeCompare("Scala")==0)
			color="w3-red";
		out+="<p class='w3-tag "+color+"'>"+langs[i]+"</p>";
	}
  	return out+"</div><br><a href='http://localhost:8080/Alpha-Build/first-prototype/Projects.html' title='Learn More' class='btn read-more btn-sm btn-primary'>Learn More</a>"+
  			"</div></div>";
}

function getLink(projecId)
{
	return "http://localhost:8080/Alpha-Build/first-prototype/AiProjects.html?projectId="+projecId;
}