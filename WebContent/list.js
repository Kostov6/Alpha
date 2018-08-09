
var array1=["Pesho","Gosho","Strincho","Vaflo"];
var array2=[1,2,3];
var jsonArray;

//$.getJSON( "http://localhost:8080/Alpha-Build/projects", function( json ) {
//	jsonArray=json;
//});

function createElement(content,href)
{
	return "<li><a style='text-decoration:none;' href='"+href+"' >"+content+"</a></li>";
}

$(document).ready(function(){
	$.each(
		array1 ,
		function(i,el) {
			$("#ul-list1").append(createElement(el,"https://google.com")) ;
		}
	);
	$.each(
		array2 ,
		function(i,el) {
			$("#ul-list2").append(createElement(el,"https://google.com")) ;
		}
	);
});