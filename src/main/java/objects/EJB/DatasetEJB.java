package objects.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import objects.Dataset;
import objects.Model;
import objects.interfaces.DatasetInterface;

@Stateless
public class DatasetEJB implements DatasetInterface{
	
	@PersistenceContext(unitName = "Alpha-Build")
	private EntityManager entitymanager;

	@Override
	public Object getDatasetsForProject(int projectId) {
		//initialize();
		List models=entitymanager.createNamedQuery("getDatasetsByProjectId").setParameter("projectId", projectId).getResultList();
	    return models.toArray();
	}

	@Override
	public void addDataset(Dataset dataset)
	{
		entitymanager.persist(dataset);
	}
	
	public void initialize()
	{
		Dataset[] datasets= {
				new Dataset(1,"Kostov6","https://raw.githubusercontent.com/Kostov6/test-repo/master/MNIST.ser")
		};
		
		for(Dataset dataset: datasets)
			entitymanager.persist(dataset);
	}
	
	@Override
	public Object getDatasetById(int id) {
		return entitymanager.find(Dataset.class, id);
	}
	
}
