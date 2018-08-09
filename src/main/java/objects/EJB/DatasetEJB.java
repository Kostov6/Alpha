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
		List models=entitymanager.createNamedQuery("getAllDatasets").getResultList();
	    return models.toArray();
	}

	private void initialize()
	{
		Dataset dataset1=new Dataset(1,1,"eclipse","http://localhost:8080/Alpha-Build/datasets/getById/1",1,0.5f);
		Dataset dataset2=new Dataset(2,1,"erikbern","http://localhost:8080/Alpha-Build/datasets/getById/1",2,0.9f);
		entitymanager.persist(dataset1);
		entitymanager.persist(dataset2);
	}
	
	@Override
	public Object getDatasetById(int id) {
		return entitymanager.find(Dataset.class, id);
	}
	
}
