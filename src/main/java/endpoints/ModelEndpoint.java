package endpoints;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.interfaces.ModelInterface;


@Path("/models")
public class ModelEndpoint implements ModelInterface{

	@EJB
	private ModelInterface modelManager;
	
	@GET
	@Path("/getByProjectId/{projectId}")
    @Produces("application/json")
    public Object getModelsForProject(@PathParam("projectId") int projectId) {
        return modelManager.getModelsForProject(projectId);
    }
	
	
	@GET
	@Path("/getById/{id}")
	@Produces("application/json")
	public Object getModelById(@PathParam("id") int id)
	{
		return modelManager.getModelById(id);
	}
}
