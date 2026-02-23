package org.gabriel;

import jdk.swing.interop.SwingInterOpUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

// DA - UV -XT - M

public class Hql {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.gabriel.Laptop.class)
                .addAnnotatedClass(org.gabriel.Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        Transaction transaction = null;

        try {
            //Query sem o Query<AlgumaCoisa> é chamada de "Raw Type" que desliga os alertas de segurança do compilador.
//            Query query = session.createQuery("from Laptop", Alien.class);
//            List<Laptop> laptops = query.getResultList();
//
//            System.out.println(laptops);
//
//            Query q2 = session.createQuery("from Alien");
//            List<Alien> aliens = q2.getResultList();
//
//            System.out.println(aliens);

            String brand = "Apple";

//            Query query = session.createQuery("from Laptop  where brand = :marca and ram > :memoria");
//            query.setParameter("marca", brand);
//            query.setParameter("memoria", 8);
//            List<Laptop> laptops = query.getResultList();
//            System.out.println(laptops);

            Query q3 = session.createQuery("select brand, model, ram from Laptop where brand like ?1");
            q3.setParameter(1, brand);
            List<Object[]> laptops = q3.getResultList();
            System.out.println(laptops);

            for(Object[] data : laptops) {
                System.out.println((String)data[0] + " " + (String)data[1] + " " + (int) data[2]);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            session.close();
            sf.close();
        }
    }
}