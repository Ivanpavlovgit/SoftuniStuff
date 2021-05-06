package p02_ExtendedDatabase;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {

    private Database database;
    private static final Person[] PEOPLE =
            {new Person (1,"First"),
                    new Person (2,"Second"),
                    new Person (3,"Third")};

    @Before
    public void prepareDatabase () throws OperationNotSupportedException {
        database = new Database (PEOPLE);
    }

    @Test
    public void testConstructorCreatesValidObject () throws OperationNotSupportedException {
        assertEquals ("Incorrect count of elements",3,database.getElements ().length);
        Person[] people = database.getElements ();
        for (int i = 0; i < database.getElements ().length; i++) {
            assertEquals ("Incorrect data input",PEOPLE[i],people[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenMoreThan16Elements () throws OperationNotSupportedException {
        Person[] people = new Person[18];
        new Database (people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenLessThan1Element () throws OperationNotSupportedException {
        Person[] people    = new Person[0];
        Database database1 = new Database (people);

    }


    @Test(expected = OperationNotSupportedException.class)
    public void addNullElement () throws OperationNotSupportedException {

        database.add (null);
    }

    @Test
    public void addNotNullElement () throws OperationNotSupportedException {
        Person person = new Person (14,"Added");

        database.add (person);
        assertEquals (4,database.getElements ().length);
        assertEquals (14,database.getElements ()[3].getId ());
        assertEquals ("Added",database.getElements ()[3].getUsername ());
        assertEquals (database.getElements ()[3],person);
    }

    @Test
    public void removeWithIndexInBounds () throws OperationNotSupportedException {

        database.remove ();
        assertEquals (2,database.getElements ()[1].getId ());
        assertEquals ("Second",database.getElements ()[1].getUsername ());


    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeWithIndexOutOfBounds () throws OperationNotSupportedException {

        for (Person person : PEOPLE) {
            database.remove ();
        }
        assertEquals ("it works",0,database.getElements ().length);
        database.remove ();
        database.remove ();
        database.remove ();
        database.remove ();

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameIfSizeNotOne () throws OperationNotSupportedException {
        database = new Database ();
        database.findByUsername ("First");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameIfSearchingForNull () throws OperationNotSupportedException {
        database.findByUsername (null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowWithEmptyData () throws OperationNotSupportedException {
        database = new Database (null,null);
        database.findByUsername ("First");
    }
    @Test
    public void testFindByUsernameReturnCorrectPerson() throws OperationNotSupportedException{
        Person resultPerson=database.findByUsername ("First");
        assertEquals (1,resultPerson.getId ());
        assertEquals ("First",resultPerson.getUsername ());
        Person resultPerson2=database.findByUsername ("Second");
        assertEquals (2,resultPerson2.getId ());
        assertEquals ("Second",resultPerson2.getUsername ());
    }
    @Test
    public void testFindByIdReturnCorrectPerson() throws OperationNotSupportedException{
        Person resultPerson=database.findById (1);
        assertEquals (1,resultPerson.getId ());
        assertEquals ("First",resultPerson.getUsername ());
        Person resultPerson2=database.findById (2);
        assertEquals (2,resultPerson2.getId ());
        assertEquals ("Second",resultPerson2.getUsername ());
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdIfSizeNotOne () throws OperationNotSupportedException {
        database = new Database ();
        database.findById (1);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowWithEmptyData () throws OperationNotSupportedException {
        database = new Database (null,null);
        database.findById (1);
    }
}