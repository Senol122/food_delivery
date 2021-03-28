package food_delivery.restaurant;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Dish> ListOfDishes = new ArrayList<>();

    public Menu() {
    }

    public Menu(ArrayList<Dish> listOfDishes) {
        this.ListOfDishes = listOfDishes;
    }

    public ArrayList<Dish> getMenu() {
        return ListOfDishes;
    }

    public int getSize(){
        return ListOfDishes.size();
    }

    public void setListOfDishes(ArrayList<Dish> listOfDishes) {
        ListOfDishes = listOfDishes;
    }

    public void addDish(Dish x){
        ListOfDishes.add(x);
    }

    public String getDishName(int i){
        return ListOfDishes.get(i).getName();
    }

    public Dish getDish(int i){
        return ListOfDishes.get(i);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "ListOfDishes=" + ListOfDishes +
                '}';
    }
}
