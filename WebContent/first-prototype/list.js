
$.getJSON( "http://localhost:8080/Alpha-Build/models/1", function( jsonArray ) {
	$(document).ready(function(){
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				$("#ul-list1").append(createModelElement(jsonObject.name,
											  readmeLink(jsonObject.name,jsonObject.repo))) ;
			}
		);
		$.each(
			array2 ,
			function(i,el) {
				$("#ul-list2").append(createModelElement(el,"https://google.com")) ;
			}
		);
	});
});

function createModelElement(user,readmeUrl)
{
	return "<li onclick=\"setOutput(httpGet('"+readmeUrl+"'))\" >"+user+"</li>";
}

function readmeLink(name,repo)
{
	return "https://raw.githubusercontent.com/"+name+"/"+repo+"/master/README.md";
}