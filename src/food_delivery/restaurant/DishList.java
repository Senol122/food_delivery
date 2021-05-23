package food_delivery.restaurant;

import java.util.ArrayList;

public class DishList {
    private ArrayList<Dish> dishList = new ArrayList<>();

    public DishList() {
    }

    public DishList(ArrayList<Dish> dishList) {
        this.dishList = dishList;
    }

    public Dish dishByName(String dishName) {
        boolean aux = false;
        for(int i = 0 ; i < dishList.size() ; i++){
            if(dishList.get(i).getName().equals(dishName)){
                aux = true;
                return dishList.get(i);
            }
        }
        if(!aux){
            System.out.println("Dish not found.");
        }
        return null;
    }

    public void deleteDishByName(String dishName){
        boolean aux = false;
        for(int i = 0 ; i < dishList.size() ; i++){
            if(dishList.get(i).getName().equals(dishName)){
                aux = true;
                dishList.remove(i);
            }
        }
        if(!aux){
            System.out.println("Dish not found.");
        }
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
