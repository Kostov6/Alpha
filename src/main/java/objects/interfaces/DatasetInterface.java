package objects.interfaces;

import javax.ejb.Local;
import javax.ws.rs.PathParam;

import objects.Dataset;

@Local
public interface DatasetInterface {

	public Object getDatasetsForProject(@PathParam("projectId") int projectId);
	
	public Object getDatasetById(@PathParam("id") int id);
	
	public void addDataset(Dataset json);

	public void initialize();
}
