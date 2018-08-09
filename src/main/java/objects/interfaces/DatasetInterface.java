package objects.interfaces;

import javax.ejb.Local;
import javax.ws.rs.PathParam;

@Local
public interface DatasetInterface {

	public Object getDatasetsForProject(@PathParam("projectId") int projectId);
	
	public Object getDatasetById(@PathParam("id") int id);
}
