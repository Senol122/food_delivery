package food_delivery.restaurant;

import java.util.ArrayList;

public class DishList {
    private ArrayList<Dish> dishList = new ArrayList<>();

    public DishList() {
    }

    public DishList(ArrayList<Dish> dishList) {
        this.dishList = dishList;
    }

    public ArrayList<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(ArrayList<Dish> dishList) {
        this.dishList = dishList;
    }

    public void addDish(Dish dishX){ dishList.add(dishX); }

    public Dish getDish(int n){ return dishList.get(n); }

    @Override
    public String toString() {
        return "DishList{" +
                "dishList=" + dishList +
                '}';
    }
}
