package food_delivery.user;

import java.util.ArrayList;

public class RestaurantManagerList {
    private ArrayList<RestaurantManager> managers = new ArrayList<>();

    public RestaurantManagerList() {
    }

    public RestaurantManagerList(ArrayList<RestaurantManager> managers) {
        this.managers = managers;
    }

    public void addManager(RestaurantManager x){
        managers.add(x);
    }

    public boolean checkEmail(String x){
        for(int i=0 ; i < managers.size() ; i++){
            if(managers.get(i).getEmail().equals(x)){
                return true;
            }
        }
        return false;
    }

    public RestaurantManager findManager(String email){
        for(int i = 0 ; i < managers.size(); i++){
            if(managers.get(i).getEmail().equals(email)){
                return managers.get(i);
            }
        }

        return null;
    }

    public RestaurantManager findManagerById(String managerID){
        for(int i = 0 ; i < managers.size(); i++){
            if(managers.get(i).getManagerID().equals(managerID)){
                return managers.get(i);
            }
        }

        return null;
    }

    public void deleteManager(String id){
        for(int i = 0 ; i < managers.size(); i++){
            if(managers.get(i).getManagerID().equals(id)){
                managers.remove(i);
            }
        }
    }

    public RestaurantManager getManager(int n){
        return managers.get(n);
    }

    public boolean authenticate(String email, String password){
        for(int i=0 ; i < managers.size() ; i++){
            if(managers.get(i).getEmail().equals(email) && managers.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "RestaurantManagerList{" +
                "managers=" + managers +
                '}';
    }
}
