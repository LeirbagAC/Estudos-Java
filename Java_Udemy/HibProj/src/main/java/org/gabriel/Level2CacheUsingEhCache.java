package org.gabriel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class Level2CacheUsingEhCache {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.gabriel.Laptop.class)
                .addAnnotatedClass(org.gabriel.Alien.class)
                .configure()
                .buildSessionFactory();

        // --- SESSÃO 1 ---
        Session session1 = sf.openSession();
        try {
            System.out.println("--- Sessão 1 ---");
            Laptop l1 = session1.find(Laptop.class, 1); // Select no Banco
            System.out.println(l1);

            Laptop l2 = session1.find(Laptop.class, 1); // Pega do L1 (Cache da sessão)
            System.out.println(l2);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session1.close(); // Fecha a sessão 1 (L1 morre aqui)
        }

        // --- SESSÃO 2 ---
        // A fábrica (sf) CONTINUA ABERTA aqui. É nela que o Cache L2 vive.

        Session session2 = sf.openSession();
        try {
            System.out.println("--- Sessão 2 ---");
            // Se o L2 estiver configurado, aqui NÃO DEVE ter Select
            Laptop l3 = session2.find(Laptop.class, 1);
            System.out.println(l3);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session2.close();
        }

        // Só fecha a fábrica no final de tudo
        sf.close();
    }
}
