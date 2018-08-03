package endpoints;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/models/{projectId}")
public class ModelsEndpoint {

	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("application/json")
    public Object getModelsForProject(@PathParam("projectId") int projectId) {
        
        return getModels(projectId);
    }
	
	private Object[] getModels(int projectId)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
	    EntityManager entitymanager = emfactory.createEntityManager();
	   
	    //TODO check if "use database" is needed and test
	    List models=entitymanager.createQuery("SELECT m from objects.Model m WHERE m.projectId = " + projectId).getResultList();
	    entitymanager.close();
	    emfactory.close();
	    
	    return models.toArray();
	}
}
