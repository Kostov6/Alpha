package endpoints;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.Model;

@Path("/model/{id}")
public class ModelEndpoint {

	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("application/json")
    public Object getModelById(@PathParam("id") int modelId) {
        
        return findModel(modelId);
    }
	
	private Model findModel(int modelId)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
	    EntityManager entitymanager = emfactory.createEntityManager();
	    
	    Model model = entitymanager.find(Model.class, modelId );

	    System.out.println(model);
	    return model;
	}
}
