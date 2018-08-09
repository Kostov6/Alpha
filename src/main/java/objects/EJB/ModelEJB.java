package objects.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import objects.Model;
import objects.interfaces.ModelInterface;

@Stateless
public class ModelEJB implements ModelInterface{

	@PersistenceContext(unitName = "Alpha-Build")
	private EntityManager entitymanager;

	@Override
	public Object getModelsForProject(int projectId) {
		//initialize();
		return getModels(projectId);
	}

	@Override
	public Object[] getModels(int projectId) {
	   
	    //TODO check if "use database" is needed and test
	    List models=entitymanager.createNamedQuery("getAllModels").getResultList();
	    return models.toArray();
	}
	
	private void initialize()
	{
		Model model1=new Model(1,1,"eclipse","url1",1,"che");
		Model model2=new Model(2,1,"erikbern","url2",2,"deep-pink");

		entitymanager.persist(model1);
		entitymanager.persist(model2);
	}
	
	
}
