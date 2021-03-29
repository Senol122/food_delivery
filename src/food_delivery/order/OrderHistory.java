package food_delivery.order;

import java.util.ArrayList;

public class OrderHistory {
    private ArrayList<Order> history = new ArrayList<>();

    public OrderHistory() {
    }

    public OrderHistory(ArrayList<Order> history) {
        this.history = history;
    }

    public ArrayList<Order> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<Order> history) {
        this.history = history;
    }

    public void addOrder(Order x){
        history.add(x);
    }

    public Order getOrder(int i){
        return history.get(i);
    }

    @Override
    public String toString() {
        return "OrderHistory{" +
                "history=" + history +
                '}';
    }
}
