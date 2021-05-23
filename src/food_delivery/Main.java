package food_delivery;

import food_delivery.user.*;
import food_delivery.services.*;
import food_delivery.restaurant.*;
import food_delivery.order.*;
import food_delivery.company.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {

//        ----------------INIT UTILITY CLASSES---------------
        Functions functions = new Functions();

        PauseTest pause = new PauseTest();

        AccountOperations operations = new AccountOperations();

//        -----------------INIT LISTS------------------------
        ClientList clientList = new ClientList();

        DeliveryCompany delivery = new DeliveryCompany();

        SupplierCompany supplier = new SupplierCompany();

        DishList dishList = new DishList();

        RestaurantList resList = new RestaurantList();

        ArrayList<Order> orders = new ArrayList<>();

//        ------------READING FROM THE FILES-------------------

        functions.createConnection(clientList, delivery, dishList);

        String line = "";

        try{
            BufferedReader brClients = new BufferedReader(new FileReader("clients.csv"));
            BufferedReader brSuppliers = new BufferedReader(new FileReader("suppliers.csv"));
            BufferedReader brRestaurants = new BufferedReader(new FileReader("restaurants.csv"));

            while((line = brClients.readLine()) != null){
                String[] values = line.split(",");

                Client clientX = new Client();

                functions.clientControl(clientList, clientX, values);
            }

            while((line = brSuppliers.readLine()) != null){
                String[] values = line.split(",");

                Supplier supplierX = new Supplier();

                functions.supplierControl(supplier, supplierX, values);
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

//        ------------SET MENUS FOR RESTAURANTS-----------------
        resList.getRestaurant(0).setMenu(menu1);
        resList.getRestaurant(1).setMenu(menu2);
        resList.getRestaurant(2).setMenu(menu3);


//        -----------INIT ORDER HISTORY------------------------
        Pair<Dish, Integer> pair1 = new Pair<>(dishList.getDish(0), 3);
        Pair<Dish, Integer> pair2 = new Pair<>(dishList.getDish(4), 6);
        Pair<Dish, Integer> pair3 = new Pair<>(dishList.getDish(6), 1);
        Pair<Dish, Integer> pair4 = new Pair<>(dishList.getDish(2), 3);
        Pair<Dish, Integer> pair5 = new Pair<>(dishList.getDish(5), 7);
        Pair<Dish, Integer> pair6 = new Pair<>(dishList.getDish(8), 2);
        Pair<Dish, Integer> pair7 = new Pair<>(dishList.getDish(2), 5);
        Pair<Dish, Integer> pair8 = new Pair<>(dishList.getDish(4), 3);
        Pair<Dish, Integer> pair9 = new Pair<>(dishList.getDish(0), 8);

        Order order1 = new Order(clientList.getClient(0).getClient_id(), delivery.getCourier(0).getCourier_id(), "23-08-2021");
        Order order2 = new Order(clientList.getClient(0).getClient_id(), delivery.getCourier(4).getCourier_id(), "14-05-2021");
        Order order3 = new Order(clientList.getClient(2).getClient_id(), delivery.getCourier(4).getCourier_id(), "12-03-2020");
        Order order4 = new Order(clientList.getClient(1).getClient_id(), delivery.getCourier(4).getCourier_id(), "05-01-2021");
        Order order5 = new Order(clientList.getClient(4).getClient_id(), delivery.getCourier(0).getCourier_id(), "15-04-2021");

        order1.addOrderItem(pair1);
        order2.addOrderItem(pair2);
        order2.addOrderItem(pair9);
        order3.addOrderItem(pair3);
        order3.addOrderItem(pair4);
        order4.addOrderItem(pair5);
        order5.addOrderItem(pair6);
        order5.addOrderItem(pair7);
        order5.addOrderItem(pair8);

//      Add orders to histories of each client
        clientList.getClient(0).getHistory().addOrder(order1);
        clientList.getClient(0).getHistory().addOrder(order2);
        clientList.getClient(2).getHistory().addOrder(order3);
        clientList.getClient(1).getHistory().addOrder(order4);
        clientList.getClient(4).getHistory().addOrder(order5);

//      Add orders to ArrayList<> orders
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);

//        ------------INIT KEYBOARD INPUTS---------------------
        Scanner optionInput = new Scanner(System.in);
        Scanner dishSearch = new Scanner(System.in);
        Scanner menuSearch = new Scanner(System.in);
        Scanner addressInput = new Scanner(System.in);
        Scanner accountOptionInput = new Scanner(System.in);

        System.out.println("Welcome to Hot Orders!");
        System.out.println("Login as a: ");
        System.out.println("-> Client");
        System.out.println("-> Courier");
        System.out.println("-> Supplier");

        System.out.print("Option: ");
        String accountOption = accountOptionInput.nextLine();

        if(accountOption.equals("client") || accountOption.equals("Client")){
            operations.login(clientList);
        }   else if(accountOption.equals("courier") || accountOption.equals("Courier")){
            operations.loginCourier(delivery);
        }   else if(accountOption.equals("supplier") || accountOption.equals("Supplier")){
            operations.loginSupplier(supplier);
        }   else {
            System.out.println("You didn't choose one of the options. Run the program again.");
        }

        while(operations.isLoginStateClient()){
            Order order = new Order(operations.getClient().getClient_id(), "23", "29-02-2021");

            System.out.println();
            System.out.println("Option Menu(choose index of the action)");
            System.out.println("1. See full list of Restaurants");
            System.out.println("2. See full list of Couriers");
            System.out.println("3. Search dish by name");
            System.out.println("4. Add a dish you ate recently(that's not on the platform)");
            System.out.println("5. See the menu of a specific restaurant");
            System.out.println("6. Add dish to order");
            System.out.println("7. See current order");
            System.out.println("8. Go to checkout");
            System.out.println("9. See your order history");
            System.out.println("10. Modify your address");
            System.out.println("11. Check account info");
            System.out.println("0. Logout");
            System.out.println("\n");

            System.out.print("Option: ");
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
                    String dishName = dishSearch.nextLine();
                    dishList.dishByName(dishName);
                    pause.pause();
                    break;
                }
                case "4": {
                    functions.addNewDish(dishList);
                    break;
                }
                case "5":{
                    System.out.print("Name of restaurant: ");
                    String menu = menuSearch.nextLine();
                    resList.menuByRestaurant(menu);
                    pause.pause();
                    break;
                }
                case "6":{
                    functions.addDishToOrder(resList, order);
                    pause.pause();
                    break;
                }
                case "7":{
                    System.out.println(order);
                    pause.pause();
                    break;
                }
                case "8":{
                    functions.checkout(order, clientList);
                    pause.pause();
                    break;
                }
                case "9":{
                    operations.getClient().getOrderHistory();
                    pause.pause();
                    break;
                }
                case "10":{
                    System.out.print("Enter new address: ");
                    String newAddress = addressInput.nextLine();
                    operations.getClient().setAddress(newAddress);
                    pause.pause();
                    break;
                }
                case "11":{
                    System.out.println(operations.getClient());
                    pause.pause();
                    break;
                }
                case "0":{
                    operations.setLoginStateClient(false);
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

        while(operations.isLoginStateCourier()){
            System.out.println();
            System.out.println("Option Menu(choose index of the action)");
            System.out.println("1. Register delivery");
            System.out.println("0. Logout");
            System.out.println("\n");

            System.out.print("Option: ");
            String option = optionInput.nextLine();

            switch (option){
                case "1":{
                    functions.registerOrder(operations, orders, clientList);
                    pause.pause();
                    break;
                }
                case "0":{
                    operations.setLoginStateCourier(false);
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
