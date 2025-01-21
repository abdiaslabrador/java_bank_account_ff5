package main.java.dev.exercise.bank;

public class CurrentAccount extends BankAccount{
    private double overdraft;

    public CurrentAccount(double account_balance, float anual_tax_percentage) {
        super(account_balance, anual_tax_percentage);
        this.overdraft = 0.00;
    }

    public void withdrawal(float money) {
        if(money > account_balance){
            overdraft = account_balance - money;
        }            
        this.account_balance -= money;
        this.numb_withdrawal++;
        
    }

    public void consign(float money) {
        this.account_balance += money;
        if(money >= overdraft){
            overdraft = 0;
        }else{
            overdraft -= money;
        }
        this.numb_consignments++;
    }

    public void show_movements(){
        System.out.println("Saldo: " + this.account_balance);
        System.out.println("Numero de transacciones: " + (this.numb_consignments + this.numb_withdrawal));
        System.out.println("Comision mensual: " + this.monthly_commission);
        System.out.println("Sobregiro: " + this.overdraft);
    }
}
