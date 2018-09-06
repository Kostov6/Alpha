function importDataset(projectId,user)
{
	if(user==null)
	{
		//user not logged
		return;
	}

	console.log(projectId+":"+user.user);
	$.getJSON("http://localhost:8080/Alpha-Build/models/getRepo/"+projectId+"/"+user,function(jsonObject){
		var repo=jsonObject.repo;
		putDataset(projectId,user,getRawLink(user,repo));
	});
	
}


function getRawLink(user,repo)
{
	var datasetName="dataset.ser";
	return "https://raw.githubusercontent.com/"+user+"/"+repo+"/master/"+datasetName;
}

function putDataset(projectId,user,link)
{
	var jsonDataset={
		projectId:parseInt(projectId),
		name:user,
		url:link
	};
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/Alpha-Build/datasets/addDataset",
		contentType: "application/json",
		data: JSON.stringify(jsonDataset)
	});
	
}