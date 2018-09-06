package objects.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import objects.Model;
import objects.Project;
import objects.interfaces.ProjectInterface;

@Stateless
public class ProjectEJB implements ProjectInterface {

	@PersistenceContext(unitName = "Alpha-Build")
	private EntityManager entitymanager;

	@Override
	public Object[] getAllProjects() {
	    //TODO check if "use database" is needed and test
	    List<Project> projects = entitymanager.createNamedQuery("getAllProjects").getResultList();
	    for(Project p: projects)
	    	System.out.println(p);
	    return projects.toArray();
	}

	@Override
	public Object[] getNProjects(int from, int to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProjects() {

		//initialize();
		return getAllProjects();
	}
	
	public void initialize()
	{
		Project[] projects= {
				new Project(1,"Frameworks","images/open-source-framwroks-for-AI-development.png","Java;Python;"),
				new Project(2,"Image recognition","images/Image-Recognition-and-Analysis-Help-Your-Brand-1.png","Python;Java;"),
				new Project(3,"Chess engine", "images/chess-engine.jpeg", "Python;JavaScript;"),
				new Project(4,"Other projects","images/ai-other.jpg","Java;Python;"),
				new Project(5,"Symbol recognition", "images/hand-digits.png", "Scala;Python;"),
				new Project(6,"Approximation","images/NLAFI.png","")
				
		};
		
		for(Project project: projects)
			entitymanager.persist(project);
	}

	@Override
	public Object[] getFeaturedProjects() {
		Project[] projects= {
				new Project(3,"Chess engine", "images/chess-engine.jpeg", "Python;JavaScript;"),
				new Project(2,"Image recognition","images/Image-Recognition-and-Analysis-Help-Your-Brand-1.png","Python;Java;"),
				new Project(5,"Symbol recognition", "images/hand-digits.png", "Scala;Python;"),
				
		};
		
		return projects;
	}

	@Override
	public void commitLanguage(int projectId, String language) {
		Project project=entitymanager.find(Project.class, projectId);
		String[] langs=project.getLang().split(";");
		for(String lang:langs)
		{
			if(lang.equals(language))
			{
				return;
			}
		}
		
		//extend language string
		String newLanguageString=new String(project.getLang());
		newLanguageString+=language+";";
		
		
	}

	@Override
	public String getLanguageString(int projectId) {
		Project project=entitymanager.find(Project.class, projectId);
		return project.getLang();
	}

}
