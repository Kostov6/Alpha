package objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="getModelsByProjectId", query="SELECT m FROM Model m WHERE m.projectId = :projectId ORDER BY m.name ASC")
public class Model {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int projectId;
	private String name;
	private String repo;
	private String gitUrl;
	private int gitStars;
	
	public Model() {
	}

	public Model(int projectId, String name, String gitUrl, int gitStars,String repo) {
		this.projectId = projectId;
		this.name = name;
		this.gitUrl = gitUrl;
		this.gitStars = gitStars;
		this.repo=repo;
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

	public String getGitUrl() {
		return gitUrl;
	}

	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}

	public int getGitStars() {
		return gitStars;
	}

	public void setGitStars(int gitStars) {
		this.gitStars = gitStars;
	}

	public String getRepo() {
		return repo;
	}

	public void setRepo(String repo) {
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", projectId=" + projectId + ", name=" + name + ", repo=" + repo + ", gitUrl="
				+ gitUrl + ", gitStars=" + gitStars + "]";
	}


	
	
}
