
$.getJSON( "http://localhost:8080/Alpha-Build/models/getByProjectId/1", function( jsonArray ) {
	$(document).ready(function(){
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#ul-list1").append(createModelElement(jsonObject.name,
											  readmeLink(jsonObject.name,jsonObject.repo))) ;
			}
		);
	});
});

$.getJSON( "http://localhost:8080/Alpha-Build/datasets/getByProjectId/1", function( jsonArray ) {
	$(document).ready(function(){
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#ul-list2").append(createDatasetElement(jsonObject.name,
											  			   jsonObject.url)) ;
			}
		);
	});
});

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