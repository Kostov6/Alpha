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
				//framework
				new Model(1,"haifengl","smile","Java"),
				new Model(1,"sebig3000","MachineLearning","Java"),
				new Model(1,"ICT-BDA","EasyML","Java","./img/","https://raw.githubusercontent.com/ICT-BDA/EasyML/master/img/"),
				new Model(1,"eriklindernoren","ML-From-Scratch","Python"),
				
				//image recognition
				new Model(2,"aleju","imgaug","Python","images/","https://raw.githubusercontent.com/aleju/imgaug/master/images/"),
				new Model(2,"tzutalin","labelImg","Python","README.rst"),
				new Model(2,"thammegowda","tika-dl4j-spark-imgrec","Java"),
				
				//Chess
				new Model(3,"erikbern","deep-pink","Python"),
				new Model(3,"lhartikk","simple-chess-ai","JavaScript"),
				
				//other
				new Model(4,"kaiwaehner","kafka-streams-machine-learning-examples","Java","readme.md"),
				new Model(4,"clips","pattern","Python"),
				
				//handwriting recognition
				new Model(5,"taisukeoe","matsuri-mnist-example","Scala"),
				new Model(5,"ayushoriginal","HandWritingRecognition-CNN","Python"),
				
			
				
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

	@Override
	public Object getRepo(int projectId, String name) {
		List models=entitymanager.createQuery("SELECT m FROM Model m WHERE m.projectId = :projectId AND m.name=:name").setParameter("projectId", projectId).setParameter("name", name).getResultList();
		if(models.size()==0)
			return null;
		return models.get(0);
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
