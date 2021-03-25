package food_delivery.company;

import food_delivery.user.Supplier;

import java.util.ArrayList;

public class SupplierCompany extends Company {
    private int nrOfTrucks;
    private ArrayList<Supplier> suppliers = new ArrayList<>();

    public SupplierCompany(String name, int nrOfEmployees, boolean international, int nrOfTrucks, ArrayList<Supplier> suppliers) {
        super(name, nrOfEmployees, international);
        this.nrOfTrucks = nrOfTrucks;
        this.suppliers = suppliers;
    }

    public int getNrOfTrucks() {
        return nrOfTrucks;
    }

    public void setNrOfTrucks(int nrOfTrucks) {
        this.nrOfTrucks = nrOfTrucks;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Supplier getSupplier(int n){
        return suppliers.get(n);
    }

    public void setSupplier(Supplier x, int n){
        this.suppliers.set(n, x);
    }

    @Override
    public String toString() {
        return "SupplierCompany{" +
                "name='" + name + '\'' +
                ", nrOfEmployees=" + nrOfEmployees +
                ", international=" + international +
                ", nrOfTrucks=" + nrOfTrucks +
                ", suppliers=" + suppliers +
                '}';
    }
}
