package Management;

public class Purchase implements Order{
    private double amount;
    private Vendor nameVendor;
    private Staff nameStaff;
    public Purchase(double amount,Vendor nameVendor,Staff nameStaff){
        this.amount=amount;
        this.nameVendor=nameVendor;
        this.nameStaff=nameStaff;
    }
    public String buy(){
        return this.amount+" "+this.nameVendor+" "+this.nameStaff;
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
