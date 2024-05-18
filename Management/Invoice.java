package Management;

public class Invoice implements Order {
    private double amount;
    private Customer name_customer;
    public Invoice(double amount,Customer customer){
        this.amount=amount;
        this.name_customer=customer;
    }
    public String sell(){
        return this.amount+" "+this.name_customer;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(double amount) {
        this.amount=amount;
    }
}
