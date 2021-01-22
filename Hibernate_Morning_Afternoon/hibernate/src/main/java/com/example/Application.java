package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Application {

    private static Configuration connectionVar  = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Disha.class);
    private static SessionFactory sessionFactoryVar = connectionVar.buildSessionFactory();

    //Question 1
    public static void saveAlien(){

        Alien alien = new Alien();
        alien.setAid(1002);
        alien.setAname("Laalu");
        alien.setColor("white");
        Session session = sessionFactoryVar.openSession();
        Transaction tx = session.beginTransaction();
        session.save(alien);
        tx.commit();

    }

    //Question 2
    public static Alien retrieveAlien(int id){

        Session session = sessionFactoryVar.openSession();
        Transaction tx = session.beginTransaction();
        Alien alien = (Alien)session.get(Alien.class, id);
        tx.commit();
        return alien;
    }

    //Question 3
    public static void firstLevelCaching(){

        System.out.println("First Level Caching");
        Session session = sessionFactoryVar.openSession();
        Transaction tx = session.beginTransaction();
        Alien alien1 = (Alien)session.get(Alien.class, 1001);
        Alien alien2 = (Alien)session.get(Alien.class, 1001);
        System.out.println(alien1);
        System.out.println(alien2);
        tx.commit();

    }

    //Question 4
    public static void secondLevelCaching(){

        System.out.println("Second Level Caching");
        System.out.println("===Session 1===");
        Session session1 = sessionFactoryVar.openSession();
        Transaction tx1 = session1.beginTransaction();
        Alien alien1 = (Alien)session1.get(Alien.class, 1001);
        System.out.println(alien1);
        tx1.commit();

        System.out.println("===Session 2===");
        Session session2 = sessionFactoryVar.openSession();
        Transaction tx2 = session2.beginTransaction();
        alien1 = (Alien)session2.get(Alien.class, 1001);
        System.out.println(alien1);
        tx2.commit();

    }

    // Question 5
    public static void queryHQL(int id){
        Alien a ;
        Session session1 = sessionFactoryVar.openSession();
        Transaction tx1 = session1.beginTransaction();
        Query q1 = session1.createQuery("from Alien where aid = " + id);
        q1.setCacheable(true);
        a = (Alien) q1.uniqueResult();
        System.out.println(a);
        tx1.commit();

        Session session2 = sessionFactoryVar.openSession();
        Transaction tx2 = session2.beginTransaction();
        Query q2 = session2.createQuery("from Alien where aid = " + id);
        q2.setCacheable(true);
        a = (Alien) q2.uniqueResult();
        System.out.println(a);
        tx2.commit();
    }

    // Question 6
    public static void cachingFiveQuery(){

        Alien alien;
        Session session = sessionFactoryVar.openSession();
        Transaction tx2 = session.beginTransaction();

        //query 1
        Query query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 1");
        System.out.println(alien);

        //query 2
        query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 2");
        System.out.println(alien);

        //query 3
        query = session.createQuery("from Alien where aname = 'Jaadu'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 3");
        System.out.println(alien);

        //query 4
        query = session.createQuery("from Alien where aname = 'Jaadu'");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 4");
        System.out.println(alien);

        //query 5
        query = session.createQuery("from Alien where aid = 1001");
        query.setCacheable(true);
        alien = (Alien) query.uniqueResult();
        System.out.println("Query 5");
        System.out.println(alien);

        tx2.commit();


    }


    public static void main(String [] args){

        System.out.println("Hibernate Assignment");

        //Q1
        saveAlien();

        //Q2
        Alien alienObj = (Alien)retrieveAlien(1001);
        System.out.println(alienObj);

        //Q3
        firstLevelCaching();

        //Q4
        secondLevelCaching();

        //Q5
        queryHQL(1001);

        //Q6
        cachingFiveQuery();

    }

}
