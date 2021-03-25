package food_delivery.order;

import food_delivery.restaurant.Dish;
//import javafx.util.Pair;
import java.util.ArrayList;

public class Order {
    private int client_id;
    private int courier_id;
    private String order_date;
    private ArrayList<Pair<Dish, Integer>> dishQuantityPair = new ArrayList<Pair<Dish, Integer>>();

    public Order(int client_id, int courier_id, String order_date, ArrayList<Pair<Dish, Integer>> dishQuantityPair) {
        this.client_id = client_id;
        this.courier_id = courier_id;
        this.order_date = order_date;
        this.dishQuantityPair = dishQuantityPair;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public ArrayList<Pair<Dish, Integer>> getArray() {
        return dishQuantityPair;
    }

    public void setDishQuantityPair(ArrayList<Pair<Dish, Integer>> dishQuantityPair) {
        this.dishQuantityPair = dishQuantityPair;
    }

    @Override
    public String toString() {
        return "Order{" +
                "client_id=" + client_id +
                ", courier_id=" + courier_id +
                ", order_date='" + order_date + '\'' +
                ", dishQuantityPair=" + dishQuantityPair +
                '}';
    }
}

