package food_delivery.user;
import food_delivery.services.Identifiable;

public class Supplier extends User implements Identifiable{
    private String supplier_id;

    public Supplier(String name, String phone){
        super(name, phone);
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
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public String getID() {
        return supplier_id;
    }
}
