package food_delivery.user;

public class RestaurantManager extends User{
    private String restaurantID;
    private String managerID;
    private String workExperience;

    public RestaurantManager() {
    }

    public RestaurantManager(String name, String email, String password, String phone, String managerID, String restaurantID, String workExperience) {
        super(name, email, password, phone);
        this.managerID = managerID;
        this.restaurantID = restaurantID;
        this.workExperience = workExperience;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public boolean isEmpty(){
        return managerID == null && restaurantID == null && name == null && phone == null && email == null && password == null && workExperience == null;
    }

    @Override
    public String toString() {
        return "RestaurantManager{" +
                "restaurantID='" + restaurantID + '\'' +
                ", managerID='" + managerID + '\'' +
                ", workExperience='" + workExperience + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
