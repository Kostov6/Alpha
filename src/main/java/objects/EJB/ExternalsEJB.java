package objects.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import objects.External;
import objects.interfaces.ExternalsInterface;

@Stateless
public class ExternalsEJB implements ExternalsInterface {

	@PersistenceContext(unitName = "Alpha-Build")
	private EntityManager entitymanager;
	
	@Override
	public void addExternal(External json) {
		entitymanager.persist(json);
	}

	@Override
	public Object[] getExternalList(int size, String adminKey) {
		String adminKeyValue="8A3B612D00Ca1d62Aac37d946482dc2e";
		
		if(!adminKey.equals(adminKeyValue))
			return null;
		
		List externals = entitymanager.createNamedQuery("getAllExternals").getResultList();
		if(externals.size()<=size)
			 return externals.toArray();
		 
		 return externals.subList(0, size).toArray();
	}

}
