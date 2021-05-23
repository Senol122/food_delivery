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
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Functions implements Identifiable {

    private PauseTest pause = new PauseTest();
    Connection con;
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

    public void checkout(Order orderX, ClientList clientList){
        Scanner checkoutInput = new Scanner(System.in);

        System.out.println("Total amount: " + orderX.getTotalAmount() + "\n");
        System.out.println("Proceed to payment?[Y/N]");
        String checkoutIn = checkoutInput.nextLine();
        if(checkoutIn.equals("Y") || checkoutIn.equals("y")){
            clientList.findClientById(orderX.getClient_id()).getHistory().addOrder(orderX);
            this.logOrder(clientList.findClientById(orderX.getClient_id()).getName(), orderX.getOrder_id());
            System.out.println("Checkout done! Enjoy your order :)");
        }   else {
            System.out.println("Continue shopping");
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

    public void logLogin(String name){
        try{
            File file = new File("log.csv");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter logWriter = new BufferedWriter(fr);
            logWriter.write( "The user with the name " + name + " logged in at " + format.format(date) );
            logWriter.newLine();
            logWriter.close();
            fr.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void logClientRegister(String clientName){
        try{
            File file = new File("log.csv");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter logWriter = new BufferedWriter(fr);
            logWriter.write( "The client with the name " + clientName + " registered at " + format.format(date) );
            logWriter.newLine();
            logWriter.close();
            fr.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void logCourierRegister(String courierName){
        try{
            File file = new File("log.csv");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter logWriter = new BufferedWriter(fr);
            logWriter.write( "The courier with the name " + courierName + " registered at " + format.format(date) );
            logWriter.newLine();
            logWriter.close();
            fr.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void logRegisterOrder(String courierName, String orderId){
        try{
            File file = new File("log.csv");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter logWriter = new BufferedWriter(fr);
            logWriter.write( courierName + " registered a successful delivery with the ID: " + orderId + " - " + format.format(date) );
            logWriter.newLine();
            logWriter.close();
            fr.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void registerClient(Client clientX){
        try{
            File file = new File("clients.csv");
            FileWriter fr = new FileWriter(file, true);
            BufferedWriter logWriter = new BufferedWriter(fr);

            StringBuilder sb = new StringBuilder();

            sb.append(clientX.getClient_id());
            sb.append(",");
            sb.append(clientX.getName());
            sb.append(",");
            sb.append(clientX.getPhone());
            sb.append(",");
            sb.append(clientX.getEmail());
            sb.append(",");
            sb.append(clientX.getAddress());
            sb.append("\n");

            logWriter.write(sb.toString());
            logWriter.newLine();
            logWriter.close();
            fr.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void registerOrder(AccountOperations operations, ArrayList<Order> orders, ClientList clientList){
        Scanner orderClientIdInput = new Scanner(System.in);
        Scanner orderDateInput = new Scanner(System.in);

        System.out.println("Enter info about the order delivery");
        System.out.print("Client Id: ");
        String orderClientId = orderClientIdInput.nextLine();
        System.out.print("Order date: ");
        String orderDate = orderDateInput.nextLine();

        Order newOrder = new Order(orderClientId, operations.getCourier().getCourier_id(), orderDate);

        orders.add(newOrder);
        clientList.findClientById(orderClientId).getHistory().addOrder(newOrder);

        logRegisterOrder(operations.getCourier().getName(), newOrder.getOrder_id());

        System.out.println("Delivery successfully registered!");
    }

    public void createConnection(ClientList List, DeliveryCompany delivery, DishList dishList) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

            Statement statement = con.createStatement();
            ResultSet clientRS = statement.executeQuery("SELECT * FROM jdbc.clients");
            while(clientRS.next()){
                Client aux = new Client();

                String id = clientRS.getString("id");
                String name = clientRS.getString("name");
                String phoneNumber = clientRS.getString("phoneNumber");
                String email = clientRS.getString("email");
                String address = clientRS.getString("address");

                aux.setClient_id(id);
                aux.setName(name);
                aux.setPhone(phoneNumber);
                aux.setEmail(email);
                aux.setAddress(address);

                List.addClient(aux);
            }

            ResultSet courierRS = statement.executeQuery("SELECT * FROM jdbc.couriers");
            while(courierRS.next()){
                Courier aux = new Courier();

                String id = courierRS.getString("courierID");
                String name = courierRS.getString("name");
                String phoneNumber = courierRS.getString("phoneNumber");
                String carNumberPlate = courierRS.getString("carNumberPlate");

                aux.setCourier_id(id);
                aux.setName(name);
                aux.setPhone(phoneNumber);
                aux.setCarNumberPlate(carNumberPlate);

                delivery.addCourier(aux);
            }

            ResultSet dishRS = statement.executeQuery("SELECT * FROM jdbc.dishes");
            while(dishRS.next()){
                Dish aux = new Dish();

                String id = dishRS.getString("dishID");
                String name = dishRS.getString("name");
                String weight = dishRS.getString("weight");
                int price = dishRS.getInt("price");

                aux.setDish_id(id);
                aux.setName(name);
                aux.setWeight(weight);
                aux.setPrice(price);

                dishList.addDish(aux);
            }

            statement.close();

         } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertClient(Client x) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

            String id = x.getClient_id();
            String name = x.getName();
            String phone = x.getPhone();
            String email = x.getEmail();
            String address = x.getAddress();

            Statement statement = con.createStatement();

            String dbInsertClient = "INSERT INTO jdbc.clients VALUES('" + id + "', '"+ name +"', '"+ phone +"', '"+ email +"', '"+ address +"')";

            statement.execute(dbInsertClient);
            statement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertCourier(Courier x){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

            String id = x.getCourier_id();
            String name = x.getName();
            String phone = x.getPhone();
            String carNumberPlate = x.getCarNumberPlate();

            Statement statement = con.createStatement();

            String dbInsertCourier = "INSERT INTO jdbc.couriers VALUES('" + id + "', '"+ name +"', '"+ phone +"', '"+ carNumberPlate +"')";

            statement.execute(dbInsertCourier);
            statement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertDish(Dish x){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

            String id = x.getDish_id();
            String name = x.getName();
            String weight = x.getWeight();
            int price = x.getPrice();

            Statement statement = con.createStatement();

            String dbInsertDish = "INSERT INTO jdbc.dishes VALUES('" + id + "', '"+ name +"', '"+ weight +"', '"+ price +"')";

            statement.execute(dbInsertDish);
            statement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addNewDish(DishList dishList){
        Scanner nameInput = new Scanner(System.in);
        Scanner weightInput = new Scanner(System.in);
        Scanner priceInput = new Scanner(System.in);

        System.out.print("Dish name: ");
        String name = nameInput.nextLine();
        System.out.print("Weight(g): ");
        String weight = weightInput.nextLine();
        System.out.print("Price: ");
        int price = Integer.parseInt(priceInput.nextLine());

        boolean ok = false;

        while(!ok) {
            if(!name.isEmpty() && !weight.isEmpty() && price > 0){
                Dish newDish = new Dish();

                newDish.setDish_id(genID());
                newDish.setName(name);
                newDish.setWeight(weight);
                newDish.setPrice(price);

                insertDish(newDish);
                dishList.addDish(newDish);
                ok = true;
                System.out.println("Dish successfully added!");
                pause.pause();
            } else {
                System.out.println("Please fill in all fields");
                pause.pause();
                System.out.print("Dish name: ");
                name = nameInput.nextLine();
                System.out.print("Weight(g): ");
                weight = weightInput.nextLine();
                System.out.print("Price: ");
                price = Integer.parseInt(priceInput.nextLine());
            }
        }
    }

    public void updateClientAddress(Client x) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");

            Statement statement = con.createStatement();

            String dbUpdateAddress = "UPDATE jdbc.clients SET address='"+ x.getAddress() +"' WHERE(id='"+ x.getClient_id() +"')";

            statement.execute(dbUpdateAddress);
            statement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String getID() {
        return null;
    }
}
