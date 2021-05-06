package bankSafe;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class BankVaultTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testIfCellsAreUnmodifiableWithRemove () {
        BankVault bankVault = new BankVault ();
        bankVault.getVaultCells ().remove ("A1");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIfCellsAreUnmodifiableWithPut () {
        BankVault bankVault = new BankVault ();
        bankVault.getVaultCells ().put ("D1",null);
    }

    @Test
    public void testIfCellsValueIsNull () {
        BankVault bankVault = new BankVault ();
        Item      item      = bankVault.getVaultCells ().get ("A1");
        Assert.assertNull (item);
    }

    @Test
    public void testAddingItemsInCells1 () throws OperationNotSupportedException {
        BankVault bankVault = new BankVault ();
        Item      item      = new Item ("MyItem","SomeID");
        bankVault.addItem ("A1",item);
        Assert.assertNotNull (bankVault.getVaultCells ().get ("A1"));
        Assert.assertEquals (item,bankVault.getVaultCells ().get ("A1"));


    }

    @Test
    public void testAddingItemsInCells () throws OperationNotSupportedException {
        BankVault bankVault = new BankVault ();
        Item      item      = new Item ("MyItem","SomeID");
        bankVault.addItem ("A1",item);
        Assert.assertNotNull (bankVault.getVaultCells ().get ("A1"));
        Assert.assertEquals (item,bankVault.getVaultCells ().get ("A1"));
    }

    @Test
    public void testBooleanItemExistsInCell ()throws OperationNotSupportedException {
        BankVault bankVault = new BankVault ();
        Item      item      = new Item ("Mine","SomeID");
        bankVault.addItem ("A1",item);
        Assert.assertNotNull (bankVault.getVaultCells ().get ("A1"));
        Assert.assertTrue (bankVault.getVaultCells ().containsValue (item));
    }

    @Test
    public void testBooleanItemExistsInCellForTrue () throws OperationNotSupportedException {
        BankVault bankVault = new BankVault ();
        Item      item      = new Item ("Mine","SomeID");
        bankVault.addItem ("A1",item);
        Assert.assertNotNull (bankVault.getVaultCells ().get ("A1"));
        Assert.assertTrue (bankVault.getVaultCells ().containsValue (item));
    }

    @Test
    public void testAddingSuccessfulItem () throws OperationNotSupportedException {
        BankVault bankVault = new BankVault ();
        Item      item      = new Item ("Mine","SomeID");
        bankVault.addItem ("A1",item);
        Assert.assertNotNull (bankVault.getVaultCells ().get ("A1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeItemFromNonExistentCell () {
        BankVault bankVault = new BankVault ();
        Assert.assertNull (bankVault.getVaultCells ().get ("A1"));
        bankVault.removeItem ("G5",null);
        Assert.assertNull (bankVault.getVaultCells ().get ("A1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeNonExistingItemFromCell () {
        BankVault bankVault = new BankVault ();
        Item      item      = new Item ("Mine","SomeID");
        Assert.assertNull (bankVault.getVaultCells ().get ("A1"));
        bankVault.removeItem ("A1",item);
        Assert.assertNull (bankVault.getVaultCells ().get ("A1"));
    }

    @Test
    public void testRemovingSuccessfulItem () throws OperationNotSupportedException {
        BankVault bankVault = new BankVault ();
        Item      item      = new Item ("Mine","SomeID");
        bankVault.addItem ("A1",item);
        Assert.assertNotNull (bankVault.getVaultCells ().get ("A1"));
        bankVault.removeItem ("A1",item);
        Assert.assertNull (bankVault.getVaultCells ().get ("A1"));
    }

    @Test
    public void testForOutputAdd () throws OperationNotSupportedException {
        BankVault bankVault = new BankVault ();
        Item      item      = new Item ("Mine","SomeID");
        bankVault.addItem ("A1",item);

        Assert.assertEquals (String.format ("Item:%s saved successfully!",item.getItemId ()),"Item:SomeID saved successfully!",String.format ("Item:%s saved successfully!",item.getItemId ()));
        Assert.assertNotNull (bankVault.getVaultCells ().get ("A1"));
    }

    @Test
    public void testForOutputRemove () throws OperationNotSupportedException {
        BankVault bankVault = new BankVault ();
        Item      item      = new Item ("Mine","SomeID");
        bankVault.addItem ("A1",item);
        Assert.assertNotNull (bankVault.getVaultCells ().get ("A1"));
        Assert.assertEquals (String.format ("Item:%s saved successfully!",item.getItemId ()),"Item:SomeID saved successfully!",String.format ("Item:%s saved successfully!",item.getItemId ()));
        bankVault.removeItem ("A1",item);
        Assert.assertEquals (String.format ("Remove item:%s successfully!",item.getItemId ()),"Remove item:SomeID successfully!",String.format ("Remove item:%s successfully!",item.getItemId ()));
        Assert.assertNull (bankVault.getVaultCells ().get ("A1"));
    }

    @Test
    public void itemOwnerTest () {
        Item   item  = new Item ("Mine","SomeID");
        String owner = item.getOwner ();
        Assert.assertEquals ("Mine",owner);
    }

    @Test
    public void itemIDTest () {
        Item   item = new Item ("Mine","SomeID");
        String id   = item.getItemId ();
        Assert.assertEquals ("SomeID",id);
    }
}