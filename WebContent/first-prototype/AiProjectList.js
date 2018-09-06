

$(document).ready(function(){
	$.getJSON("http://localhost:8080/Alpha-Build/models/getByProjectId/"+getProjectId(), function( jsonArray ) {
		var lang=getLangFilter();
		$.each(
			jsonArray ,
			function(i,jsonObject) {
				if(lang!=null)
				{	
					if(lang.localeCompare(jsonObject.language)==0){
						$("#ul-list1").append(createModelElement(jsonObject)) ;
					}
				}
				else
				{
					$("#ul-list1").append(createModelElement(jsonObject)) ;	
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

function createModelElement(jsonObject)
{
	return "<li onclick=\"modelClicked('"+jsonObject.name+"','"+jsonObject.repo+"','"+jsonObject.otherImgSrc+"','"+jsonObject.imgFolder+"','"+jsonObject.imgDomain+"','"+jsonObject.readme+"')\" >"+getModelContent(jsonObject.name,jsonObject.language)+"</li>";
}

var activeLink="https://github.com";

function modelClicked(name,repo,otherImgSrc,imgFolder,imgDomain,readme)
{
	if(otherImgSrc.localeCompare("no")==0)
	{
		setOutput(httpGet(readmeLink(name,repo,readme)));
	}
	if(otherImgSrc.localeCompare("yes")==0)
	{
		console.log("setOutput(testReplace(readmeLink("+
				name+","+repo+","+readme+"),"+imgFolder+","+imgDomain+"))");
		setOutput(testReplace(readmeLink(name,repo,readme),imgFolder,imgDomain))
	}
	activeLink="https://github.com/"+name+"/"+repo;
}

function getModelContent(user,lang)
{
	var color="w3-yellow";
	if(lang.localeCompare("Python")==0)
		color="w3-blue";
	if(lang.localeCompare("Scala")==0)
		color="w3-red";
	return "<div>"+user+"<div class='w3-tag "+color+"' style='float:right'>"+lang+"</div></div>";
}

function readmeLink(name,repo,readme)
{
	return "https://raw.githubusercontent.com/"+name+"/"+repo+"/master/"+readme;
}