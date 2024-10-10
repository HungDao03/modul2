public abstract class Phone {
    private int id;
    private String name;
    private double price; // giá bán
    private int quantity;  // số lượng
    private String manufacturer;  // nhà sản xuất

    public Phone(int id, String name, double price, int quantity, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
    }

    // Hàm trừu tượng
    public abstract void displayInfo();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() { //giá bán
        return price;
    }

    public int getQuantity() { // số lượng
        return quantity;
    }

    public String getManufacturer() { // nhà sản xuất
        return manufacturer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
