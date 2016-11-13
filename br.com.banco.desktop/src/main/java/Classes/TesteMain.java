/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javax.swing.JOptionPane;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import Hibernate.*;

/**
 *
 * @author FábioJunior
 */
public class TesteMain {
    public static void main(String []args) {
        Session sessao = null;
        sessao = HibernateUtil.getSessionFactory().openSession();
        JOptionPane.showMessageDialog(null, "Conectou");
    }
}
