package objects.interfaces;

import javax.ejb.Local;

import objects.External;

@Local
public interface ExternalsInterface {

	public void addExternal(External json);
	
	public Object[] getExternalList(int size,String adminKey);
}
