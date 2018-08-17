package objects.interfaces;

import javax.ejb.Local;

@Local
public interface CommentInterface {

	public Object getCommentsForProject(int projectId);
	
	public void initialize();
}
