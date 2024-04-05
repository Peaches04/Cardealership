public class Car {
    private int id;
    private String type;
    private String model;
    private String condition;
    private String color;
    private int capacity;
    private float mileage;
    private String fuelType;
    private String transmission;
    private String vin;
    private float price;
    private int carsAvailable;

    public Car(int id, String type, String model, String condition, String color, int capacity,
               float mileage, String fuelType, String transmission, String vin, float price, int carsAvailable) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.condition = condition;
        this.color = color;
        this.capacity = capacity;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.vin = vin;
        this.price = price;
        this.carsAvailable = carsAvailable;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Type: " + type + ", Model: " + model + ", Condition: " + condition +
                           ", Color: " + color + ", Capacity: " + capacity + ", Mileage: " + mileage +
                           ", Fuel Type: " + fuelType + ", Transmission: " + transmission + ", VIN: " + vin +
                           ", Price: $" + price + ", Cars Available: " + carsAvailable);
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }

    public String getCondition() {
        return condition;
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getMileage() {
        return mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getVin() {
        return vin;
    }

    public float getPrice() {
        return price;
    }

    public int getCarsAvailable() {
        return carsAvailable;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCarsAvailable(int carsAvailable) {
        this.carsAvailable = carsAvailable;
    }
}