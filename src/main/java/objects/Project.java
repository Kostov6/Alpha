package objects;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="getAllProjects", query="SELECT p FROM Project p ORDER BY p.name ASC")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String image;
	private String type;
	private String lang;
	
	public Project() {
	}

	public Project(int id, String name, String image, String type, String lang) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.type = type;
		this.lang = lang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", image=" + image + ", type=" + type + ", lang=" + lang + "]";
	}
	
	   
}
