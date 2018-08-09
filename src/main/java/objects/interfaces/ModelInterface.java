package objects.interfaces;

import javax.ejb.Local;
import javax.ws.rs.PathParam;

@Local
public interface ModelInterface {

	public Object getModelsForProject(@PathParam("projectId") int projectId);
	
	public Object getModelById(@PathParam("id") int id);
		
}
