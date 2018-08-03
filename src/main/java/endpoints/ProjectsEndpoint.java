package endpoints;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import objects.Project;

@Path("/projects")
public class ProjectsEndpoint {
	
	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("application/json")
    public Object getProjects() {
        return getNProjects();
    }
	
	private Object[] getNProjects()
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
	    EntityManager entitymanager = emfactory.createEntityManager();
	   
	    //TODO check if "use database" is needed and test
	    List<Project> projects=entitymanager.createQuery("SELECT p from objects.Project p ORDER BY p.name ASC ").getResultList();
	    
	    entitymanager.close();
	    emfactory.close();
	    
	    return projects.toArray();
	}
	
	private Object[] getNProjects(int from,int to)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
	    EntityManager entitymanager = emfactory.createEntityManager();
	   
	    //TODO check if "use database" is needed and test
	    List<Project> projects=entitymanager.createQuery("SELECT p from objects.Project p ORDER BY p.name ASC ").getResultList();
	   
	    entitymanager.close();
	    emfactory.close();
	    
	    return projects.subList(from, to).toArray();
	}
	
	
}
