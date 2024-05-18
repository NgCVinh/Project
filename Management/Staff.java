package Management;

public class Staff {
    private String name;
    private String address;
    private String phone_number;
    private String position;
    private double interest;
    private double debt;
    private Staff staff;
    private Customer customer;
    private Vendor vendor;
    private Order order;

    public Staff(String name,String address,String phone_number,String position){
        this.name=name;
        this.address=address;
        this.phone_number=phone_number;
        this.position=position;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

//    public String buy(){
//        this.order=new Purchase(debt,vendor,staff);
//
//    }
    public Invoice invoice(){
        return new Invoice(interest,customer);
    }
}
