package Hibernate;

import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil1 {

    private static SessionFactory factory;

    public static Session getSession(Object a) {
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        Set<String> stringPropertyNames = cfg.getProperties().stringPropertyNames();
        cfg.addAnnotatedClass(a.getClass());
        factory = cfg.buildSessionFactory();
        return factory.openSession();
    }
}
