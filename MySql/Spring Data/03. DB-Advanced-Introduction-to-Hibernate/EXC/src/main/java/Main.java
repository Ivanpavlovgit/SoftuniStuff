import entities.Employee;
import entities.Town;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.internal.expression.function.UpperFunction;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory ("soft_uni");
        EntityManager em = factory
                .createEntityManager ();

        em.getTransaction ().begin ();

        CriteriaBuilder cb       = em.getCriteriaBuilder ();
       TypedQuery<Town> townTypedQuery= em.createQuery ( "SELECT t FROM Town t WHERE LENGTH(t.name)>5 ",Town.class);
        List<Town>      resultList = townTypedQuery.getResultList ();
        System.out.println (resultList);
        for (Town town : resultList) {

            String name=town.getName ().toUpperCase ();
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
