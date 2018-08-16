package trash;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import objects.Dataset;
import objects.Model;
import objects.Project;

public class InitializingDatabases 
{
	public static void main(String[] args) {
		//initializeModels();
		//initializeDataset();
		initializeProjects();
	}
	
	private static void initializeModels()
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Model model1 = new Model(1,"Gosho","/gitUrl",3,"repoName 1");
		Model model2 = new Model(1,"Pehso","/gitUrl2",2,"repoName 2");
		Model model3 = new Model(2,"Chvetcho","/gitUrl3",0,"repoName 3");

		entitymanager.persist(model1);
		entitymanager.persist(model2);
		entitymanager.persist(model3);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
	
	private static void initializeDataset()
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
//
//		Dataset dataset1 = new Dataset(1,1,"Gosho","/gitUrl",3,1);
//		Dataset dataset2 = new Dataset(2,1,"Pehso","/gitUrl2",2,2);
//		Dataset dataset3 = new Dataset(3,2,"Chvetcho","/gitUrl3",0,3);

//		entitymanager.persist(dataset1);
//		entitymanager.persist(dataset2);
//		entitymanager.persist(dataset3);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
	
	private static void initializeProjects()
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Alpha-Build");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

//		Project project = new Project(1,"Chess engine JSON image","images/img_snowtops.jpg","supervised","java");

//		entitymanager.persist(project);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}
