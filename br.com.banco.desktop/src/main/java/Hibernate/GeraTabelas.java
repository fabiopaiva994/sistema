package Hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import Classes.*;
public class GeraTabelas {
    private static final long serialVersionUID = 1L;
    public static void main(String[] args) {
        // Cria uma configuracao para a classe Produto
        AnnotationConfiguration cfg = new AnnotationConfiguration();
        cfg.addAnnotatedClass(Cliente.class);
        //cfg.addAnnotatedClass(Conta.class);
        cfg.addAnnotatedClass(ContaCorrenteComum.class);
        cfg.addAnnotatedClass(ContaCorrenteLimitada.class);
        cfg.addAnnotatedClass(ContaPoupanca.class);
        cfg.addAnnotatedClass(Extrato.class);
        //cfg.addAnnotatedClass(Pessoa.class);
        /*cfg.addAnnotatedClass(Mensalidade.class);
        cfg.addAnnotatedClass(Exercicio.class);
        cfg.addAnnotatedClass(Exercicios.class);*/
        //cfg.addAnnotatedClass(Exercicio.class); 
        //cfg.addAnnotatedClass(Treino.class);
        //cfg.addAnnotatedClass(ExercicioTreino.class);
        //cfg.addAnnotatedClass(Login2.class);
        //..poderia adicionar outras classes...
        new SchemaExport(cfg).create(true, true);
    }
}