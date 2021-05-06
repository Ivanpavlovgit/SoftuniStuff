package Bank;

import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {
    private BankAccount bankAccount = new BankAccount ();

    @Test
    public void testBankAccountCreationStartsWithZeroBalance () {
        BankAccount bankAccount = new BankAccount ();
        double      balance     = bankAccount.getBalance ();

        assertEquals (0,balance,0);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testDepositShouldIncreaseAmountCorrectly () {
        bankAccount.deposit (-20);
        assertEquals (20,bankAccount.getBalance (),0);
    }
}
