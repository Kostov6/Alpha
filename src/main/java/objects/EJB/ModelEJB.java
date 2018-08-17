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

	public void initialize()
	{
		Model[] models= {
				new Model(1,"erikbern","url1",1,"deep-pink"),
				new Model(1,"lhartikk","url2",2,"simple-chess-ai"),
				new Model(2,"taisukeoe","url2",2,"matsuri-mnist-example")
		};
		
		for(Model model: models)
			entitymanager.persist(model);
	}

	@Override
	public void addModel(Model model)
	{
		entitymanager.persist(model);
	}
	
	@Override
	public Object getModelById(int id) {
		return entitymanager.find(Model.class, id );
	}
	
	
}
