package endpoints;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.Comment;
import objects.Model;
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
	
	@PUT
	@Path("/add")
	@Consumes("application/json")
    public void addComment(Comment json){
		commentManager.addComment(json);
    }
}
