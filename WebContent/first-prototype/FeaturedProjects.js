

$(document).ready(function(){
	$.getJSON( "http://localhost:8080/Alpha-Build/projects", function( jsonArray ) {
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				if(i==0){
					$("#featured-container").append(createFeaturedProjectElement(jsonObject)) ;
					$("#featured-container").append(createFeaturedProjectElement(jsonObject)) ;
					$("#featured-container").append(createFeaturedProjectElement(jsonObject)) ;
				}
			}
		);
	});
});

function createFeaturedProjectElement(jsonObject)
{
	return "<div class='col-md-4'><div class='entry'><div class='entry-media'>"+
  			"<a href='"+getLink(jsonObject.id)+"' title=''><span class='absolute-wrapper'></span>"+
  			"<img src='"+jsonObject.image+"' alt='' class='img-responsive' /></a></div><h3 class='entry-title'>"+
  			"<a href='"+getLink(jsonObject.id)+"' title='"+jsonObject.name+"'>"+jsonObject.name+"</a></h3>"+
  			"<p class='w3-tag w3-yellow'>"+jsonObject.lang+"</p>"+
  			"<br><a href='http://localhost:8080/Alpha-Build/first-prototype/Projects.html' title='Learn More' class='btn read-more btn-sm btn-primary'>Learn More</a>"+
  			"</div></div>";
}

function getLink(projecId)
{
	return "http://localhost:8080/Alpha-Build/first-prototype/AiProjects.html?projectId="+projecId;
}