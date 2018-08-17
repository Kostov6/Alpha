package objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="getCommentsByProjectId", query="SELECT c FROM Comment c WHERE c.projectId = :projectId")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int projectId;
	private String name;
	private String avatarUrl;
	private String comment;
	
	public Comment()
	{
	}
	
	public Comment(int projectId, String name, String avatarUrl, String comment) {
		this.projectId = projectId;
		this.name = name;
		this.avatarUrl = avatarUrl;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", projectId=" + projectId + ", name=" + name + ", avatarUrl=" + avatarUrl
				+ ", comment=" + comment + "]";
	}
	
	
	
	
	
}
