package endpoints;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import objects.Project;


@Path("/project/{id}")
public class ProjectEndpoint {
	
	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("application/json")
    public Object getProjectById(@PathParam("id") int projectId) {
        
        return findProject(projectId);
    }
	
	private Project findProject(int projectId)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
	    EntityManager entitymanager = emfactory.createEntityManager();
	    
	    Project project = entitymanager.find( Project.class, projectId );

	    System.out.println(project);
	    return project;
	}
	
	public static void main(String[] args) {
		createTestProject();
	}
	
	private static void createTestProject() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Project project = new Project(1,"Chess engine JSON image","images/img_snowtops.jpg","supervised","java");

		entitymanager.persist(project);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}
