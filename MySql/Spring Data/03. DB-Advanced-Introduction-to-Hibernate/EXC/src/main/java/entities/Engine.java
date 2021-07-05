package entities;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Comparator;
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
        System.out.println ("Hello !");
        System.out.println ("Exercises: Introduction to Hibernate");

        try {
            System.out.println ("Do you want to select a task (YES/NO)");
            String input = bufferedReader.readLine ();
            while (!input.equalsIgnoreCase ("NO")) {
                if (input.equalsIgnoreCase ("YES")) {
                    System.out.println ("Select task number");
                    int taskNum = Integer.parseInt (bufferedReader.readLine ());
                    switch (taskNum) {
                        case 2 -> task2 ();
                        case 3 -> task3 ();
                        case 4 -> task4 ();
                        case 5 -> task5 ();
                        case 6 -> task6 ();
                        case 7 -> task7 ();
                        case 8 -> task8 ();
                        case 9 -> task9 ();
                        case 10 -> task10 ();
                        case 11 -> task11 ();
                        case 12 -> task12 ();
                        case 13 -> task13 ();

                    }
                    System.out.println ("Do you want to select another task (YES/NO)");
                } else {
                    System.out.println ("Incorrect input");
                    System.out.println ("Please write YES,NO or a task number (int)");
                }
                input = bufferedReader.readLine ();

            }
            System.out.println ("Have a nice day!");
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
                .createQuery ("SELECT t FROM  Town t " +
                                "WHERE t.name=:t_name",
                        Town.class)
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
        List<Address> addresses = entityManager
                .createQuery ("SELECT a FROM Address a " +
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
        System.out.println ("Task 12 : Employees Maximum Salaries");
      List<Object[]> rows = entityManager
                .createNativeQuery ("SELECT d.name, MAX(e.salary) AS `max_salary`\n" +
                        "FROM departments d\n" +
                        "         join employees e on d.department_id = e.department_id\n" +
                        "group by d.name\n" +
                        "HAVING `max_salary` not between 30000 and 70000;")
                .getResultList ();
        for (Object[] row : rows) {
            System.out.printf ("%s %.2f%n",row[0],row[1]);
        }

    }

    private void task11 () throws IOException {
        System.out.println ("Task 11 : Find Employees by First Name");
        System.out.println ("Enter pattern to search :");
        var input = bufferedReader.readLine ().concat ("%");
        entityManager
                .createQuery ("SELECT e FROM Employee e WHERE e.firstName LIKE :f_name",
                        Employee.class)
                .setParameter ("f_name",input)
                .getResultStream ()
                .forEach (employee -> {
                    System.out.printf ("%s %s - %s - ($%.2f)%n",
                            employee.getFirstName (),
                            employee.getLastName (),
                            employee.getJobTitle (),
                            employee.getSalary ());
                });


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

    private void task9 () {
        System.out.println ("Task 9 : Find Latest 10 Projects");

        entityManager
                .createQuery ("SELECT p FROM Project p " +
                                "ORDER BY p.startDate DESC",
                        Project.class)
                .setMaxResults (10)
                .getResultStream ()
                .sorted (Comparator.comparing (Project::getName))
                .forEach (project -> {
                    System.out.printf ("""
                                    Project name: %s
                                     \tProject Description: %s%n""",
                            project.getName (),
                            project.getDescription ());
                    System.out.printf (" \tProject Start Date:%tF %tT.%tL%n",
                            project.getStartDate (),
                            project.getStartDate (),
                            project.getStartDate ()
                    );
                    if (String.valueOf (project.getEndDate ()).equals ("null")) {
                        System.out.printf (" \tProject End Date: null%n");
                    } else {
                        System.out.printf (" \tProject Start Date:%tF %tT.%tL%n",
                                project.getEndDate (),
                                project.getEndDate (),
                                project.getEndDate ()
                        );
                    }
                });
    }

    private void task8 () throws IOException {
        System.out.println ("Task 8 : Get Employee with Project");
        System.out.println ("Enter employee id(int) :");
        var employeeId = Integer.parseInt (bufferedReader.readLine ());
        var employee = entityManager
                .find (Employee.class,employeeId);

        System.out.printf ("%s %s - %s%n",
                employee.getFirstName (),
                employee.getLastName (),
                employee.getJobTitle ());

        employee
                .getProjects ()
                .stream ()
                .sorted (Comparator.comparing (Project::getName))
                .forEach (project -> System.out.println (project.getName ()));

    }

    private void task7 () {
        System.out.println ("Task 7 : Addresses with Employee Count");
        entityManager
                .createQuery ("SELECT a FROM Address a ORDER BY a.employees.size DESC",
                        Address.class)
                .setMaxResults (10)
                .getResultStream ()
                .forEach (address -> {
                    System.out.printf ("%s - %d employees%n",
                            address.getText (),
                            address.getEmployees ().size ());
                });

    }

    private void task6 () throws IOException {
        System.out.println ("Enter employee last name");
        String lastName = bufferedReader.readLine ();
        Employee employee = entityManager
                .createQuery ("SELECT e FROM Employee  e " +
                        "WHERE e.lastName=:l_name",Employee.class)
                .setParameter ("l_name",lastName)
                .getSingleResult ();

        Address address = createAddress ();

        employee.setLastName (lastName);
        employee.setAddress (address);
        entityManager.getTransaction ().begin ();

        entityManager.persist (employee);

        entityManager.getTransaction ().commit ();
    }

    private Address createAddress () {
        Address address = new Address ();
        address.setText ("Vitoshka 15");
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
