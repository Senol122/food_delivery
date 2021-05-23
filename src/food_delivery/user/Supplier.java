package food_delivery.user;
import food_delivery.services.Identifiable;

public class Supplier extends User implements Identifiable{
    private String supplier_id;

    public Supplier() {
    }

    public Supplier(String name, String email, String password, String phone){
        super(name, email, password, phone);
        this.supplier_id = genID();
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplier_id='" + supplier_id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public String getID() {
        return supplier_id;
    }
}
