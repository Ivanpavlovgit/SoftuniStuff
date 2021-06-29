package entities;

import com.sun.source.tree.TryTree;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.xml.bind.SchemaOutputResolver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader bufferedReader;

    public Engine (EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader (new InputStreamReader (System.in));
    }

    @Override
    public void run () {
        System.out.println ("Select task number");

        try {
            int taskNum = Integer.parseInt (bufferedReader.readLine ());

            switch (taskNum) {
                case 2 -> task2 ();
            }

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    private void task2 () {
        entityManager.getTransaction ().begin ();
        Query query = entityManager
                .createQuery ("UPDATE Town t SET t.name=UPPER(t.name) WHERE LENGTH(t.name)<=5");
        query.executeUpdate ();
        entityManager.getTransaction ().commit ();
    }
}
///Може ли ако остане време да обясниш кога и защо слагаме ,Еntity.class накрая на зявка