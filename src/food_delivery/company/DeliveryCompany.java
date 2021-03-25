package food_delivery.company;

import food_delivery.user.Courier;
import java.util.ArrayList;

public class DeliveryCompany extends Company {
    private int nrOfCars;
    private ArrayList<Courier> couriers = new ArrayList<>();

    public DeliveryCompany(String name, int nrOfEmployees, boolean international, int nrOfCars, ArrayList<Courier> couriers) {
        super(name, nrOfEmployees, international);
        this.nrOfCars = nrOfCars;
        this.couriers = couriers;
    }

    public int getNrOfCars() {
        return nrOfCars;
    }

    public void setNrOfCars(int nrOfCars) {
        this.nrOfCars = nrOfCars;
    }

    public ArrayList<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(ArrayList<Courier> couriers) {
        this.couriers = couriers;
    }

    public Courier getCourier(int n){
        return couriers.get(n);
    }

    public void setCourier(Courier x, int n){
        this.couriers.set(n, x);
    }

    @Override
    public String toString() {
        return "DeliveryCompany{" +
                "name='" + name + '\'' +
                ", nrOfEmployees=" + nrOfEmployees +
                ", international=" + international +
                ", nrOfCars=" + nrOfCars +
                ", couriers=" + couriers +
                '}';
    }
}
