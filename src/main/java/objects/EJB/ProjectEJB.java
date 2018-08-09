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
	public Object[] getNProjects() {
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
		return getNProjects();
	}
	
	private void initialize()
	{
		Project project = new Project(1, "Chess engine JSON image", "images/img_snowtops.jpg", "supervised", "java");
		entitymanager.persist(project);
	}

}
