
import entities.Student;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Main {
    public static void main (String[] args) {
        SessionFactory sessionFactory = new Configuration ()
                .configure ()
                .buildSessionFactory ();

        EntityManager session= sessionFactory.openSession ();

        TypedQuery<Student> query=session.createQuery ("FROM Student",
                Student.class);
    query.getResultList ().forEach (s-> System.out.println (s.getName ()));
    }
}
