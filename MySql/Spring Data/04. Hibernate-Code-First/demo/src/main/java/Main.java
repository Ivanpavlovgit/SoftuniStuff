import Entity.Product;
import Entity.Sale;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main (String[] args) {
        EntityManager em =
                Persistence
                        .createEntityManagerFactory ("cfatestvamtuka")
                        .createEntityManager ();
      
        em.getTransaction ().begin ();

/*

        Sale sale = new Sale ();
        sale.setDate (LocalDateTime.now ());

        Product product = new Product ();
        product.setName ("testProduct")
                .setPrice (BigDecimal.TEN)
                .setQuantity (5)
                .getSales ().add (sale);

        sale.setProduct (product);

        em.persist (product);
*/

   /*     Product found = em.find (Product.class,1L);
        em.remove (found);*/
        em.getTransaction ().commit ();
    }
}
