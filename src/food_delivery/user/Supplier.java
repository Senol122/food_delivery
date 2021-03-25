package food_delivery.user;

public class Supplier extends User{
    private int supplier_id;

    public Supplier(String name, String phone, int supplier_id){
        super(name, phone);
        this.supplier_id = supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplier_id=" + supplier_id +
                '}';
    }
}
