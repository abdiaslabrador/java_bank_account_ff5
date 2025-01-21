package main.java.dev.exercise.bank;

public class SaveAccount extends BankAccount {
    private boolean active = true;

    public SaveAccount(float account_balance, float anual_tax_percentage) {
        super(account_balance, anual_tax_percentage);
        isActive();
    }

    public void consign(float money) {
        if (active == true) {
            this.account_balance += money;
            this.numb_consignments++;
        }
    }

    public void withdrawal(float money) {
        if (active == true) {
            if (money <= account_balance) {
                this.account_balance -= money;
                this.numb_money_withdrawal++;
                isActive();
            }
        }
    }

    public void calculateMonthlyCommission() {
        int aditional_withdrawal = (this.numb_withdrawal - 4);
        if(aditional_withdrawal > 0){
            this.monthly_commission = aditional_withdrawal * 1000;
        }
        this.account_balance -= this.monthly_commission;
        calculateAnualTax();
        isActive();
    }

    public void show_movements(){
        System.out.println("Saldo: " + this.account_balance);
        System.out.println("Numero de transacciones: " + (this.numb_consignments + this.numb_withdrawal));
        System.out.println("Comision mensual: " + this.monthly_commission);
        System.out.println("Activo: " + this.active);
    }

    public boolean isActive() {
        if(this.account_balance <= 10000){
            active = false;
        }
        return active;
     
    }
}
