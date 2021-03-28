package food_delivery.restaurant;
import food_delivery.services.Identifiable;

public class Dish implements Identifiable{
    private String dish_id;
    private String name;
    private String weight;
    private int price;

    public Dish(){
        this.name = "";
        this.weight = "";
        this.price = 0;
    }

    public Dish(String name, String weight, int price) {
        this.dish_id = genID();
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDish_id() {
        return dish_id;
    }

    public void setDish_id(String dish_id) {
        this.dish_id = dish_id;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + "$" + '\'' +
                '}';
    }

    @Override
    public String getID() {
        return dish_id;
    }
}
