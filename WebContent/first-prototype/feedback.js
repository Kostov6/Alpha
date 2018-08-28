function submitFeedback()
{
	var name=document.getElementById("name").value;
	var email=document.getElementById("email").value;
	var message=document.getElementById("message").value;
	var feedbackJson={
		name: name,
		email: email,
		message: message
	};
	addFeedback(feedbackJson);
	window.alert("Feedback send");
}

function addFeedback(feedbackJson)
{
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/Alpha-Build/feedbacks/add",
		contentType: "application/json",
		data: JSON.stringify(feedbackJson)
	});
}