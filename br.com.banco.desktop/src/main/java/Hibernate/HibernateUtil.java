package hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import Classes.*;
public class HibernateUtil {
    private static SessionFactory factory;
    static {
        AnnotationConfiguration cfg = new AnnotationConfiguration();
       // Set<String> stringPropertyNames = cfg.getProperties().stringPropertyNames();
        cfg.addAnnotatedClass(Cliente.class);
        cfg.addAnnotatedClass(Conta.class);
        cfg.addAnnotatedClass(ContaCorrenteComum.class);
        cfg.addAnnotatedClass(ContaCorrenteLimitada.class);
        cfg.addAnnotatedClass(ContaPoupanca.class);
        cfg.addAnnotatedClass(Deposito.class);
        cfg.addAnnotatedClass(Endereco.class);
        cfg.addAnnotatedClass(Extrato.class);
        cfg.addAnnotatedClass(Pessoa.class);
        factory = cfg.buildSessionFactory();
    }
    public static Session getSession() {
        return factory.openSession();
    }
}