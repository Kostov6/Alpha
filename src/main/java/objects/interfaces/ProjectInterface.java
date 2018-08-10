package objects.interfaces;

import javax.ejb.Local;

@Local
public interface ProjectInterface {

    public Object getProjects();
	
	public Object[] getAllProjects();
	
	public Object[] getNProjects(int from,int to);
	
	
}
