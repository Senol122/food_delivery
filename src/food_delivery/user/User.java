package food_delivery.user;

public class User {
    protected String name;
    protected String phone;

    public User(){
        name = "";
        phone = "";
    }

    public User(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public String getName(){return name;}

    public String getPhone(){return phone;}

    public void setName(String name){this.name = name;}

    public void setPhone(String phone){this.phone = phone;}

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Phone: " + phone + "\n";
    }
}
