package food_delivery;

import food_delivery.user.*;
import food_delivery.services.*;
import food_delivery.restaurant.*;
import food_delivery.order.*;
import food_delivery.company.*;
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

//        -----------INIT ORDER HISTORY------------------------
        Pair<Dish, Integer> pair1 = new Pair<>(dish1, 3);
        Pair<Dish, Integer> pair2 = new Pair<>(dish5, 6);
        Pair<Dish, Integer> pair3 = new Pair<>(dish7, 1);
        Pair<Dish, Integer> pair4 = new Pair<>(dish3, 3);
        Pair<Dish, Integer> pair5 = new Pair<>(dish6, 7);
        Pair<Dish, Integer> pair6 = new Pair<>(dish9, 2);
        Pair<Dish, Integer> pair7 = new Pair<>(dish3, 5);
        Pair<Dish, Integer> pair8 = new Pair<>(dish5, 3);
        Pair<Dish, Integer> pair9 = new Pair<>(dish1, 8);

        Order order1 = new Order(client1.getClient_id(), courier3.getCourier_id(), "23-08-2021");
        Order order2 = new Order(client1.getClient_id(), courier5.getCourier_id(), "14-05-2021");
        Order order3 = new Order(client3.getClient_id(), courier2.getCourier_id(), "12-03-2020");
        Order order4 = new Order(client2.getClient_id(), courier4.getCourier_id(), "05-01-2021");
        Order order5 = new Order(client5.getClient_id(), courier1.getCourier_id(), "15-04-2021");

        order1.addOrderItem(pair1);
        order2.addOrderItem(pair2);
        order2.addOrderItem(pair9);
        order3.addOrderItem(pair3);
        order3.addOrderItem(pair4);
        order4.addOrderItem(pair5);
        order5.addOrderItem(pair6);
        order5.addOrderItem(pair7);
        order5.addOrderItem(pair8);

        client1.getHistory().addOrder(order1);
        client1.getHistory().addOrder(order2);
        client3.getHistory().addOrder(order3);
        client2.getHistory().addOrder(order4);
        client5.getHistory().addOrder(order5);

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
