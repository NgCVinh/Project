package Management;

public class Vendor {
    private String name;
    private String address;
    private double Interest;
    private Customer customer;
    public Vendor(String name,String address,double Interest){
        this.name=name;
        this.address=address;
        this.Interest=Interest;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Invoice invoice(){
        return new Invoice(Interest,customer);
    }
}
