package rpg_lab;
import org.junit.Before;
import org.junit.Test;
//import org.junit.*;
import static org.junit.Assert.*;
public class AxeTest {

private Axe axe;
private Dummy dummy;

private static  final int AXE_ATTACK=10;
private static  final int AXE_DURABILITY=10;
private static  final int DUMMY_HEALTH=1000;
private static  final int DUMMY_EXPERIENCE=10;

@Before
public void setUp(){
    this.axe=new Axe (AXE_ATTACK,AXE_DURABILITY);
    this.dummy=new Dummy (DUMMY_HEALTH,DUMMY_EXPERIENCE);
}
    @Test
    public void testAxeLoosesDurabilityAfterAttack(){
    axe.attack (dummy);
    assertEquals ("Axe doesn't loose durability after attack",AXE_DURABILITY-1,axe.getDurabilityPoints (),0);
    }
    @Test
    public void testAxeLoosesAllDurabilityAfterAttack(){
        for (int i = 0; i <AXE_DURABILITY ; i++) {
            axe.attack (dummy);
        }
        assertEquals (AXE_DURABILITY-AXE_DURABILITY,axe.getDurabilityPoints ());
    }
    @Test(expected = IllegalStateException.class)
    public void testAxeLoosesDurabilityAfterAttackAndThrowsException(){

        for (int i = 0; i <=AXE_DURABILITY ; i++) {
            axe.attack (dummy);
        }

    }

}