package food_delivery.restaurant;

public class Dish {
    private String name;
    private String weight;
    private String price;

    public Dish(String name, String weight, String price) {
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
