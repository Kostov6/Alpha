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
	
	private void initialize()
	{
//		Dataset dataset1=new Dataset(1,"eclipse","http://localhost:8080/Alpha-Build/datasets/getById/1",1,0.5f);
//		Dataset dataset2=new Dataset(1,"erikbern","http://localhost:8080/Alpha-Build/datasets/getById/1",2,0.9f);
//		entitymanager.persist(dataset1);
//		entitymanager.persist(dataset2);
		Dataset testDataset=new Dataset(1,"Kostov6","https://raw.githubusercontent.com/Kostov6/test-repo/master/MNIST.ser",1,1);
		entitymanager.persist(testDataset);
	}
	
	@Override
	public Object getDatasetById(int id) {
		return entitymanager.find(Dataset.class, id);
	}
	
}
