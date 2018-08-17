package endpoints;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.interfaces.CommentInterface;

@Path("/comments")
public class CommentsEndpoint implements CommentInterface{

	@EJB
	private CommentInterface commentManager;

	@GET
	@Path("/getByProjectId/{projectId}")
    @Produces("application/json")
    public Object getCommentsForProject(@PathParam("projectId") int projectId) {
        return commentManager.getCommentsForProject(projectId);
    }

	@GET
	@Path("/initialize")
	public void initialize() {
		commentManager.initialize();
	}
	
    
}
