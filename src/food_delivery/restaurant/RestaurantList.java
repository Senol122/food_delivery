package food_delivery.restaurant;

import java.util.ArrayList;

public class RestaurantList {
    private ArrayList<Restaurant> restaurantList = new ArrayList<>();

    public RestaurantList() {
    }

    public RestaurantList(ArrayList<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    public void addRestaurant(Restaurant x){
        restaurantList.add(x);
    }

    public Restaurant getRestaurant(int n){
        return restaurantList.get(n);
    }

    public void showRestaurants(){
        for(int i = 0 ; i < restaurantList.size() ; i++){
            System.out.println(i+1 + ". " + restaurantList.get(i).getName());
        }
    }

    public void dishByName(String name){
        boolean aux = false;
        for(int i = 0 ; i < restaurantList.size() ; i++){
            for(int j = 0 ; j < restaurantList.get(i).getMenu().getSize() ; j++){
                if(restaurantList.get(i).getMenu().getDishName(j).equals(name)){
                    System.out.println("Restaurant: " + restaurantList.get(i).getName() + "\n" + restaurantList.get(i).getMenu().getDish(j));
                    aux = true;
                }
            }
        }
        if(!aux){
            System.out.println("Dish not found.");
        }
    }

    public Dish dishByName2(String name){
        boolean aux = false;
        for(int i = 0 ; i < restaurantList.size() ; i++){
            for(int j = 0 ; j < restaurantList.get(i).getMenu().getSize() ; j++){
                if(restaurantList.get(i).getMenu().getDishName(j).equals(name)){
                    aux = true;
                    return restaurantList.get(i).getMenu().getDish(j);
                }
            }
        }
        if(!aux){
            System.out.println("Dish not found.");
        }

        return null;
    }

    public void menuByRestaurant(String name){
        boolean aux = false;
        for(int i = 0 ; i < restaurantList.size() ; i++){
            if(restaurantList.get(i).getName().equals(name)){
                System.out.println(restaurantList.get(i).getMenu());
                aux = true;
            }
        }
        if(!aux){
            System.out.println("Restaurant not found.");
        }
    }

    @Override
    public String toString() {
        return "RestaurantList{" +
                "restaurantList=" + restaurantList +
                '}';
    }
}
