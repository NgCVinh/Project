package BankAccount;

 abstract class Account {
    public double initialBalance;
    public int transation_count;
    public double fee;
    public Account(double initialBalance){
        this.initialBalance=initialBalance;
        this.transation_count=0;
    }
    public void deposit(double amount){
        initialBalance+=amount;
        transation_count++;
    }
    abstract void charge();
    public void withdraw(double amount){
        transation_count++;
        if(initialBalance>amount)
            initialBalance-=amount;
    }
    public void endMonth(){
        charge();
        transation_count=0;
        System.out.print(initialBalance);
    }
}
