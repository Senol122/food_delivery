package food_delivery.user;

public class Courier extends  User {
    private int courier_id;
    private String carNumberPlate;

    public Courier(String name, String phone, int courier_id, String carNumberPlate){
        super(name, phone);
        this.courier_id = courier_id;
        this.carNumberPlate = carNumberPlate;
    }

    public int getCourier_id() {
        return courier_id;
    }

    public String getCarNumberPlate() {
        return carNumberPlate;
    }

    public void setCourier_id(int courier_id) {
        this.courier_id = courier_id;
    }

    public void setCarNumberPlate(String carNumberPlate) {
        this.carNumberPlate = carNumberPlate;
    }

    @Override
    public String toString() {
        return "Courier{" +
                "courier_id=" + courier_id +
                ", carNumberPlate='" + carNumberPlate + '\'' +
                '}';
    }
}
