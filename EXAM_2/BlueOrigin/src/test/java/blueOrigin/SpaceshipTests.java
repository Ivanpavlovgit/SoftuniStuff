package blueOrigin;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowsExceptionIfWrongCapacity () {
        Spaceship spaceship = new Spaceship ("ZeroCapacity",-1);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowsExceptionIfNullName () {
        Spaceship spaceship = new Spaceship (null,2);
    }

    @Test
    public void testConstructorCreatesCorrectObject () {
        Spaceship spaceship = new Spaceship ("ImCorrect",4);
        Assert.assertEquals ("ImCorrect",spaceship.getName ());
        Assert.assertEquals (4,spaceship.getCapacity ());
        Assert.assertEquals (0,spaceship.getCount ());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWhenCapacityIsFull () {
        Spaceship spaceship = new Spaceship ("ImCorrect",0);
        Astronaut astronaut = new Astronaut ("Kosmonaft",22);
        Assert.assertEquals (0,spaceship.getCapacity ());
        spaceship.add (astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddWhenExistingAstronautIsAdded () {
        Spaceship spaceship  = new Spaceship ("ImCorrect",4);
        Astronaut astronaut  = new Astronaut ("Kosmonaft",22);
        Astronaut astronaut2 = new Astronaut ("Kosmonaft",22);
        Assert.assertEquals (4,spaceship.getCapacity ());
        Assert.assertEquals (astronaut.getName (),astronaut2.getName ());
        Assert.assertEquals (astronaut.getOxygenInPercentage (),astronaut2.getOxygenInPercentage (),0);
        spaceship.add (astronaut);
        spaceship.add (astronaut2);
    }

    @Test
    public void testRemoveExistingAstronautReturnsCorrectAstronaut () {
        Spaceship spaceship  = new Spaceship ("ImCorrect",4);
        Astronaut astronaut  = new Astronaut ("Kosmonaft",22);
        Astronaut astronaut2 = new Astronaut ("Kosmonaft2",22);
        spaceship.add (astronaut);
        spaceship.add (astronaut2);
        assertTrue (spaceship.remove ("Kosmonaft"));
    }

    @Test
    public void testRemoveNonExistingAstronautReturnsNull () {
        Spaceship spaceship  = new Spaceship ("ImCorrect",4);
        Astronaut astronaut  = new Astronaut ("Kosmonaft",22);
        Astronaut astronaut2 = new Astronaut ("Kosmonaft2",22);
        spaceship.add (astronaut);
        spaceship.add (astronaut2);
        assertFalse (spaceship.remove ("Kosmonaft3"));
    }

    @Test
    public void testRemoveNonExistingAstronautFromEmpty () {
        Spaceship spaceship = new Spaceship ("ImCorrect",4);

        assertFalse (spaceship.remove ("Kosmonaft3"));
    }
    @Test
    public void testRemoveNonExistingAstronautFromZeroCapacity () {
        Spaceship spaceship = new Spaceship ("ImCorrect",0);

        assertFalse (spaceship.remove ("Kosmonaft3"));
    }
}