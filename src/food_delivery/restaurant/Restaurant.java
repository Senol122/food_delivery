package food_delivery.restaurant;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String address;
    private Menu menu;

    public Restaurant(String name, String address, Menu menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                '}';
    }
}
