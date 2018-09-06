package endpoints;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	
	
	@GET
    @Produces("application/json")
	@Path("/featured")
	public Object[] getFeaturedProjects() {
		return projectManager.getFeaturedProjects();
	}
	
	
	public Object[] getAllProjects(){
		return projectManager.getAllProjects();
	}
	
	public Object[] getNProjects(int from,int to){
		return projectManager.getNProjects(from, to);
	}
	
	@GET
	@Path("/initialize")
	public void initialize() {
		projectManager.initialize();
	}


	@POST
	@Path("/newLanguageString/{projectId}/{language}")
	public void commitLanguage(@PathParam("projectId") int projectId,@PathParam("language") String language) {
		projectManager.commitLanguage(projectId, language);
	}


	@GET
	@Path("/languageString/{projectId}")
    @Produces("text/plain")
	public String getLanguageString(@PathParam("projectId") int projectId) {
		return projectManager.getLanguageString(projectId);
	}




	
}
