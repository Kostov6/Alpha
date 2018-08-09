package endpoints;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import objects.interfaces.ProjectInterface;

@Path("/projects")
public class ProjectsEndpoint implements ProjectInterface {
	
	@EJB
	private ProjectInterface projectManager;
    
	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("application/json")
    public Object getProjects() {
		return projectManager.getProjects();
    }
	
	
	
	public Object[] getNProjects()
	{
		return projectManager.getNProjects();
	}
	
	public Object[] getNProjects(int from,int to)
	{
		return projectManager.getNProjects(from, to);
	}
	
	
}
