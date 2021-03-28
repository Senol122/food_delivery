package food_delivery.user;
import food_delivery.services.Identifiable;

public class Client extends User implements Identifiable{
    private String client_id;
    private String email;
    private String address;

    public Client(String name, String phone, String email, String address){
        super(name, phone);
        this.client_id = genID();
        this.email = email;
        this.address = address;
    }

    public String getClient_id(){return client_id;}

    public String getEmail(){return email;}

    public String getAddress(){return address;}

    public void setClient_id(String client_id){this.client_id = client_id;}

    public void setEmail(String email){this.email = email;}

    public void setAddress(String address){this.address = address;}

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
