package org.gabriel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {

        //Devs
        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Gabriel");
        a1.setTech("Java");

        Alien a2 = new Alien();
        a2.setAid(102);
        a2.setAname("Ricardo");
        a2.setTech("Python");

        //Os laptops
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Lenovo");
        l1.setModel("IdeaPad");
        l1.setRam(12);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS 13");
        l2.setRam(16);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("MacBook Pro");
        l3.setRam(32);

        a1.setLaptops(List.of(l1, l2));
        a2.setLaptops(List.of(l3));

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.gabriel.Alien.class)
                .addAnnotatedClass(org.gabriel.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.persist(a1);
            session.persist(a2);

            session.persist(l1);
            session.persist(l2);
            session.persist(l3);
//            session.merge(s1);

            transaction.commit();

            Alien a5 = session.find(Alien.class, 101);

            session.close();

            Session session2 = sf.openSession();
            Alien a6 = session2.find(Alien.class, 101);

            session2.close();

//            System.out.println(a5.getLaptops());

        } catch (Exception e) {
            // 2. Se der erro, desfazemos tudo (Rollback)
            e.printStackTrace();

        } finally {
//            session.close();
            sf.close();
        }
    }
}