package endpoints;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.Feedback;
import objects.interfaces.FeedbackInterface;

@Path("/feedbacks")
public class FeedbackEndpoint implements FeedbackInterface{
	
	@EJB
	private FeedbackInterface feedbackManager;
	
	@PUT
	@Path("/add")
	@Consumes("application/json")
	public void addFeedback(Feedback json) {
		feedbackManager.addFeedback(json);
	}

	@GET
	@Path("/getFeedbackList/{size}/{adminKey}")
    @Produces("application/json")
	public Object[] getFeedbackList(@PathParam("size") int size,@PathParam("adminKey") String adminKey) {
		return feedbackManager.getFeedbackList(size,adminKey);
	}

}
