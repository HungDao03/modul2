public class UsedPhone extends Phone {
    private String importCountry;
    private String condition;

    public UsedPhone(int id, String name, double price, int quantity, String manufacturer, String importCountry, String condition) {
        super(id, name, price, quantity, manufacturer);
        this.importCountry = importCountry;
        this.condition = condition;
    }

    @Override
    public void displayInfo() {
        System.out.println("Used Phone:");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice() + " VNĐ");
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Manufacturer: " + getManufacturer());
        System.out.println("Import Country: " + importCountry);
        System.out.println("Condition: " + condition);
    }
}