package dev.exercise.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class CurrentAccountTest {

    @Test
    public void testWithdrawalWithinBalance() {
        CurrentAccount account = new CurrentAccount(1000.0, 1.5f);
        account.withdrawal(500.0f);
        assertEquals(500.0, account.getAccountBalance());
        assertEquals(0.0, account.getOverdraft());
    }

    @Test
    public void testWithdrawalExceedingBalance() {
        CurrentAccount account = new CurrentAccount(1000.0, 1.5f);
        account.withdrawal(1500.0f);
        assertEquals(-500.0, account.getAccountBalance());
        assertEquals(-500.0, account.getOverdraft());
    }

    @Test
    public void testConsignWithinOverdraft() {
        CurrentAccount account = new CurrentAccount(1000.0, 1.5f);
        account.withdrawal(1500.0f);
        account.consign(300.0f);
        assertEquals(-200.0, account.getAccountBalance());
        assertEquals(-200.0, account.getOverdraft());
    }

    @Test
    public void testConsignExceedingOverdraft() {
        CurrentAccount account = new CurrentAccount(1000.0, 1.5f);
        account.withdrawal(1500.0f);
        account.consign(600.0f);
        assertEquals(100.0, account.getAccountBalance());
        assertEquals(0.0, account.getOverdraft());
    }

    @Test
    public void testShowMovements() {
        CurrentAccount account = new CurrentAccount(1000.0, 1.5f);
        account.withdrawal(500.0f);
        account.consign(200.0f);
        account.show_movements();
    }
}