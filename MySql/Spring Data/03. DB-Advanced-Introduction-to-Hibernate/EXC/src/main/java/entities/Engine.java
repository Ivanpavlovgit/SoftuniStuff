package entities;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;


public class Engine implements Runnable {
    private final EntityManager entityManager;
    private final BufferedReader bufferedReader;

    public Engine (EntityManager entityManager) {
        this.entityManager = entityManager;
        this.bufferedReader = new BufferedReader (new InputStreamReader (System.in));
    }

    @Override
    public void run () {


        try {
            System.out.println ("Do you want to select a task (YES/NO)");
            String input = bufferedReader.readLine ();
            while (!input.equals ("NO")) {
                if (input.equals ("YES")) {
                    System.out.println ("Select task number");
                    int taskNum = Integer.parseInt (bufferedReader.readLine ());
                    switch (taskNum) {
                        case 2 -> task2 ();
                        case 3 -> task3 ();
                        case 4 -> task4 ();
                        case 5 -> task5 ();
                        case 6 -> task6 ();
                        case 8 -> task8 ();
                        case 10 -> task10 ();
                        case 12 -> task12 ();
                        case 13 -> task13 ();

                    }
                    System.out.println ("Do you want to select another task (YES/NO)");
                    input = bufferedReader.readLine ();
                } else {
                    System.out.println ("Incorrect input");
                    System.out.println ("Please write YES,NO or a task number (int)");
                    input = bufferedReader.readLine ();
                }

            }
            if (input.equals ("NO")) {
                System.out.println ("Have a nice day!");
            }

        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            entityManager.close ();
        }
    }

    private void task13 () throws IOException {
        System.out.println ("Task 13 : Remove Towns");
        System.out.println ("Enter town name to delete:");
        String townName = bufferedReader.readLine ();

        Town town = entityManager
                .createQuery ("SELECT t FROM  Town t WHERE t.name=:t_name",Town.class)
                .setParameter ("t_name",townName)
                .getSingleResult ();

        int affectedRows = removeAddressByTownId (town.getId ());

        entityManager.getTransaction ().begin ();
        entityManager.remove (town);
        entityManager.getTransaction ().commit ();
        System.out.printf ("%d address in %s is deleted !%n",
                affectedRows,townName);
    }

    private int removeAddressByTownId (Integer id) {
        List<Address> addresses = entityManager.createQuery ("SELECT a FROM Address a " +
                "WHERE a.town.id=:p_id",Address.class)
                .setParameter ("p_id",id)
                .getResultList ();
        entityManager.getTransaction ().begin ();
        addresses.forEach (entityManager::remove);
        entityManager.getTransaction ().commit ();
        return addresses.size ();
    }

    @SuppressWarnings("unchecked")
    private void task12 () {
        List<Object[]> rows = entityManager
                .createNativeQuery ("SELECT d.name, MAX(e.salary) AS `max_salary`\n" +
                        "FROM departments d\n" +
                        "         join employees e on d.department_id = e.department_id\n" +
                        "group by d.name\n" +
                        "HAVING `max_salary` not between 30000 and 70000;")
                .getResultList ();

        //TODO:finish
    }

    private void task10 () {
        System.out.println ("Task 10 : Increase Salaries");
        entityManager.getTransaction ().begin ();
        int affectedRows = entityManager
                .createQuery ("UPDATE Employee e " +
                        "SET e.salary=e.salary*1.12 " +
                        "WHERE e.department.id IN :ids")
                .setParameter ("ids",Set.of (1,2,4,11))
                .executeUpdate ();
        entityManager.getTransaction ().commit ();
        System.out.printf ("Salaries of %d employees increased.",affectedRows);

    }

    private void task8 () {
        //TODO:finish this
        Employee employee = entityManager.find (Employee.class,147);
    }

    private void task6 () throws IOException {
        //TODO:finish this
        System.out.println ("Enter employee last name");
        String lastName = bufferedReader.readLine ();
        Employee employee = entityManager
                .createQuery ("SELECT e FROM Employee  e " +
                        "WHERE e.lastName=:l_name",Employee.class)
                .setParameter ("l_name",lastName)
                .getSingleResult ();

        Address address = createAddress ("Vitoshka 15");
    }

    private Address createAddress (String addressText) {
        //TODO:finish this
        Address address = new Address ();
        address.setText (addressText);
        entityManager.getTransaction ().begin ();
        entityManager.persist (address);
        entityManager.getTransaction ().commit ();
        return address;
    }

    private void task5 () {
        System.out.println ("Task 5 : Employees from Department");
        entityManager
                .createQuery ("SELECT e FROM Employee  e " +
                        "WHERE e.department.name=:d_name " +
                        "ORDER BY e.salary,e.id",Employee.class)
                .setParameter ("d_name","Research and Development")
                .getResultStream ()
                .forEach (employee -> {
                    System.out.printf ("%s %s from %s - $%.2f%n",
                            employee.getFirstName (),
                            employee.getLastName (),
                            employee.getDepartment ().getName (),
                            employee.getSalary ());
                });
    }

    private void task4 () {
        System.out.println ("Task : 4. Employees with Salary Over 50 000");
        entityManager.createQuery ("SELECT e FROM Employee  e WHERE e.salary>:min_salary"
                ,Employee.class)
                .setParameter ("min_salary",BigDecimal.valueOf (50000L))
                .getResultStream ()
                .map (Employee::getFirstName)
                .forEach (System.out::println);
    }

    private void task3 () throws IOException {
        System.out.println ("Task 3 : Contains Employee");
        System.out.println ("Enter employee full name :");
        String[] fullName   = bufferedReader.readLine ().split ("\\s+");
        String   first_name = fullName[0];
        String   last_name  = fullName[1];
        var resultList = entityManager
                .createQuery ("SELECT e FROM Employee e WHERE e.firstName=:f_name and e.lastName=:l_name")
                .setParameter ("f_name",first_name)
                .setParameter ("l_name",last_name)
                .getResultList ();


        System.out.println (
                resultList.size () == 0
                        ? "No Employee with that name"
                        : "Employee found");
    }

    private void task2 () {
        System.out.println ("Task 2 : Change Casing");
        entityManager.getTransaction ().begin ();
        Query query = entityManager
                .createQuery ("UPDATE Town t SET t.name=UPPER(t.name) WHERE LENGTH(t.name)<=5");
        query.executeUpdate ();
        entityManager.getTransaction ().commit ();
    }
}
