package objects.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
		List models=entitymanager.createNamedQuery("getModelsByProjectId").setParameter("projectId", projectId).getResultList();
	    return models.toArray();
	}

	private void initialize()
	{
		Model model1=new Model(1,1,"erikbern","url1",1,"deep-pink");
		Model model2=new Model(2,1,"lhartikk","url2",2,"simple-chess-ai");
		Model model3=new Model(3,2,"taisukeoe","url2",2,"matsuri-mnist-example");
		
		entitymanager.persist(model1);
		entitymanager.persist(model2);
		entitymanager.persist(model3);
	}

	@Override
	public Object getModelById(int id) {
		return entitymanager.find(Model.class, id );
	}
	
	
}
