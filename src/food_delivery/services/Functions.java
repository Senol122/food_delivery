package food_delivery.services;

import food_delivery.company.DeliveryCompany;
import food_delivery.company.SupplierCompany;
import food_delivery.order.Order;
import food_delivery.order.Pair;
import food_delivery.restaurant.*;
import food_delivery.user.Client;
import food_delivery.user.ClientList;
import food_delivery.user.Courier;
import food_delivery.user.Supplier;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Functions {

    String line = "";
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
    Date date = new Date(System.currentTimeMillis());

    public void addDishToOrder(RestaurantList resList, Order orderX){
//        Initialize inputs
        Scanner dishSearch = new Scanner(System.in);
        Scanner quantityScan = new Scanner(System.in);

        System.out.println("Dish name: ");
        String dish = dishSearch.nextLine();
        System.out.println("Quantity: ");
        int quantity = quantityScan.nextInt();

//        Construct <Dish, Quantity> pair
        Dish auxDish = resList.dishByName2(dish);
        Pair auxPair = new Pair(auxDish, quantity);

        orderX.addOrderItem(auxPair);

        System.out.println("Dish successfully added to order!");
    }

    public Order checkout(Order orderX, ClientList clientList, String email){
        Scanner checkoutInput = new Scanner(System.in);

        System.out.println("Total amount: " + orderX.getTotalAmount() + "\n");
        System.out.println("Proceed to payment?[Y/N]");
        String checkoutIn = checkoutInput.nextLine();
        if(checkoutIn.equals("Y") || checkoutIn.equals("y")){
            clientList.findClient(email).getHistory().addOrder(orderX);
            System.out.println("Checkout done! Enjoy your order :)");
            return orderX;
        }   else {
            System.out.println("Continue shopping");
            return null;
        }
    }

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

    public void logOrder(String clientName, String orderId){
        try{
            File file = new File("log.csv");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter logWriter = new BufferedWriter(fr);
            logWriter.write( clientName + " has made an order with the following ID: " + orderId + " - " + format.format(date) );
            logWriter.newLine();
            logWriter.close();
            fr.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }


}
