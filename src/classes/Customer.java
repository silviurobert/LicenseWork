package classes;
//event
public class Customer {
    private String name;
    private String city;
    public Customer(){
    }
    public Customer(String name, String city) {
        this.name = name;
        this.city = city;
    }
    public String getName() {
        return name;
    }
    public String getCity() {
        return city;
    }
    public void displayCustomer(){
        System.out.println("Customer details: " + getName() + ", " + getCity());
    }
}
