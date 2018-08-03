package endpoints;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.Dataset;


@Path("/dataset/{id}")
public class DatasetEndpoint {

	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("application/json")
    public Object getDatasetById(@PathParam("id") int datasetId) {
        
        return findDataset(datasetId);
    }
	
	private Dataset findDataset(int datasetId)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
	    EntityManager entitymanager = emfactory.createEntityManager();
	    
	    Dataset dataset = entitymanager.find(Dataset.class, datasetId );

	    System.out.println(dataset);
	    return dataset;
	}
}
