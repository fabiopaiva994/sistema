package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import Classes.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){    
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");         
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();                   
            return cfg.buildSessionFactory(standardServiceRegistry);              
        } catch (Throwable th) {
                System.err.println("Criação inicial do objeto SessionFactory falhou" + th);
                throw new ExceptionInInitializerError(th);
        }
    }
    public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
    
}
