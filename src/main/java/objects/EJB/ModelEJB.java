package objects.EJB;

import java.util.ArrayList;
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
				new Model(1,"erikbern","url1","Python","deep-pink"),
				new Model(1,"lhartikk","url2","Java","simple-chess-ai"),
				new Model(2,"taisukeoe","url2","Python","matsuri-mnist-example")
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

//	@Override
//	public String getLanguagesForProject(int projectId) {
//		List modelsList=entitymanager.createNamedQuery("getModelsByProjectId").setParameter("projectId", projectId).getResultList();
//	    Model[] models=(Model[])modelsList.toArray();
//	    ArrayList<String> langs=new ArrayList<String>();
//	    for(Model model : models)
//	    {
//	    	if(!langs.contains(model.getLanguage())) 
//	    		langs.add(model.getLanguage());
//	    }
//	    StringBuilder composed=new StringBuilder();
//	    for(String lang : langs)
//	    	composed.append(lang+";");
//	    
//	    return composed.toString();
//	}
	
	
}
