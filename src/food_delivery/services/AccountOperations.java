package food_delivery.services;

import food_delivery.company.DeliveryCompany;
import food_delivery.company.SupplierCompany;
import food_delivery.user.*;

import java.util.Scanner;

public class AccountOperations implements Identifiable {
    private Client client = new Client();
    private Courier courier = new Courier();
    private Supplier supplier = new Supplier();
    private RestaurantManager manager = new RestaurantManager();
    private boolean loginStateClient = false;
    private boolean loginStateCourier = false;
    private boolean loginStateManager = false;
    private boolean loginStateSupplier = false;
    private PauseTest pause = new PauseTest();

    public void loginClient(ClientList clientList){
        Functions functions = new Functions();

//        Login inputs
        Scanner emailInput = new Scanner(System.in);
        Scanner passwordInput = new Scanner(System.in);
        Scanner optionInput = new Scanner(System.in);

//        Register inputs
        Scanner nameInput = new Scanner(System.in);
        Scanner phoneInput = new Scanner(System.in);
        Scanner emailRegisterInput = new Scanner(System.in);
        Scanner passwordRegisterInput = new Scanner(System.in);
        Scanner addressInput = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Register \n");

        System.out.print("Option: ");
        String option = optionInput.nextLine();

        switch (option){
            case "1": {
                System.out.println("Enter your credentials bellow");
                System.out.print("Email: ");
                String email = emailInput.nextLine();
                System.out.print("Password: ");
                String password = passwordInput.nextLine();

                while(this.client.isEmpty()){
                    if(clientList.authenticate(email, password)){
                        this.client = clientList.findClient(email);
                        this.loginStateClient = true;
                        functions.logLogin(client.getName());
                        System.out.println("You're logged in!");
                        pause.pause();
                    }   else {
                        System.out.println("Email/password combination does not match any account");
                        pause.pause();
                        System.out.print("Email: ");
                        email = emailInput.nextLine();
                        System.out.print("Password: ");
                        password = passwordInput.nextLine();
                    }
                }
                break;
            }
            case "2": {
                System.out.print("Name: ");
                String name = nameInput.nextLine();
                System.out.print("Phone: ");
                String phone = phoneInput.nextLine();
                System.out.print("Email: ");
                String emailRegister = emailRegisterInput.nextLine();
                System.out.print("Password: ");
                String password = passwordRegisterInput.nextLine();
                System.out.print("Address: ");
                String address = addressInput.nextLine();

                while(this.client.isEmpty()){
                    if(!name.isEmpty() && !phone.isEmpty() && !emailRegister.isEmpty() && !password.isEmpty() && !address.isEmpty()){
                        if(clientList.findClient(emailRegister) != null){
                            System.out.println("There is already an user registered with this email address.");
                            pause.pause();
                            System.out.print("Name: ");
                            name = nameInput.nextLine();
                            System.out.println("Phone: ");
                            phone = phoneInput.nextLine();
                            System.out.print("Email: ");
                            emailRegister = emailRegisterInput.nextLine();
                            System.out.print("Password: ");
                            password = passwordRegisterInput.nextLine();
                            System.out.print("Address: ");
                            address = addressInput.nextLine();
                        }   else {
                            this.client.setClient_id(genID());
                            this.client.setName(name);
                            this.client.setPhone(phone);
                            this.client.setEmail(emailRegister);
                            this.client.setPassword(password);
                            this.client.setAddress(address);
                            functions.insertClient(this.client);
                            functions.logClientRegister(this.client.getName());
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
                        System.out.print("Password: ");
                        password = passwordRegisterInput.nextLine();
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

    public void deleteClient(ClientList clientList){
        Functions functions = new Functions();
        Scanner confirmPasswordInput = new Scanner(System.in);

        System.out.print("Type your password to confirm account deletion: ");
        String confirmPassword = confirmPasswordInput.nextLine();

        if(this.client.getPassword().equals(confirmPassword)){
            functions.deleteClient(this.client);
            this.loginStateClient = false;
            clientList.deleteClient(this.client.getClient_id());
            this.client = null;
            System.out.println("Account deleted.");
        }
    }

    public void loginCourier(DeliveryCompany delivery){
        Functions functions = new Functions();

//        Login inputs
        Scanner emailInput = new Scanner(System.in);
        Scanner passwordInput = new Scanner(System.in);

//        Register inputs
        Scanner nameInput = new Scanner(System.in);
        Scanner phoneInput = new Scanner(System.in);
        Scanner emailRegisterInput = new Scanner(System.in);
        Scanner passwordRegisterInput = new Scanner(System.in);
        Scanner CNPInput = new Scanner(System.in);          // short for carNumberPlateInput
//
        Scanner optionInput = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Register \n");

        System.out.print("Option: ");
        String option = optionInput.nextLine();

        switch (option) {
            case "1": {
                System.out.println("Enter your credentials bellow");
                System.out.print("Email: ");
                String email = emailInput.nextLine();
                System.out.print("Password: ");
                String password = passwordInput.nextLine();

                while(this.courier.isEmpty()){
                    if(delivery.authenticate(email, password)){
                        this.courier = delivery.findCourierByEmail(email);
                        this.loginStateCourier = true;
                        functions.logLogin(courier.getName());
                        System.out.println("You're logged in!");
                        pause.pause();
                    }   else {
                        System.out.println("Email/password combination does not match any account.");
                        pause.pause();
                        System.out.print("Car number plate: ");
                        email = emailInput.nextLine();
                        System.out.print("Password: ");
                        password = passwordInput.nextLine();
                    }
                }
                break;
            }
            case "2" :{
                System.out.print("Name: ");
                String name = nameInput.nextLine();
                System.out.print("Phone: ");
                String phone = phoneInput.nextLine();
                System.out.print("Email: ");
                String email = emailRegisterInput.nextLine();
                System.out.print("Password: ");
                String password = passwordRegisterInput.nextLine();
                System.out.print("Car Number Plate: ");
                String carNumberPlateRegister = CNPInput.nextLine();

                while(this.courier.isEmpty()){
                    if(!name.isEmpty() && !phone.isEmpty() && !carNumberPlateRegister.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                        if(delivery.findCourierByEmail(email) != null){
                            System.out.println("There is already a courier registered with this email.");
                            System.out.print("Name: ");
                            name = nameInput.nextLine();
                            System.out.println("Phone: ");
                            phone = phoneInput.nextLine();
                            System.out.print("Email: ");
                            email = emailRegisterInput.nextLine();
                            System.out.print("Password: ");
                            password = passwordRegisterInput.nextLine();
                            System.out.print("Car Number Plate: ");
                            carNumberPlateRegister = CNPInput.nextLine();
                            pause.pause();
                        } else {
                            this.courier.setCourierId(genID());
                            this.courier.setName(name);
                            this.courier.setPhone(phone);
                            this.courier.setEmail(email);
                            this.courier.setPassword(password);
                            this.courier.setCarNumberPlate(carNumberPlateRegister);
                            this.loginStateCourier = true;
                            functions.insertCourier(this.courier);
                            functions.logCourierRegister(this.courier.getName());
                            System.out.println("You're logged in!");
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
                        email = emailRegisterInput.nextLine();
                        System.out.print("Password: ");
                        password = passwordRegisterInput.nextLine();
                        System.out.print("Car Number Plate: ");
                        carNumberPlateRegister = CNPInput.nextLine();
                    }
                }
                break;
            }
            default: {
                System.out.println("Option not found. Please choose 1 for Login or 2 for Register");
                break;
            }
        }
    }

    public void deleteCourier(DeliveryCompany delivery){
        Functions functions = new Functions();
        Scanner confirmPasswordInput = new Scanner(System.in);

        System.out.print("Type your password to confirm account deletion: ");
        String confirmPassword = confirmPasswordInput.nextLine();

        if(this.courier.getPassword().equals(confirmPassword)){
            functions.deleteCourier(this.courier);
            this.loginStateCourier = false;
            delivery.deleteCourier(this.courier.getCourierId());
            this.courier = null;
            System.out.println("Account deleted.");
        }
    }

    public void loginManager(RestaurantManagerList managerList) {
        Functions functions = new Functions();

//        Login inputs
        Scanner emailInput = new Scanner(System.in);
        Scanner passwordInput = new Scanner(System.in);
        Scanner optionInput = new Scanner(System.in);

//        Register inputs
        Scanner nameInput = new Scanner(System.in);
        Scanner phoneInput = new Scanner(System.in);
        Scanner emailRegisterInput = new Scanner(System.in);
        Scanner passwordRegisterInput = new Scanner(System.in);
        Scanner restaurantIdInput = new Scanner(System.in);
        Scanner workExperienceInput = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Register \n");

        System.out.print("Option: ");
        String option = optionInput.nextLine();

        switch (option) {
            case "1": {
                System.out.println("Enter your credentials bellow");
                System.out.print("Email: ");
                String email = emailInput.nextLine();
                System.out.print("Password: ");
                String password = passwordInput.nextLine();

                while(this.manager.isEmpty()){
                    if(managerList.authenticate(email, password)){
                        this.manager = managerList.findManager(email);
                        this.loginStateManager = true;
                        functions.logLogin(manager.getName());
                        System.out.println("You're logged in!");
                        pause.pause();
                    }   else {
                        System.out.println("Email/password combination does not match any account");
                        pause.pause();
                        System.out.print("Email: ");
                        email = emailInput.nextLine();
                        System.out.print("Password: ");
                        password = passwordInput.nextLine();
                    }
                }
                break;
            }
            case "2": {
                System.out.print("Name: ");
                String name = nameInput.nextLine();
                System.out.print("Phone: ");
                String phone = phoneInput.nextLine();
                System.out.print("Email: ");
                String emailRegister = emailRegisterInput.nextLine();
                System.out.print("Password: ");
                String password = passwordRegisterInput.nextLine();
                System.out.print("Restaurant ID: ");
                String restaurantId = restaurantIdInput.nextLine();
                System.out.print("Work experience(yrs): ");
                String workExperience = workExperienceInput.nextLine();

                while(this.manager.isEmpty()){
                    if(!name.isEmpty() && !phone.isEmpty() && !emailRegister.isEmpty() && !password.isEmpty() && !restaurantId.isEmpty() && !workExperience.isEmpty()){
                        if(managerList.findManager(emailRegister) != null){
                            System.out.println("There is already a manager registered with this email address.");
                            pause.pause();
                            System.out.print("Name: ");
                            name = nameInput.nextLine();
                            System.out.println("Phone: ");
                            phone = phoneInput.nextLine();
                            System.out.print("Email: ");
                            emailRegister = emailRegisterInput.nextLine();
                            System.out.print("Password: ");
                            password = passwordRegisterInput.nextLine();
                            System.out.print("Restaurant ID: ");
                            restaurantId = restaurantIdInput.nextLine();
                            System.out.print("Work experience(yrs): ");
                            workExperience = workExperienceInput.nextLine();
                        }   else {
                            this.manager.setManagerID(genID());
                            this.manager.setName(name);
                            this.manager.setPhone(phone);
                            this.manager.setEmail(emailRegister);
                            this.manager.setPassword(password);
                            this.manager.setRestaurantID(restaurantId);
                            this.manager.setWorkExperience(workExperience);
                            functions.insertManager(this.manager);
                            this.loginStateManager = true;
                            System.out.println("You've registered a new account!");
                            pause.pause();
                        }
                    }   else {
                        System.out.println("Please fill in all fields.");
                        pause.pause();
                        System.out.print("Name: ");
                        name = nameInput.nextLine();
                        System.out.print("Phone: ");
                        phone = phoneInput.nextLine();
                        System.out.print("Email: ");
                        emailRegister = emailRegisterInput.nextLine();
                        System.out.print("Password: ");
                        password = passwordRegisterInput.nextLine();
                        System.out.print("Restaurant ID: ");
                        restaurantId = restaurantIdInput.nextLine();
                        System.out.print("Work experience(yrs): ");
                        workExperience = workExperienceInput.nextLine();
                    }
                }
                break;
            }
            default: {
                System.out.println("Option not found. Please choose 1 for Login or 2 for Register");
                break;
            }
        }
    }

    public void deleteManager(RestaurantManagerList managerList){
        Functions functions = new Functions();
        Scanner confirmPasswordInput = new Scanner(System.in);

        System.out.print("Type your password to confirm account deletion: ");
        String confirmPassword = confirmPasswordInput.nextLine();

        if(this.manager.getPassword().equals(confirmPassword)){
            functions.deleteManager(this.manager);
            this.loginStateManager = false;
            managerList.deleteManager(this.manager.getManagerID());
            this.manager = null;
            System.out.println("Account deleted.");
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

    public RestaurantManager getManager() {
        return manager;
    }

    public void setManager(RestaurantManager manager) {
        this.manager = manager;
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

    public boolean isLoginStateManager() {
        return loginStateManager;
    }

    public void setLoginStateManager(boolean loginStateManager) {
        this.loginStateManager = loginStateManager;
    }

    @Override
    public String getID() {
        return this.client.getClient_id();
    }
}
