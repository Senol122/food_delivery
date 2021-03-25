package food_delivery.user;

public class Client extends User{
    private int client_id;
    private String email;
    private String address;

    public Client(String name, String phone, int client_id, String email, String address){
        super(name, phone);
        this.client_id = client_id;
        this.email = email;
        this.address = address;
    }

    public int getClient_id(){return client_id;}

    public String getEmail(){return email;}

    public String getAddress(){return address;}

    public void setClient_id(int client_id){this.client_id = client_id;}

    public void setEmail(String email){this.email = email;}

    public void setAddress(String address){this.address = address;}

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Phone: " + phone + "\n" +
                "Client ID: " + client_id + "\n" +
                "Email: " + email + "\n" +
                "Address: " + address + "\n";
    }
}
