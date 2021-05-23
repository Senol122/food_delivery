package food_delivery.user;
import food_delivery.order.OrderHistory;
import food_delivery.services.Identifiable;

public class Client extends User implements Identifiable{
    private String client_id;
    private String address;
    private OrderHistory history = new OrderHistory();

    public Client() {
    }

    public Client(String name, String email, String password, String phone, String address){
        super(name, email, password, phone);
        this.client_id = genID();
        this.address = address;
    }

    public String getClient_id(){return client_id;}

    public String getEmail(){return email;}

    public String getAddress(){return address;}

    public void setClient_id(String client_id){this.client_id = client_id;}

    public void setEmail(String email){this.email = email;}

    public void setAddress(String address){this.address = address;}

    public void getOrderHistory(){
        if(this.history.getHistory().size() != 0){
            System.out.println(history);
        }   else {
            System.out.println("There is no order history to show.");
        }
    }

    public OrderHistory getHistory(){
        return this.history;
    }

    public boolean isEmpty(){
        return client_id == null && name == null && email == null && address == null && password == null;
    }

    @Override
    public String toString() {
        return  "Client ID: " + client_id + "\n" +
                "Name: " + name + "\n" +
                "Phone: " + phone + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address + "\n";
    }

    @Override
    public String getID() {
        return client_id;
    }
}
