package objects.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import objects.Comment;
import objects.Model;
import objects.interfaces.CommentInterface;

@Stateless
public class CommentEJB implements CommentInterface{

	@PersistenceContext(unitName = "Alpha-Build")
	private EntityManager entitymanager;

	@Override
	public Object getCommentsForProject(int projectId) {

		List models=entitymanager.createNamedQuery("getCommentsByProjectId").setParameter("projectId", projectId).getResultList();
	    return models.toArray();
	}
	
	public void initialize()
	{
		Comment[] comments= {
				new Comment(1,"Kostov6","https://avatars2.githubusercontent.com/u/14108745?s=400&v=4","Content1"),
				new Comment(1,"eclipse","https://avatars1.githubusercontent.com/u/56974?s=200&v=4","Content2")
		};
		
		for(Comment comment:comments)
			entitymanager.persist(comment);
	}

	@Override
	public void addComment(Comment json) {
		entitymanager.persist(json);
	}
}
