package endpoints;

import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.interfaces.ModelInterface;
import objects.interfaces.ProjectInterface;


@Path("/models/{projectId}")
public class ModelsEndpoint implements ModelInterface{

	@EJB
	private ModelInterface modelManager;
	
	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("application/json")
    public Object getModelsForProject(@PathParam("projectId") int projectId) {
        return modelManager.getModelsForProject(projectId);
    }
	
	public Object[] getModels(int projectId){
	    return modelManager.getModels(projectId);
	}
}
