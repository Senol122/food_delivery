package food_delivery.restaurant;

import food_delivery.services.Identifiable;

public class Restaurant implements Identifiable{
    private String id;
    private String name;
    private String address;
    private Menu menu;

    public Restaurant() {
    }

    public Restaurant(String name, String address, Menu menu) {
        this.id = genID();
        this.name = name;
        this.address = address;
        this.menu = menu;
    }

    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                '}';
    }

    @Override
    public String getID() {
        return id;
    }
}
