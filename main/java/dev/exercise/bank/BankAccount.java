package main.java.dev.exercise.bank;

public class BankAccount {
    protected double account_balance; //saldo
    protected int numb_consignments = 0; //consignaciones
    protected int numb_withdrawal = 0; //retiro
    protected float anual_tax_percentage; //porcentaje de impuesto anual
    protected float monthly_commission = 0.00; //comision mensual

    public BankAccount(double account_balance, float anual_tax_percentage) {
        this.account_balance = account_balance;
        this.anual_tax_percentage = anual_tax_percentage/100;
    }
    
    public void consign(float money) {
        this.account_balance += money;
        this.numb_consignments++;
    }

    public void withdrawal(float money) {        
        if(money <= account_balance){
            this.account_balance -= money;
            this.numb_withdrawal++;
        }
    }

    public void calculateAnualTax() {
        this.account_balance -= (this.account_balance * (this.anual_tax_percentage/12));
    }

    public void calculateMonthlyCommission() {
        this.account_balance -= this.monthly_commission;
        calculateAnualTax();
    }

    public double getAccountBalance() {
        return account_balance;
    }

    public int getNumbConsignments() {
        return numb_consignments;
    }

    public int getNumbWithdrawal() {
        return numb_withdrawal;
    }

    public float getAnualTaxPercentage() {
        return anual_tax_percentage;
    }

    public float getMonthlyCommission() {
        return monthly_commission;
    }

}
