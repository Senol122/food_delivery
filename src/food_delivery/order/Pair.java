package food_delivery.order;
import food_delivery.restaurant.Dish;

public class Pair<Dish, Integer> {
    private Dish dish;
    private Integer quantity;

    public Pair(Dish dish, Integer quantity) {
        this.dish = dish;
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "dish=" + dish +
                ", quantity=" + quantity +
                '}';
    }
}
