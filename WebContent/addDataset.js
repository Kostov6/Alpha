
function uploadFiles()
{
	var fileInput=document.getElementById("dataset-file");
	$.each(fileInput.files,function(i,file){
		var reader = new FileReader();
		reader.onload = fileToArrayFinished;
		reader.readAsArrayBuffer(file);
	});
}

function fileToArrayFinished(event)
{
	var buffer=event.target.result;
	var url="http://localhost:8080/Alpha-Build/datasets/datasetListener"
		
//	$.post(url,buffer,function( data ) {console.log(data);},"application/octet-stream")
//	  .done(function() {
//		    console.log( "second success" );
//		  })
//		  .fail(function() {
//			  console.log( "error" );
//		  })
//		  .always(function() {
//			  console.log( "finished" );
//		  });
		
	var request = new XMLHttpRequest();
	request.open("PUT", url, true);
	request.onload = function (oEvent) {
	  console.log("onloaded");
	};
	request.setRequestHeader("Content-Type","application/octet-stream");

	request.send(buffer);
}
