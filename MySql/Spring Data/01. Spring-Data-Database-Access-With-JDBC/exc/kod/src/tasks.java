import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class tasks {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "minions_db";
    private static final Properties userPass = new Properties ();
    private static final BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
    static Connection connection;

    public static void main (String[] args) throws SQLException, IOException {
        connection = getConnection ();

/* 1
Write a program that prints on the console all villains’ names and their number of minions.
Get only the villains who have more than 15 minions.
Order them by number of minions in descending order.*/
        // firstTask (connection);
/*2.
Get Minion Names
Write a program that prints on the console all minion names and their age for given villain id.
For the output, use the formats given in the examples.*/
        //  secondTask (connection);
        thirdTask (connection);

        //  fourthTask (connection);
        //   seventhTask (connection);
    }

    private static void seventhTask (Connection connection) throws SQLException {
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
    }

    private static void fourthTask (Connection connection) throws IOException, SQLException {
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

    private static String findEntityNameById (String tableName,int entityId) throws SQLException {
        String            query             = String.format ("Select name From %s WHERE id=?",tableName);
        PreparedStatement preparedStatement = connection.prepareStatement (query);
        preparedStatement.setInt (1,entityId);
        //TODO: watch and finish this
        return "finish this";
    }

    private static Connection getConnection () throws IOException, SQLException {
        //  System.out.println ("Enter your username");
        //  String userName = tasks.reader.readLine ();
        //  System.out.println ("Enter your password");
        //  String password = tasks.reader.readLine ();
        userPass.setProperty ("user","root");
        userPass.setProperty ("password","7878");

        return DriverManager
                .getConnection (CONNECTION_STRING + DB_NAME,userPass);
    }

    private static void taskSeparator () {
        System.out.println ("- - - - - - - - - - - - - - - - - -");
    }

    private static void firstTask (Connection connection) throws SQLException {
        System.out.println ("First Task:");
        String task_1 = """
                SELECT\s
                    v.`name`, COUNT( DISTINCT m.`id`) AS `count_minion_army`
                FROM
                    `villains` AS v
                        LEFT JOIN
                    `minions_villains` AS mv ON v.`id` = mv.`villain_id`
                        LEFT JOIN
                    `minions` AS m ON mv.`minion_id` = m.`id`
                GROUP BY v.`name`
                HAVING `count_minion_army`>15
                ORDER BY `count_minion_army` DESC;""";

        PreparedStatement preparedStatement = connection.prepareStatement (task_1);
        ResultSet         rs                = preparedStatement.executeQuery ();
        while (rs.next ()) {
            System.out.printf ("%s  %s%n",
                    rs.getString (1),rs.getString (2));
        }
        taskSeparator ();
    }

    private static void secondTask (Connection connection) throws SQLException, IOException {
        System.out.println ("Second Task:");
        System.out.println ("Enter the desired villain's ID:");

        int villainId = Integer.parseInt (reader.readLine ());
        String task_2 = """
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
                ORDER BY v.`name`;""";

        PreparedStatement preparedStatement = connection.prepareStatement (task_2);
        preparedStatement.setInt (1,villainId);
        ResultSet rs = preparedStatement.executeQuery ();

        int counter = 0;

        if (!rs.next ()) {
            System.out.printf ("No villain with ID %d exists in the database.%n",villainId);
        } else {
            while (rs.next ()) {
                if (counter == 0) {
                    System.out.printf ("Villain: %s%n",rs.getString (1));
                }
                System.out.printf ("%d. %s  %s%n",
                        ++counter,
                        rs.getString (2),
                        rs.getString (3));
            }
        }
        taskSeparator ();
    }

    private static void thirdTask (Connection connection) throws SQLException, IOException {
        System.out.println ("Third Task:");
        System.out.println ("Enter information about the minion to be inserted : name age town");

        String[] minionInfo = reader.readLine ().split (" ");
        String   minionName = minionInfo[1];
        int      minionAge  = Integer.parseInt (minionInfo[2]);
        String   minionTown = minionInfo[3];

        String[] villainInfo = reader.readLine ().split (" ");
        String   villainName = villainInfo[1];

        int               town_id;
        PreparedStatement getCountOfAllTowns=connection.prepareStatement ("SELECT COUNT(DISTINCT t.`id`) FROM `towns` AS t;");
        ResultSet         countAllTowns         = getCountOfAllTowns.executeQuery ();
        countAllTowns.next ();
        town_id=countAllTowns.getInt (1);

        PreparedStatement searchTowns = connection.prepareStatement ("SELECT t.`id` FROM `towns` AS t WHERE t.`name`=?;");
        searchTowns.setString (1,minionTown);
        ResultSet rsTowns = searchTowns.executeQuery ();

        if (!rsTowns.next ()) {
            PreparedStatement addTown = connection.prepareStatement (" INSERT INTO `towns`(`name`) VALUES (?);");
            addTown.setString (1,minionTown);
            addTown.executeUpdate ();
            System.out.printf ("Town %s added to the database.%n",minionTown);
        }else{
            town_id=rsTowns.getInt ("id");
        }


        PreparedStatement searchVillains = connection.prepareStatement ("SELECT v.`id` FROM `villains` AS v WHERE v.`name`=?;");
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
        ResultSet minionId    = getIdOfMinion.executeQuery ();
        minionId.next ();
        int       minionIdInt = minionId.getInt ("id");

        PreparedStatement getIdOfVillain = connection.prepareStatement ("SELECT v.`id` FROM `villains`AS v WHERE v.`name`=?;");
        getIdOfVillain.setString (1,villainName);
        ResultSet villainId    = getIdOfVillain.executeQuery ();
        villainId.next ();
        int       villainIdInt = villainId.getInt (1);

        linkMinionToVillain.setInt (1,minionIdInt);
        linkMinionToVillain.setInt (2,villainIdInt);
        linkMinionToVillain.executeUpdate ();

        System.out.printf ("Successfully added %s to be minion of %s%n",minionName,villainName);
        taskSeparator ();
    }
}
