package food_delivery.services;

import food_delivery.company.DeliveryCompany;
import food_delivery.company.SupplierCompany;
import food_delivery.user.Client;
import food_delivery.user.ClientList;
import food_delivery.user.Courier;
import food_delivery.user.Supplier;

import java.util.Scanner;

public class AccountOperations implements Identifiable {
    private Client client = new Client();
    private Courier courier = new Courier();
    private Supplier supplier = new Supplier();
    private boolean loginStateClient = false;
    private boolean loginStateCourier = false;
    private boolean loginStateSupplier = false;
    private PauseTest pause = new PauseTest();

    public void login(ClientList clientList){
        Functions functions = new Functions();

        Scanner emailInput = new Scanner(System.in);
        Scanner optionInput = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Register \n");

        System.out.print("Option: ");
        String option = optionInput.nextLine();

        switch (option){
            case "1": {
                System.out.println("Enter your credentials bellow");
                System.out.print("Email: ");
                String emailAux = emailInput.nextLine();

                while(this.client.isEmpty()){
                    if(clientList.checkEmail(emailAux)){
                        this.client = clientList.findClient(emailAux);
                        this.loginStateClient = true;
                        functions.logLogin(client.getName());
                        System.out.println("You're logged in!");
                        pause.pause();
                    }   else {
                        System.out.println("Email not found.");
                        pause.pause();
                        System.out.print("Email: ");
                        emailAux = emailInput.nextLine();
                    }

                }
                break;
            }
            case "2": {
                Scanner nameInput = new Scanner(System.in);
                Scanner phoneInput = new Scanner(System.in);
                Scanner emailRegisterInput = new Scanner(System.in);
                Scanner addressInput = new Scanner(System.in);

                System.out.print("Name: ");
                String name = nameInput.nextLine();
                System.out.print("Phone: ");
                String phone = phoneInput.nextLine();
                System.out.print("Email: ");
                String emailRegister = emailRegisterInput.nextLine();
                System.out.print("Address: ");
                String address = addressInput.nextLine();

                while(this.client.isEmpty()){
                    if(name != null && phone != null && emailRegister != null && address != null){
                        if(clientList.findClient(emailRegister) != null){
                            System.out.println("There is already an user registered with this email address.");
                            pause.pause();
                        }   else {
                            this.client.setClient_id(genID());
                            this.client.setName(name);
                            this.client.setPhone(phone);
                            this.client.setEmail(emailRegister);
                            this.client.setAddress(address);
                            functions.logRegister(this.client.getName());
                            functions.registerClient(this.client);
                            this.loginStateClient = true;
                            System.out.println("You've registered a new account!");
                            pause.pause();
                        }
                    }   else {
                        System.out.println("Please fill in all fields.");
                        pause.pause();
                        System.out.print("Name: ");
                        name = nameInput.nextLine();
                        System.out.println("Phone: ");
                        phone = phoneInput.nextLine();
                        System.out.print("Email: ");
                        emailRegister = emailRegisterInput.nextLine();
                        System.out.print("Address: ");
                        address = addressInput.nextLine();
                    }
                }

                break;
            }
            default:{
                System.out.println("Option not found. Please choose 1 for Login or 2 for Register");
                break;
            }
        }


    }

    public void loginCourier(DeliveryCompany delivery){
        Functions functions = new Functions();

        Scanner carNumberPlateInput = new Scanner(System.in);

        System.out.println("Enter your car number plate bellow to login");
        System.out.print("Car number plate: ");
        String carNumberPlate = carNumberPlateInput.nextLine();

        while(this.courier.isEmpty()){
            if(delivery.checkCarNumberPlate(carNumberPlate)){
                this.courier = delivery.findCourierByCarNumberPlate(carNumberPlate);
                this.loginStateCourier = true;
                functions.logLogin(courier.getName());
                System.out.println("You're logged in!");
                pause.pause();
            }   else {
                System.out.println("Car number plate not found.");
                pause.pause();
                System.out.print("Car number plate: ");
                carNumberPlate = carNumberPlateInput.nextLine();
            }

        }
    }

    public void loginSupplier(SupplierCompany supplier){

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public boolean isLoginStateClient() {
        return loginStateClient;
    }

    public void setLoginStateClient(boolean loginStateClient) {
        this.loginStateClient = loginStateClient;
    }

    public boolean isLoginStateCourier() {
        return loginStateCourier;
    }

    public void setLoginStateCourier(boolean loginStateCourier) {
        this.loginStateCourier = loginStateCourier;
    }

    public boolean isLoginStateSupplier() {
        return loginStateSupplier;
    }

    public void setLoginStateSupplier(boolean loginStateSupplier) {
        this.loginStateSupplier = loginStateSupplier;
    }

    @Override
    public String getID() {
        return this.client.getClient_id();
    }
}
