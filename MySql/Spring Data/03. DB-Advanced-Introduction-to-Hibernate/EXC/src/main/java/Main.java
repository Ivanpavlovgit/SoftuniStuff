import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory ("nqkvoime");
        EntityManager em = factory
                .createEntityManager ();

        em.getTransaction ().begin ();


        TypedQuery<Town> townTypedQuery =
                em.createQuery ("SELECT t FROM Town t WHERE LENGTH(t.name)>5 ",Town.class);
        List<Town>       resultList     = townTypedQuery.getResultList ();
        System.out.println (resultList);
        for (Town town : resultList) {
            String name = town.getName ().toLowerCase ();
            em.detach (town);
            town.setName (name);
            Town merge = em.merge (town);
            em.persist (merge);
        }
        em.getTransaction ().commit ();
        System.out.println ("detached");




        /*CriteriaBuilder cb     = em.getCriteriaBuilder ();
        Query           select = em.createNativeQuery ("SELECT t.name FROM towns AS t WHERE CHAR_LENGTH(t.name)>5");
        Query           update = em.createNativeQuery ("UPDATE towns AS t SET t.name=lower(t.name) WHERE CHAR_LENGTH(t.name)>5");


        EntityTransaction transaction = em.getTransaction ();
        transaction.begin ();
        update.executeUpdate ();
        transaction.commit ();
        System.out.println (select.getResultList ());*/


    }
}
