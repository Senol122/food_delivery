package food_delivery.services;

import food_delivery.company.DeliveryCompany;
import food_delivery.company.SupplierCompany;
import food_delivery.restaurant.*;
import food_delivery.user.Client;
import food_delivery.user.ClientList;
import food_delivery.user.Courier;
import food_delivery.user.Supplier;

import java.io.*;


public class Functions {

    String line = "";

    public void clientControl(ClientList List, Client clientX, String[] values){
        for(int i=0 ; i < values.length ; i++){

            switch(i){
                case 0:
                    clientX.setClient_id(values[i]);
                    break;
                case 1:
                    clientX.setName(values[i]);
                    break;
                case 2:
                    clientX.setPhone(values[i]);
                    break;
                case 3:
                    clientX.setEmail(values[i]);
                    break;
                case 4:
                    clientX.setAddress(values[i]);
                    List.addClient(clientX);
                    break;
            }

        }
    }

    public void courierControl(DeliveryCompany List, Courier courierX, String[] values){
        for(int i=0 ; i < values.length ; i++){

            switch(i){
                case 0:
                    courierX.setCourier_id(values[i]);
                    break;
                case 1:
                    courierX.setName(values[i]);
                    break;
                case 2:
                    courierX.setPhone(values[i]);
                    break;
                case 3:
                    courierX.setCarNumberPlate(values[i]);
                    List.addCourier(courierX);
                    break;
            }

        }
    }

    public void supplierControl(SupplierCompany List, Supplier supplierX, String[] values){
        for(int i=0 ; i < values.length ; i++){

            switch(i){
                case 0:
                    supplierX.setSupplier_id(values[i]);
                    break;
                case 1:
                    supplierX.setName(values[i]);
                    break;
                case 2:
                    supplierX.setPhone(values[i]);
                    List.addSupplier(supplierX);
                    break;
            }

        }
    }

    public void dishControl(DishList List, Dish dishX, String[] values){
        for(int i=0 ; i < values.length ; i++){

            switch(i){
                case 0:
                    dishX.setDish_id(values[i]);
                    break;
                case 1:
                    dishX.setName(values[i]);
                    break;
                case 2:
                    dishX.setWeight(values[i]);
                    break;
                case 3:
                    dishX.setPrice(Integer.parseInt(values[i]));
                    List.addDish(dishX);
                    break;
            }

        }
    }

    public void restaurantControl(RestaurantList List, Restaurant restaurantX, String[] values){
        for(int i=0 ; i < values.length ; i++){

            switch(i){
                case 0:
                    restaurantX.setId(values[i]);
                case 1:
                    restaurantX.setName(values[i]);
                    break;
                case 2:
                    restaurantX.setAddress(values[i]);
                    List.addRestaurant(restaurantX);
                    break;
            }

        }
    }


}
