package objects.interfaces;

import javax.ejb.Local;

@Local
public interface ProjectInterface {

    public Object getProjects();
	
    public Object[] getFeaturedProjects();
    
	public Object[] getAllProjects();
	
	public Object[] getNProjects(int from,int to);
	
	public void commitLanguage(int projectId,String language);
	
	public String getLanguageString(int projectId);
	
	public void initialize();
	
	
}
