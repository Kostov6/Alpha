package objects.interfaces;

import javax.ejb.Local;

import objects.Feedback;

@Local
public interface FeedbackInterface {

	public void addFeedback(Feedback json);
	
	public Object[] getFeedbackList(int size,String adminKey);
}
