package org.gabriel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class Main {
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

        Alien a3 = new Alien();
        a3.setAid(103);
        a3.setAname("João");
        a3.setTech("Php");

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

        Laptop l4 = new Laptop();
        l4.setLid(4);
        l4.setBrand("Apple");
        l4.setModel("MacBook Mini");
        l4.setRam(16);

        //Como o Alien é o "dono" ele que seta os laptops
        a1.setLaptops(List.of(l1, l2, l3));
        a2.setLaptops(List.of(l2, l3));
        a3.setLaptops(List.of(l1, l4));

        //Isso não muda nada na parte do banco, pois o hibernate ignora. Porém, na parte do java essa informação fica salva na memória e é uma boa prática de programação
//        l1.setAliens(List.of(a1, a3));
//        l2.setAliens(List.of(a1, a2));
//        l3.setAliens(List.of(a1, a2));

        /* A SessionFactory é um objeto "pesado". Geralmente, existe apenas uma SessionFactory para toda a aplicação.
         Ela é responsável por criar as Sessions. Pense nela como uma "fábrica de conexões" configurada. */
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.gabriel.Alien.class)
                .addAnnotatedClass(org.gabriel.Laptop.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            session.persist(a1); //Persist para criar e merge para ‘update’, mas caso o registro para ‘update’ não exista ele cria normalmente
            session.persist(a2);
            session.persist(a3);

            session.persist(l1);
            session.persist(l2);
            session.persist(l3);
            session.persist(l4);
//            session.merge(s1);

            transaction.commit();

            Alien a5 = session.find(Alien.class, 102);
            System.out.println(a5);

//            List<Alien> donos = l1.getAliens();
//            System.out.println(donos);

        } catch (Exception e) {
            // 2. Se der erro, desfazemos tudo (Rollback)
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            session.close();
            sf.close();
        }
    }
}