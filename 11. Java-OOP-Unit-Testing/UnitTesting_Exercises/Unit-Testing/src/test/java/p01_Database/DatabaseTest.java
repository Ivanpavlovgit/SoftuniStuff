package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {

    //TODO: TEST THESE
    //constructor-done
    //0.returns true data-done
    //1.elements >16=done
    //2. or <1-done
    //add method (null and notNull)-done
    //remove method
    private Database database;
    private static final Integer[] NUMBERS = {3,12,15,26,35};
@Before
public void prepareDatabase() throws OperationNotSupportedException {
    database=new Database (NUMBERS);
}
    @Test
    public void testConstructorCreatesValidObject () throws OperationNotSupportedException {
        assertEquals ("Incorrect count of elements",5,database.getElements ().length);
        Integer[] dataNumbers = database.getElements ();
        for (int i = 0; i < database.getElements ().length; i++) {
            assertEquals ("Incorrect data input",NUMBERS[i],dataNumbers[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenMoreThan16Elements () throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database (numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWhenLessThan1Element () throws OperationNotSupportedException {
        Integer[] numbers  = new Integer[0];
        Database  database1 = new Database (numbers);

    }


    @Test(expected = OperationNotSupportedException.class)
    public void addNullElement () throws OperationNotSupportedException {
        Database database = new Database (NUMBERS);
        database.add (null);
    }

    @Test
    public void addNotNullElement () throws OperationNotSupportedException {


        database.add (0);
        assertEquals (6,database.getElements ().length);
        assertEquals (Integer.valueOf (0),database.getElements ()[5]);
    }

    @Test
    public void removeWithIndexInBounds () throws OperationNotSupportedException {

        database.remove ();
        assertEquals (Integer.valueOf (26),database.getElements ()[3]);
        Integer[] numbersAfterRemove = database.getElements ();
        for (int i = 0; i < numbersAfterRemove.length; i++) {
            assertEquals (NUMBERS[i],numbersAfterRemove[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeWithIndexOutOfBounds () throws OperationNotSupportedException {

        for (Integer number : NUMBERS) {
            database.remove ();
        }
        assertEquals ("it works",0,database.getElements ().length);
        database.remove ();
        database.remove ();
        database.remove ();
        database.remove ();

    }
}