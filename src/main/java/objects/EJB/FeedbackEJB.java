package objects.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import objects.Feedback;
import objects.Project;
import objects.interfaces.FeedbackInterface;

@Stateless
public class FeedbackEJB implements FeedbackInterface {
	
	@PersistenceContext(unitName = "Alpha-Build")
	private EntityManager entitymanager;
	
	@Override
	public void addFeedback(Feedback json) {
		entitymanager.persist(json);
	}

	@Override
	public Object[] getFeedbackList(int size,String adminKey) {
		String adminKeyValue="8A3B612D00Ca1d62Aac37d946482dc2e";
		
		if(!adminKey.equals(adminKeyValue))
			return null;
		
		 List feedbacks = entitymanager.createNamedQuery("getAllFeedbacks").getResultList();
		 if(feedbacks.size()<=size)
			 return feedbacks.toArray();
		 
		 return feedbacks.subList(0, size).toArray();
		 
		
	}

}
