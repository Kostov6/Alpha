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
	private String language;
	
	//aditional
	private String otherImgSrc;
	private String imgFolder;
	private String imgDomain;
	private String readme;
	
	public Model() {
	}

	public Model(int projectId, String name,String repo,String language) {
		this.projectId = projectId;
		this.name = name;
		this.repo=repo;
		this.language = language;
		
		this.otherImgSrc="no";
		this.readme="README.md";
	}
	
	

	public Model(int projectId, String name, String repo, String language, String readme) {

		this.projectId = projectId;
		this.name = name;
		this.repo = repo;
		this.language = language;
		
		this.otherImgSrc="no";
		this.readme = readme;
	}

	
	
	public Model(int projectId, String name, String repo, String language, String imgFolder, String imgDomain) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.repo = repo;
		this.language = language;
		
		this.otherImgSrc="yes";
		this.imgFolder = imgFolder;
		this.imgDomain = imgDomain;
		this.readme="README.md";
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getRepo() {
		return repo;
	}

	public void setRepo(String repo) {
		this.repo = repo;
	}

	public String getOtherImgSrc() {
		return otherImgSrc;
	}

	public void setOtherImgSrc(String otherImgSrc) {
		this.otherImgSrc = otherImgSrc;
	}

	public String getImgFolder() {
		return imgFolder;
	}

	public void setImgFolder(String imgFolder) {
		this.imgFolder = imgFolder;
	}

	public String getImgDomain() {
		return imgDomain;
	}

	public void setImgDomain(String imgDomain) {
		this.imgDomain = imgDomain;
	}

	public String getReadme() {
		return readme;
	}

	public void setReadme(String readme) {
		this.readme = readme;
	}

	
	
	
	
}
