package endpoints;



import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.Dataset;
import objects.Model;
import objects.interfaces.DatasetInterface;


@Path("/datasets")
public class DatasetEndpoint implements DatasetInterface{

	@EJB
	private DatasetInterface datasetManager;
	
	@GET
	@Path("/getByProjectId/{projectId}")
    @Produces("application/json")
    public Object getDatasetsForProject(@PathParam("projectId") int projectId) {
        return datasetManager.getDatasetsForProject(projectId);
    }
	
	
	@PUT
	@Path("/datasetListener")
	@Consumes("application/octet-stream")
    public void datasetListener(String json)
    {
		System.out.println(json.length());
    }
	
	@PUT
	@Path("/addDataset")
	@Consumes("application/json")
    public void addDataset(Dataset json)
    {
		datasetManager.addDataset(json);
    }
	
	@GET
	@Path("/getById/{id}")
	@Produces("application/json")
	public Object getDatasetById(@PathParam("id") int id)
	{
		return datasetManager.getDatasetById(id);
	}


	@GET
	@Path("/initialize")
	public void initialize() {
		datasetManager.initialize();
		
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	public Response getFile() {
//		File file = null; // Initialize this to the File path you want to serve.
//
//		return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
//				.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" ) //optional
//				.build();
//	}
}
