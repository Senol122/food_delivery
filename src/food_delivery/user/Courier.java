package food_delivery.user;
import food_delivery.services.Identifiable;

public class Courier extends  User implements Identifiable {
    private String courierId;
    private String carNumberPlate;

    public Courier() {
    }

    public Courier(String name, String email, String password, String phone, String carNumberPlate){
        super(name, email, password, phone);
        this.courierId = genID();
        this.carNumberPlate = carNumberPlate;
    }

    public String getCourierId() {
        return courierId;
    }

    public String getCarNumberPlate() {
        return carNumberPlate;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public void setCarNumberPlate(String carNumberPlate) {
        this.carNumberPlate = carNumberPlate;
    }

    public boolean isEmpty(){
        return courierId == null && carNumberPlate == null && name == null && phone == null && email == null && password == null;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "courier_id='" + courierId + '\'' +
                ", carNumberPlate='" + carNumberPlate + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public String getID() {
        return courierId;
    }
}
