$(document).ready(function(){
	$.getJSON("http://localhost:8080/Alpha-Build/models/getByProjectId/"+getProjectId(), function( jsonArray ) {
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#ul-list1").append(createModelElement(jsonObject.name,
											  readmeLink(jsonObject.name,jsonObject.repo))) ;
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

function createDatasetElement(user,datasetUrl)
{
	return "<li onclick=\"window.open('"+datasetUrl+"','_blank')\" >"+user+"</li>";
}

function createModelElement(user,readmeUrl)
{
	return "<li onclick=\"setOutput(httpGet('"+readmeUrl+"'))\" >"+user+"</li>";
}

function readmeLink(name,repo)
{
	return "https://raw.githubusercontent.com/"+name+"/"+repo+"/master/README.md";
}