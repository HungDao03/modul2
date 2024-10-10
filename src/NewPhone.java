public class NewPhone extends Phone {
    private int warrantyPeriod;
    private String warrantyScope;

    public NewPhone(int id, String name, double price, int quantity, String manufacturer, int warrantyPeriod, String warrantyScope) {
        super(id, name, price, quantity, manufacturer);
        this.warrantyPeriod = warrantyPeriod;
        this.warrantyScope = warrantyScope;
    }

    // Phương thức đã được override
    @Override
    public void displayInfo() {
        System.out.println("New Phone:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice() + " VNĐ");
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Warranty Period: " + warrantyPeriod + " months");
        System.out.println("Warranty Scope: " + warrantyScope);
    }
}
