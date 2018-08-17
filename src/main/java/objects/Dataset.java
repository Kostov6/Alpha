package objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="getDatasetsByProjectId", query="SELECT d FROM Dataset d WHERE d.projectId = :projectId ORDER BY d.name ASC")
public class Dataset {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int projectId;
	private String name;
	private String url;
	private int stars;
	private float size;
	
	public Dataset() {
	}

	public Dataset(int projectId, String name, String url, int stars, float size) {
		this.projectId = projectId;
		this.name = name;
		this.url = url;
		this.stars = stars;
		this.size = size;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Dataset [id=" + id + ", projectId=" + projectId + ", name=" + name + ", url=" + url + ", stars=" + stars
				+ ", size=" + size + "]";
	}
	
	
}
