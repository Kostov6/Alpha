package objects.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
				new Project(1, "Chess engine", "images/chess-engine.jpeg", "supervised", "java"),
				new Project(2, "Symbol recognition", "images/hand-digits.png", "supervised", "java")
		};
		
		for(Project project: projects)
			entitymanager.persist(project);
	}

}
