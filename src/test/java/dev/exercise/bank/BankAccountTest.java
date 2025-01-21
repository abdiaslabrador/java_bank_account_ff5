package dev.exercise.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class BankAccountTest {

    @Test
    void testConsign() {
        BankAccount account = new BankAccount(1000.0, 5.0f);
        account.consign(500.0f);
        assertEquals(1500.0, account.getAccountBalance());
        assertEquals(1, account.getNumbConsignments());
    }

    @Test
    void testWithdrawal() {
        BankAccount account = new BankAccount(1000.0, 5.0f);
        account.withdrawal(500.0f);
        assertEquals(500.0, account.getAccountBalance());
        assertEquals(1, account.getNumbWithdrawal());
    }

    @Test
    void testWithdrawalInsufficientFunds() {
        BankAccount account = new BankAccount(1000.0, 5.0f);
        account.withdrawal(1500.0f);
        assertEquals(1000.0, account.getAccountBalance());
        assertEquals(0, account.getNumbWithdrawal());
    }

    @Test
    void testCalculateAnualTax() {
        double account_balance = 1200.0;
        float anual_tax_percentage = 12.0f;
        BankAccount account = new BankAccount(account_balance, anual_tax_percentage);
        account_balance -= account_balance * ((anual_tax_percentage/100)/12);
        account.calculateAnualTax();
        assertEquals(account_balance, account.getAccountBalance());
    }

    @Test
    void testCalculateMonthlyCommission() {
        double account_balance = 1200.0;
        float anual_tax_percentage = 12.0f;
        float commission = 10.0f;
        BankAccount account = new BankAccount(account_balance, anual_tax_percentage);
        account.setMonthlyCommission(10.0f);
        account.calculateMonthlyCommission();
        account_balance -= commission;
        account_balance -= account_balance * ((anual_tax_percentage/100)/12);
        assertEquals(account_balance, account.getAccountBalance());
    }

    @Test
    void testGetAccountBalance() {
        BankAccount account = new BankAccount(1000.0, 5.0f);
        assertEquals(1000.0, account.getAccountBalance());
    }

    @Test
    void testGetNumbConsignments() {
        BankAccount account = new BankAccount(1000.0, 5.0f);
        account.consign(500.0f);
        assertEquals(1, account.getNumbConsignments());
    }

    @Test
    void testGetNumbWithdrawal() {
        BankAccount account = new BankAccount(1000.0, 5.0f);
        account.withdrawal(500.0f);
        assertEquals(1, account.getNumbWithdrawal());
    }

    @Test
    void testGetAnualTaxPercentage() {
        BankAccount account = new BankAccount(1000.0, 5.0f);
        assertEquals(0.05f, account.getAnualTaxPercentage());
    }

    @Test
    void testGetMonthlyCommission() {
        BankAccount account = new BankAccount(1000.0, 5.0f);
        account.setMonthlyCommission(10.0f);
        assertEquals(10.0f, account.getMonthlyCommission());
    }
}