package food_delivery.order;

import food_delivery.restaurant.Dish;
import food_delivery.services.Identifiable;
import java.util.ArrayList;

public class Order implements Identifiable {
    private String order_id;
    private String client_id;
    private String courier_id;
    private String order_date;
    private ArrayList<Pair<Dish, Integer>> dishQuantityPair = new ArrayList<>();

    public Order(String client_id, String courier_id, String order_date) {
        this.order_id = genID();
        this.client_id = client_id;
        this.courier_id = courier_id;
        this.order_date = order_date;
    }

    public Order(Order x){
        this.order_id = x.order_id;
        this.order_date = x.order_date;
        this.client_id = x.client_id;
        this.courier_id = x.courier_id;
    }

    public String getOrder_id(){
        return order_id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getCourier_id() {
        return courier_id;
    }

    public void setCourier_id(String courier_id) {
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

    public void addOrderItem(Pair<Dish, Integer> x){
        dishQuantityPair.add(x);
    }

    public int getTotalAmount(){
        int TotalAmount = 0;
        for(int i=0 ; i < dishQuantityPair.size() ; i++){
            TotalAmount += dishQuantityPair.get(i).getDish().getPrice() * dishQuantityPair.get(i).getQuantity();
        }

        return TotalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_date='" + order_date + '\'' +
                ", dishQuantityPair=" + dishQuantityPair +
                '}' + "\n";
    }

    @Override
    public String getID() {
        return order_id;
    }
}

