package food_delivery.user;
import food_delivery.services.Identifiable;

public class Courier extends  User implements Identifiable {
    private String courier_id;
    private String carNumberPlate;

    public Courier(String name, String phone, String carNumberPlate){
        super(name, phone);
        this.courier_id = genID();
        this.carNumberPlate = carNumberPlate;
    }

    public String getCourier_id() {
        return courier_id;
    }

    public String getCarNumberPlate() {
        return carNumberPlate;
    }

    public void setCourier_id(String courier_id) {
        this.courier_id = courier_id;
    }

    public void setCarNumberPlate(String carNumberPlate) {
        this.carNumberPlate = carNumberPlate;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "courier_id='" + courier_id + '\'' +
                ", carNumberPlate='" + carNumberPlate + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public String getID() {
        return courier_id;
    }
}
