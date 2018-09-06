package objects.interfaces;

import javax.ejb.Local;
import javax.ws.rs.PathParam;

import objects.Model;


@Local
public interface ModelInterface {

	public Object getModelsForProject(@PathParam("projectId") int projectId);
	
	//lopublic String getLanguagesForProject(@PathParam("projectId") int projectId);
	
	public Object getRepo(int projectId,String name);
	
	public Object getModelById(@PathParam("id") int id);
	
	public void addModel(Model json);
	
	public void initialize();
}
