/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package safety.model.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Jair
 */
public class HibernateUtil {
    
//    private static SessionFactory sessionFactory;
//    
//    private static SessionFactory setUp(){
//	// A SessionFactory is set up once for an application!
//	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//			.configure("safety/hibernate.cfg.xml") // configures settings from hibernate.cfg.xml
//			.build();
//	
//	return 	sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//    }
//    
//    public static Session getSession() {
//        return setUp().openSession();
//    }
    
    
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
            return getEntityManagerFactory().createEntityManager();
    }

    private static EntityManagerFactory getEntityManagerFactory() {
//        if ( emf == null ) {
//                Bundle thisBundle = FrameworkUtil.getBundle( HibernateUtil.class );
//                // Could get this by wiring up OsgiTestBundleActivator as well.
//                BundleContext context = thisBundle.getBundleContext();
//
//                ServiceReference serviceReference = context.getServiceReference(PersistenceProvider.class.getName());
//                PersistenceProvider persistenceProvider = (PersistenceProvider)context.getService(serviceReference);
//
//                emf = persistenceProvider.createEntityManagerFactory( "safety-persistence", null );
//        }

        emf = Persistence.createEntityManagerFactory("safety-persistence");
        return emf;
    }
    
   
}
