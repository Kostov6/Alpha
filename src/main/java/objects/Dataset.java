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
	
	public Dataset() {
	}

	public Dataset(int projectId, String name, String url) {
		this.projectId = projectId;
		this.name = name;
		this.url = url;
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


}
