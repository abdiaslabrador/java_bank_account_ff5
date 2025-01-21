package dev.exercise.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class SaveAccountTest {

    @Test
    public void testSaveAccountInitialization() {
        SaveAccount account = new SaveAccount(20000, 5);
        assertEquals(20000, account.getAccountBalance());
        assertTrue(account.isActive());
    }

    @Test
    public void testConsign() {
        SaveAccount account = new SaveAccount(20000, 5);
        account.consign(5000);
        assertEquals(25000, account.getAccountBalance());
    }

    @Test
    public void testWithdrawal() {
        SaveAccount account = new SaveAccount(20000, 5);
        account.withdrawal(5000);
        assertEquals(15000, account.getAccountBalance());
    }

    @Test
    public void testWithdrawalExceedingBalance() {
        SaveAccount account = new SaveAccount(20000, 5);
        account.withdrawal(25000);
        assertEquals(20000, account.getAccountBalance());
    }

    @Test
    public void testCalculateMonthlyCommission() {
        double account_balance = 10000;
        float anual_tax_percentage = 5.0f;
        double result = account_balance -= account_balance * ((anual_tax_percentage/100)/12);
        

        SaveAccount account = new SaveAccount(20000, 5);
        account.withdrawal(5000);
        account.withdrawal(5000);
        account.withdrawal(5000);
        account.calculateMonthlyCommission();
        assertEquals(result, account.getAccountBalance());
    }

    @Test
    public void testIsActive() {
        SaveAccount account = new SaveAccount(5000, 5);
        assertFalse(account.isActive());
    }
}