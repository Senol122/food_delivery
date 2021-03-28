package food_delivery;

import food_delivery.user.*;
import food_delivery.services.*;
import food_delivery.restaurant.*;
import food_delivery.order.*;
import food_delivery.company.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        ------------------INIT CLIENTS---------------------
        Client client1 = new Client("Sarah Smith", "222-222-222-2222", "sarah21@gmail.com", "Elmore st. 21");
        Client client2 = new Client("John Doe", "333-333-333-3333", "jdoe12@gmail.com", "Smiths st. 43");
        Client client3 = new Client("Will Johnson", "555-555-555-5555", "willjohn667@gmail.com", "Avenue st. 89");
        Client client4 = new Client("Travis Webster", "666-666-666-6666", "travisss@gmail.com", "Hills st. 99");
        Client client5 = new Client("Brad Traversy", "999-999-999-9999", "bradt@gmail.com", "Elmore st. 54");

//        ------------------INIT COURIERS--------------------
        Courier courier1 = new Courier("Elaine J Jones", "111-111-111-1111", "RWM-7442");
        Courier courier2 = new Courier("Michael F Hernandez", "222-222-222-2222", "SED-7122");
        Courier courier3 = new Courier("Raymond D Owens", "666-666-666-6666", "JGD-6357");
        Courier courier4 = new Courier("Michael B Gall", "831-921-1647", "SYV-3666");
        Courier courier5 = new Courier("Robert E Padgett", "573-774-2641", "HDT-1832");

//        ------------------INIT SUPPLIERS-------------------
        Supplier supplier1 = new Supplier("James J Whittaker", "307-783-5679");
        Supplier supplier2 = new Supplier("Shari E Williams", "339-502-2571");
        Supplier supplier3 = new Supplier("Neil E Havens", "831-653-4150");
        Supplier supplier4 = new Supplier("John J Milano", "919-442-6286");
        Supplier supplier5 = new Supplier("Phillip D Hopkins", "540-798-4381");

//        -----------------INIT LISTS------------------------
        ClientList clientList = new ClientList();

        DeliveryCompany delivery = new DeliveryCompany();

        SupplierCompany supplier = new SupplierCompany();

//        ----------------POPULATING LISTS-------------------

        clientList.addClient(client1);
        clientList.addClient(client2);
        clientList.addClient(client3);
        clientList.addClient(client4);
        clientList.addClient(client5);

        delivery.addCourier(courier1);
        delivery.addCourier(courier2);
        delivery.addCourier(courier3);
        delivery.addCourier(courier4);
        delivery.addCourier(courier5);

        supplier.addSupplier(supplier1);
        supplier.addSupplier(supplier2);
        supplier.addSupplier(supplier3);
        supplier.addSupplier(supplier4);
        supplier.addSupplier(supplier5);

//        -------------INIT DISHES---------------------------
        Dish dish1 = new Dish("Ravioli", "230g", 23);
        Dish dish2 = new Dish("Steak", "340g", 67);
        Dish dish3 = new Dish("Pasta", "220g", 32);
        Dish dish4 = new Dish("Ramen", "150g", 19);
        Dish dish5 = new Dish("Curry", "200g", 25);
        Dish dish6 = new Dish("Broccoli and squid soup", "120g", 59);
        Dish dish7 = new Dish("Caraway seed and squid salad", "150g", 76);
        Dish dish8 = new Dish("Broccoli and spinach crepes", "210g", 82);
        Dish dish9 = new Dish("Blackberry scones with blackberry jam", "340g", 34);

//        ------------INIT MENUS-------------------------------
        Menu menu1 = new Menu();
        Menu menu2 = new Menu();
        Menu menu3 = new Menu();

//        ------------POPULATING MENUS-------------------------
        menu1.addDish(dish1);
        menu1.addDish(dish2);
        menu1.addDish(dish3);

        menu2.addDish(dish4);
        menu2.addDish(dish5);
        menu2.addDish(dish6);

        menu3.addDish(dish7);
        menu3.addDish(dish8);
        menu3.addDish(dish9);

//        ------------INIT RESTAURANTS------------------------
        Restaurant restaurant1 = new Restaurant("Mezaluna", "Elmore st. 12", menu1);
        Restaurant restaurant2 = new Restaurant("Golful Pescarilor", "Smiths st. 45", menu2);
        Restaurant restaurant3 = new Restaurant("Sabroso", "Avenue st. 65", menu3);

//        ------------INIT RESTAURANT LIST--------------------
        RestaurantList resList = new RestaurantList();

        resList.addRestaurant(restaurant1);
        resList.addRestaurant(restaurant2);
        resList.addRestaurant(restaurant3);

//        ------------INIT KEYBOARD INPUTS---------------------
        String email = "";
        Scanner emailInput = new Scanner(System.in);
        Scanner optionInput = new Scanner(System.in);
        Scanner dishSearch = new Scanner(System.in);
        Scanner menuSearch = new Scanner(System.in);

//        ------------LOGIN------------------------------------
        System.out.println("Welcome to Hot Orders!");
        System.out.println("Enter your credentials bellow");
        System.out.print("Email: ");
        String emailAux = emailInput.nextLine();
        PauseTest pause = new PauseTest();

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



        while(!email.isEmpty()){
            System.out.println();
            System.out.println("Option Menu(choose index of the action)");
            System.out.println("1. See full list of Restaurants");
            System.out.println("2. See full list of Couriers");
            System.out.println("3. Search dish by name");
            System.out.println("4. See the menu of a specific restaurant");
            System.out.println("5. Add dish to order");
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
                    System.out.println("...");
                    break;
                }
                case "0":{
                    email = "";
                    System.out.println("Logout");
                    pause.pause();
                    break;
                }

            }
        }
    }
}
