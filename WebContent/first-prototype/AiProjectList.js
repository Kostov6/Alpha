$(document).ready(function(){
	$.getJSON("http://localhost:8080/Alpha-Build/models/getByProjectId/"+getProjectId(), function( jsonArray ) {
		var lang=getLangFilter();
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				if(lang!=null)
				{	
					if(lang.localeCompare(jsonObject.language)==0){
						$("#ul-list1").append(createModelElement(jsonObject.name,jsonObject.language,
											  readmeLink(jsonObject.name,jsonObject.repo))) ;
					}
				}
				else
				{
					$("#ul-list1").append(createModelElement(jsonObject.name,jsonObject.language,
							  readmeLink(jsonObject.name,jsonObject.repo))) ;	
				}
			}
		);
	});
	$.getJSON( "http://localhost:8080/Alpha-Build/datasets/getByProjectId/"+getProjectId(), function( jsonArray ) {
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#ul-list2").append(createDatasetElement(jsonObject.name,
											  			   jsonObject.url)) ;
			}
		);
	});
});



function getProjectId()
{
	var url_string = window.location.href
	var url = new URL(url_string);
	var c = url.searchParams.get("projectId");
	console.log(c);
	return c;
}

function getLangFilter()
{
	var url_string = window.location.href
	var url = new URL(url_string);
	var c = url.searchParams.get("lang");
	console.log(c);
	return c;
}


function createDatasetElement(user,datasetUrl)
{
	return "<li onclick=\"window.open('"+datasetUrl+"','_blank')\" >"+user+"</li>";
}

function createModelElement(user,lang,readmeUrl)
{
	return "<li onclick=\"setOutput(httpGet('"+readmeUrl+"'))\" >"+getModelContent(user,lang)+"</li>";
}

function getModelContent(user,lang)
{
	var color="w3-yellow";
	if(lang.localeCompare("Python")==0)
		color="w3-blue";
	return "<div>"+user+"<div class='w3-tag "+color+"' style='float:right'>"+lang+"</div></div>";
}

function readmeLink(name,repo)
{
	return "https://raw.githubusercontent.com/"+name+"/"+repo+"/master/README.md";
}