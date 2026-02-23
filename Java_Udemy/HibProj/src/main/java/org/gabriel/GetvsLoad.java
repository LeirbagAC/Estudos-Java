package org.gabriel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;


public class GetvsLoad {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.gabriel.Laptop.class)
                .addAnnotatedClass(org.gabriel.Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = null;

        try {

//            Laptop l1 = session.load(Laptop.class, 2);
//            System.out.println(l1);

//            Laptop l1 = session.get(Laptop.class, 2);
//            System.out.println(l1);

//            Laptop l2 = session.byId(Laptop.class).getReference(2);
//            System.out.println(l2);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            sf.close();
        }
    }
}