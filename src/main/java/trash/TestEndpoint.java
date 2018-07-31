package trash;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/employees/{employee}")
public class TestEndpoint {

	@GET
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("application/json")
    public Object geEmployee(@PathParam("employee") int employeeId) {
        
        return findEmployee(employeeId);
    }
	
	private static Employee findEmployee(int employeeId)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
	    EntityManager entitymanager = emfactory.createEntityManager();
	    Employee employee = entitymanager.find( Employee.class, employeeId );

	    System.out.println(employee);
	    return employee;
	}
}
