package org.gabriel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchingTheData {
    public static void main(String[] args) {

//        Student s2 = null;

        SessionFactory sf = new Configuration() //Maneira refatorada de fazer
                .addAnnotatedClass(org.gabriel.Alien.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

//        s2 = session.find(Student.class, 101);

         Alien a = session.find(Alien.class, 101);
//        Laptop l1 = a.getLaptops();

        session.close();
        sf.close();

//        System.out.println(s2);
//        System.out.println(l1);
    }
}