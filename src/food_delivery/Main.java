package food_delivery;

import food_delivery.user.*;
import food_delivery.services.*;
import food_delivery.restaurant.*;
import food_delivery.order.*;
import food_delivery.company.*;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        Functions functions = new Functions();

        PauseTest pause = new PauseTest();

//        -----------------INIT LISTS------------------------
        ClientList clientList = new ClientList();

        DeliveryCompany delivery = new DeliveryCompany();

        SupplierCompany supplier = new SupplierCompany();

        DishList dishList = new DishList();

        RestaurantList resList = new RestaurantList();

//        ------------READING FROM THE FILES-------------------

        String line = "";

        try{
            BufferedReader brClients = new BufferedReader(new FileReader("clients.csv"));
            BufferedReader brCouriers = new BufferedReader(new FileReader("couriers.csv"));
            BufferedReader brSuppliers = new BufferedReader(new FileReader("suppliers.csv"));
            BufferedReader brDishes = new BufferedReader(new FileReader("dishes.csv"));
            BufferedReader brRestaurants = new BufferedReader(new FileReader("restaurants.csv"));

            while((line = brClients.readLine()) != null){
                String[] values = line.split(",");

                Client clientX = new Client();

                functions.clientControl(clientList, clientX, values);
            }

            while((line = brCouriers.readLine()) != null){
                String[] values = line.split(",");

                Courier courierX = new Courier();

                functions.courierControl(delivery, courierX, values);
            }

            while((line = brSuppliers.readLine()) != null){
                String[] values = line.split(",");

                Supplier supplierX = new Supplier();

                functions.supplierControl(supplier, supplierX, values);
            }

            while((line = brDishes.readLine()) != null){
                String[] values = line.split(",");

                Dish dishX = new Dish();

                functions.dishControl(dishList, dishX, values);
            }

            while((line = brRestaurants.readLine()) != null){
                String[] values = line.split(",");

                Restaurant restaurantX = new Restaurant();

                functions.restaurantControl(resList, restaurantX, values);
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

//        System.out.println(clientList);
//        System.out.println(supplier);
//        System.out.println(delivery);
//        System.out.println(dishList.getDishList().size());
//        System.out.println(dishList.getDish(0));
//        System.out.println(resList);
//        pause.pause();

//        ------------INIT MENUS-------------------------------
        Menu menu1 = new Menu();
        Menu menu2 = new Menu();
        Menu menu3 = new Menu();

//        ------------POPULATING MENUS-------------------------
        menu1.addDish(dishList.getDish(0));
        menu1.addDish(dishList.getDish(1));
        menu1.addDish(dishList.getDish(2));
//
        menu2.addDish(dishList.getDish(3));
        menu2.addDish(dishList.getDish(4));
        menu2.addDish(dishList.getDish(5));
//
        menu3.addDish(dishList.getDish(6));
        menu3.addDish(dishList.getDish(7));
        menu3.addDish(dishList.getDish(8));

        resList.getRestaurant(0).setMenu(menu1);
        resList.getRestaurant(1).setMenu(menu2);
        resList.getRestaurant(2).setMenu(menu3);


//        -----------INIT ORDER HISTORY------------------------
//        Pair<Dish, Integer> pair1 = new Pair<>(dishList.getDish(1), 3);
//        Pair<Dish, Integer> pair2 = new Pair<>(dishList.getDish(5), 6);
//        Pair<Dish, Integer> pair3 = new Pair<>(dishList.getDish(7), 1);
//        Pair<Dish, Integer> pair4 = new Pair<>(dishList.getDish(3), 3);
//        Pair<Dish, Integer> pair5 = new Pair<>(dishList.getDish(6), 7);
//        Pair<Dish, Integer> pair6 = new Pair<>(dishList.getDish(9), 2);
//        Pair<Dish, Integer> pair7 = new Pair<>(dishList.getDish(3), 5);
//        Pair<Dish, Integer> pair8 = new Pair<>(dishList.getDish(5), 3);
//        Pair<Dish, Integer> pair9 = new Pair<>(dishList.getDish(1), 8);

//        Order order1 = new Order(clientList.getClient(1).getClient_id(), delivery.getCourier(1).getCourier_id(), "23-08-2021");
//        Order order2 = new Order(clientList.getClient(1).getClient_id(), delivery.getCourier(5).getCourier_id(), "14-05-2021");
//        Order order3 = new Order(clientList.getClient(3).getClient_id(), delivery.getCourier(5).getCourier_id(), "12-03-2020");
//        Order order4 = new Order(clientList.getClient(2).getClient_id(), delivery.getCourier(5).getCourier_id(), "05-01-2021");
//        Order order5 = new Order(clientList.getClient(5).getClient_id(), delivery.getCourier(1).getCourier_id(), "15-04-2021");

//        order1.addOrderItem(pair1);
//        order2.addOrderItem(pair2);
//        order2.addOrderItem(pair9);
//        order3.addOrderItem(pair3);
//        order3.addOrderItem(pair4);
//        order4.addOrderItem(pair5);
//        order5.addOrderItem(pair6);
//        order5.addOrderItem(pair7);
//        order5.addOrderItem(pair8);

//        clientList.getClient(1).getHistory().addOrder(order1);
//        clientList.getClient(1).getHistory().addOrder(order2);
//        clientList.getClient(3).getHistory().addOrder(order3);
//        clientList.getClient(2).getHistory().addOrder(order4);
//        clientList.getClient(5).getHistory().addOrder(order5);

//        ------------INIT KEYBOARD INPUTS---------------------
        String email = "";
        Scanner emailInput = new Scanner(System.in);
        Scanner optionInput = new Scanner(System.in);
        Scanner dishSearch = new Scanner(System.in);
        Scanner dishSearch2 = new Scanner(System.in);
        Scanner quantityScan = new Scanner(System.in);
        Scanner menuSearch = new Scanner(System.in);
        Scanner checkoutInput = new Scanner(System.in);
        Scanner addressInput = new Scanner(System.in);


//        ------------LOGIN------------------------------------
        System.out.println("Welcome to Hot Orders!");
        System.out.println("Enter your credentials bellow");
        System.out.print("Email: ");
        String emailAux = emailInput.nextLine();

        while(email.isEmpty()){
            if(clientList.checkEmail(emailAux)){
                System.out.println("You're logged in!");
                email = emailAux;
                pause.pause();
            }   else {
                System.out.println("Email not found.");
                pause.pause();
                System.out.print("Email: ");
                emailAux = emailInput.nextLine();
            }

        }

        Order order = new Order(clientList.findClient(email).getClient_id(), "23", "29-02-2021");

        while(!email.isEmpty()){
            System.out.println();
            System.out.println("Option Menu(choose index of the action)");
            System.out.println("1. See full list of Restaurants");
            System.out.println("2. See full list of Couriers");
            System.out.println("3. Search dish by name");
            System.out.println("4. See the menu of a specific restaurant");
            System.out.println("5. Add dish to order");
            System.out.println("6. See current order");
            System.out.println("7. Go to checkout");
            System.out.println("8. See your order history");
            System.out.println("9. Modify your address");
            System.out.println("10. Check account info");
            System.out.println("0. Logout");
            System.out.println("\n");

            System.out.println("Option: ");
            String option = optionInput.nextLine();

            switch(option) {
                case "1":{
                    resList.showRestaurants();
                    pause.pause();
                    break;
                }
                case "2":{
                    System.out.println("...");
                    pause.pause();
                    break;
                }
                case "3":{
                    System.out.print("Dish name: ");
                    String dish = dishSearch.nextLine();
                    resList.dishByName(dish);
                    pause.pause();
                    break;
                }
                case "4":{
                    System.out.print("Name of restaurant: ");
                    String menu = menuSearch.nextLine();
                    resList.menuByRestaurant(menu);
                    pause.pause();
                    break;
                }
                case "5":{
                    System.out.println("Dish name: ");
                    String dish = dishSearch2.nextLine();
                    System.out.println("Quantity: ");
                    int quantity = quantityScan.nextInt();
                    Dish auxDish = resList.dishByName2(dish);
                    Pair auxPair = new Pair(auxDish, quantity);
                    order.addOrderItem(auxPair);
                    System.out.println("Dish successfully added to order!");
                    pause.pause();
                    break;
                }
                case "6":{
                    System.out.println(order);
                    pause.pause();
                    break;
                }
                case "7":{
                    System.out.println("Total amount: " + order.getTotalAmount() + "\n");
                    System.out.println("Proceed to payment?[Y/N]");
                    String checkoutIn = checkoutInput.nextLine();
                    if(checkoutIn.equals("Y") || checkoutIn.equals("y")){
                        clientList.findClient(email).getHistory().addOrder(order);
                        System.out.println("Checkout done! Enjoy your order :)");
//                        order.getArray().clear();
                    }   else {
                        System.out.println("Continue shopping");
                    }
                    pause.pause();
                    break;
                }
                case "8":{
                    clientList.findClient(email).getOrderHistory();
                    pause.pause();
                    break;
                }
                case "9":{
                    System.out.print("Enter new address: ");
                    String newAddress = addressInput.nextLine();
                    clientList.findClient(email).setAddress(newAddress);
                    pause.pause();
                    break;
                }
                case "10":{
                    System.out.println(clientList.findClient(email));
                    pause.pause();
                    break;
                }
                case "0":{
                    email = "";
                    System.out.println("Logout");
                    pause.pause();
                    break;
                }
                default:{
                    System.out.println("No action with index " + option);
                    pause.pause();
                    break;
                }
            }
        }

        System.out.println("Thanks for spending your time with us!");
        pause.pause();
    }
}
