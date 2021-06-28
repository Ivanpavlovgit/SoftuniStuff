import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;


public class taskForExc {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";
    private static final BufferedReader reader =
            new BufferedReader (new InputStreamReader (System.in));
    private static Connection connection;

    public static void main (String[] args) throws IOException, SQLException {
// Enter your MYSQL server username and password in definition of getConnection()
// if you want to run the tasks faster
// Enjoy... :)
        connection = getConnection ();

        System.out.println ("Enter task number:");
        int taskNum = Integer.parseInt (reader.readLine ());
        switch (taskNum) {
            case 2 -> task2 ();
            case 3 -> task3 ();
            case 4 -> task4 ();
            case 5 -> task5 ();
            case 7 -> task7 ();
            case 8 -> task8 ();
            case 9 -> task9 ();
        }
        taskSeparator ();
    }


    private static void task9 () throws IOException, SQLException {
        System.out.println ("9.Increase Age Stored Procedure");
        System.out.println ("Enter minion id :");
        int minionId = Integer.parseInt (reader.readLine ());
        CallableStatement callableStatement = connection
                .prepareCall ("CALL usp_get_older(?)");
        callableStatement.setInt (1,minionId);
        callableStatement.executeUpdate ();


    }

    private static void task8 () throws IOException, SQLException {
        System.out.println ("Increase Minions Age");
        System.out.println ("Enter minions id's separated by whitespace EG: 1 2 3");
        List<Integer> input = Arrays.stream (reader.readLine ().split (" "))
                .mapToInt (Integer::parseInt)
                .boxed ()
                .collect (Collectors.toList ());

        CallableStatement callableStatement = connection
                .prepareCall ("CALL usp_get_older(?)");
        for (Integer minionId : input) {
            callableStatement.setInt (1,minionId);
            callableStatement.executeUpdate ();
        }
    }

    private static void task7 () throws SQLException {
        System.out.println ("7.Print All Minion Names");
        PreparedStatement preparedStatement = connection.prepareStatement ("SELECT name FROM minions");
        ResultSet         resultSet         = preparedStatement.executeQuery ();
        List<String>      allMinionsNames   = new ArrayList<> ();
        while (resultSet.next ()) {
            allMinionsNames.add (resultSet.getString (1));
        }
        int start = 0;
        int end   = allMinionsNames.size () - 1;
        for (int i = 0; i < allMinionsNames.size (); i++) {
            System.out.println (i % 2 == 0
                    ? allMinionsNames.get (start++) : allMinionsNames.get (end--));
        }
        taskSeparator ();
    }

    private static void task5 () throws IOException, SQLException {
        System.out.println ("5.Change Town Names Casing !");
        System.out.println ("Enter Country name");
        String countryName = reader.readLine ();

        PreparedStatement preparedStatement = connection
                .prepareStatement ("UPDATE towns SET name=UPPER(name) where country=?");
        preparedStatement.setString (1,countryName);

        int affectedRows = preparedStatement.executeUpdate ();
        if (affectedRows == 0) {
            System.out.println ("No town names!");
            return;
        }
        System.out.printf ("%d town names were affected.%n",affectedRows);
        PreparedStatement preparedStatementTowns = connection.prepareStatement ("SELECT name FROM towns WHERE country=?");
        preparedStatementTowns.setString (1,countryName);
        ResultSet resultSet = preparedStatementTowns.executeQuery ();
        while (resultSet.next ()) {
            System.out.println (resultSet.getString ("name"));
        }
    }

