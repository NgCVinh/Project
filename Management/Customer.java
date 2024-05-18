package Management;

public class Customer{
    private String name;
    private String address;
    private double Debt;
    private Staff staff;
    private Vendor vendor;
    public Customer(String name,String address,double Debt){
        this.name=name;
        this.address=address;
        this.Debt=Debt;
    }
    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Vendor getVendor() {
        return vendor;
    }
    public Purchase purchase(){
        return new Purchase(Debt,vendor,staff);
    }
}
