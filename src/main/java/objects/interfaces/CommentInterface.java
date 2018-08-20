package objects.interfaces;

import javax.ejb.Local;

import objects.Comment;

@Local
public interface CommentInterface {

	public Object getCommentsForProject(int projectId);
	
	public void addComment(Comment json);
	
	public void initialize();
}
