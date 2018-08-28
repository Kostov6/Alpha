package endpoints;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.External;
import objects.interfaces.ExternalsInterface;


@Path("/externals")
public class ExternalsEndpoint implements ExternalsInterface {

	@EJB
	private ExternalsInterface externalsManager;
	
	@GET
	@Path("/getExternalList/{size}/{adminKey}")
    @Produces("application/json")
	public Object[] getExternalList(@PathParam("size") int size, @PathParam("adminKey") String adminKey) {
		return externalsManager.getExternalList(size, adminKey);
	}

	@PUT
	@Path("/add")
	@Consumes("application/json")
	public void addExternal(External json) {
		externalsManager.addExternal(json);
	}

}