    private static void task4 () throws SQLException, IOException {
        System.out.println ("4.Add Minion");
        System.out.println ("Enter information about the minion to be inserted : name age town");

        String[] minionInfo = reader.readLine ().split (" ");
        String   minionName = minionInfo[1];
        int      minionAge  = Integer.parseInt (minionInfo[2]);
        String   minionTown = minionInfo[3];

        String[] villainInfo = reader.readLine ().split (" ");
        String   villainName = villainInfo[1];

        int               town_id;
        PreparedStatement getCountOfAllTowns = connection.prepareStatement ("SELECT COUNT(DISTINCT t.`id`) FROM `towns` AS t;");
        ResultSet         countAllTowns      = getCountOfAllTowns.executeQuery ();
        countAllTowns.next ();
        town_id = countAllTowns.getInt (1);

        PreparedStatement searchTowns = connection.prepareStatement ("SELECT t.`id` FROM `towns` AS t WHERE t.`name`=?;");
        searchTowns.setString (1,minionTown);
        ResultSet rsTowns = searchTowns.executeQuery ();

        if (!rsTowns.next ()) {
            PreparedStatement addTown = connection.prepareStatement (" INSERT INTO `towns`(`name`) VALUES (?);");
            addTown.setString (1,minionTown);
            addTown.executeUpdate ();
            System.out.printf ("Town %s added to the database.%n",minionTown);
        } else {
            town_id = rsTowns.getInt ("id");
        }


        //PreparedStatement searchVillains = connection.prepareStatement ("SELECT v.`id` FROM `villains` AS v WHERE v.`name`=?;");
        searchTowns.setString (1,villainName);
        ResultSet rsVillains = searchTowns.executeQuery ();

        if (!rsVillains.next ()) {
            PreparedStatement addVillain = connection.prepareStatement ("INSERT INTO `villains`(name, evilness_factor) VALUES (?,'evil');");
            addVillain.setString (1,villainName);
            addVillain.executeUpdate ();
            System.out.printf ("Villain %s was added to the database.%n",villainName);
        }

        PreparedStatement addMinion = connection.prepareStatement ("INSERT INTO `minions`(`name`,`age`,`town_id`) VALUES (?,?,?);");
        addMinion.setString (1,minionName);
        addMinion.setInt (2,minionAge);
        addMinion.setInt (3,town_id);
        addMinion.executeUpdate ();

        PreparedStatement linkMinionToVillain = connection.prepareStatement ("INSERT INTO `minions_villains`(`minion_id`,`villain_id`)  VALUES (?,?);");

        PreparedStatement getIdOfMinion = connection.prepareStatement ("SELECT m.`id` FROM `minions`AS m WHERE m.`name`=?;");
        getIdOfMinion.setString (1,minionName);
        ResultSet minionId = getIdOfMinion.executeQuery ();
        minionId.next ();
        int minionIdInt = minionId.getInt ("id");

        PreparedStatement getIdOfVillain = connection.prepareStatement ("SELECT v.`id` FROM `villains`AS v WHERE v.`name`=?;");
        getIdOfVillain.setString (1,villainName);
        ResultSet villainId = getIdOfVillain.executeQuery ();
        villainId.next ();
        int villainIdInt = villainId.getInt (1);

        linkMinionToVillain.setInt (1,minionIdInt);
        linkMinionToVillain.setInt (2,villainIdInt);
        linkMinionToVillain.executeUpdate ();

        System.out.printf ("Successfully added %s to be minion of %s%n",minionName,villainName);
    }

    private static void task3 () throws SQLException, IOException {
        System.out.println ("3.Get Minion Names");
        System.out.println ("Enter the desired villain's ID:");

        int villainId = Integer.parseInt (reader.readLine ());

        PreparedStatement preparedStatement = connection.prepareStatement ("""
                SELECT\s
                    v.`name`, m.`name`, m.`age`
                FROM
                    `minions` AS m
                        JOIN
                    `minions_villains` AS mv ON m.`id` = mv.`minion_id`
                        JOIN
                    `villains` AS v ON mv.`villain_id` = v.`id`
                WHERE
                    v.`id` = ?
                ORDER BY v.`name`;""");

        preparedStatement.setInt (1,villainId);
        ResultSet resultSet = preparedStatement.executeQuery ();

        int counter = 0;

        if (!resultSet.next ()) {
            System.out.printf ("No villain with ID %d exists in the database.%n",villainId);
        } else {
            while (resultSet.next ()) {
                if (counter == 0) {
                    System.out.printf ("Villain: %s%n",resultSet.getString (1));
                }
                System.out.printf ("%d. %s  %s%n",
                        ++counter,
                        resultSet.getString (2),
                        resultSet.getString (3));
            }
        }
    }

    private static void task2 () throws SQLException {
        System.out.println ("2.Get Villains’ Names");
        PreparedStatement preparedStatement = connection.prepareStatement ("""
                SELECT\s
                    v.`name`, COUNT( DISTINCT m.`id`) AS `count_minion_army`
                FROM
                    `villains` AS v
                        LEFT JOIN
                    `minions_villains` AS mv ON v.`id` = mv.`villain_id`
                        LEFT JOIN
                    `minions` AS m ON mv.`minion_id` = m.`id`
                GROUP BY v.`name`
                HAVING `count_minion_army`> 15
                ORDER BY `count_minion_army` DESC;""");
        ResultSet resultSet = preparedStatement.executeQuery ();

        while (resultSet.next ()) {
            System.out.printf ("%s %d %n",resultSet.getString (1),resultSet.getInt (2));
        }
    }

   /* private static findEntityNameById (String tableName,int entityId) {
        String query = "SELECT name From ? WHERE id=?";
        PreparedStatement preparedStatement =
                connection.prepareStatement (query);
        preparedStatement.setString (1,tableName);
        preparedStatement.setInt (2,entityId);
        ResultSet resultSet=preparedStatement.executeQuery ();
        resultSet.next ();
        return resultSet.getString (1);
    }*/

    private static Connection getConnection () throws IOException, SQLException {
        System.out.println ("Enter User:");
        String user = reader.readLine ();
        System.out.println ("Enter Password:");
        String     password   = reader.readLine ();
        Properties properties = new Properties ();
        properties.setProperty ("user",user);
        properties.setProperty ("password",password);
        return DriverManager.
                getConnection (CONNECTION_STRING + DB_NAME,properties);
    }

    private static void taskSeparator () {
        System.out.println ("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    }
}