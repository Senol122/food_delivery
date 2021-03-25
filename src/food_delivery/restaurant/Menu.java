package food_delivery.restaurant;

import java.util.ArrayList;

public class Menu {
    private int nrOfPages;
    private ArrayList<Dish> ListOfDishes = new ArrayList<Dish>();

    public Menu(int nrOfPages) {
        this.nrOfPages = nrOfPages;
    }

    public int getNrOfPages() {
        return nrOfPages;
    }

    public void setNrOfPages(int nrOfPages) {
        this.nrOfPages = nrOfPages;
    }

    public ArrayList<Dish> getListOfDishes() {
        return ListOfDishes;
    }

    public void setListOfDishes(ArrayList<Dish> listOfDishes) {
        ListOfDishes = listOfDishes;
    }


}
