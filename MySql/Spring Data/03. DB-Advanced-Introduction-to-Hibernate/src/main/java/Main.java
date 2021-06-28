
import entities.Student;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main (String[] args) {

        SessionFactory sessionFactory = new Configuration ()
                .configure ()
                .buildSessionFactory ();
        Session session = sessionFactory.openSession ();
        session.beginTransaction ();
        Student pesho = new Student ();
        Student mesho = new Student ();
        pesho.setName ("purviqt1");
        mesho.setName ("vtoriqt2");
        session.save (mesho);
        session.save (pesho);
        session.getTransaction ().commit ();
    }
}
