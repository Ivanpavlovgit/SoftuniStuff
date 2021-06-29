import entities.Engine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainaChocho {
    public static void main (String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory ("nqkvoime");

        EntityManager entityManager = emf
                .createEntityManager ();
        Engine engine=new Engine (entityManager);
        engine.run ();
    }
}
