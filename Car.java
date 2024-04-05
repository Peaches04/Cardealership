/**
 * Represents a car with various details such as type, model, condition, and more.
 * Provides both getters and setters for manipulating car properties.
 */
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

    /**
     * Constructs a new Car instance with specified details.
     *
     * @param id The unique identifier for the car.
     * @param type The type of the car (e.g., Sedan, SUV).
     * @param model The model of the car.
     * @param condition The condition of the car (e.g., New, Used).
     * @param color The color of the car.
     * @param capacity The seating capacity of the car.
     * @param mileage The mileage of the car.
     * @param fuelType The type of fuel the car uses (e.g., Gasoline, Electric).
     * @param transmission The transmission type of the car (e.g., Automatic, Manual).
     * @param vin The Vehicle Identification Number.
     * @param price The price of the car.
     * @param carsAvailable The number of cars available for this model.
     */
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

    /**
     * Displays the details of the car.
     */
    public void displayDetails() {
        System.out.println("ID: " + id + ", Type: " + type + ", Model: " + model + ", Condition: " + condition +
                           ", Color: " + color + ", Capacity: " + capacity + ", Mileage: " + mileage +
                           ", Fuel Type: " + fuelType + ", Transmission: " + transmission + ", VIN: " + vin +
                           ", Price: $" + price + ", Cars Available: " + carsAvailable);
    }

    /**
     * Converts car details into a String array suitable for CSV file storage.
     *
     * @return A String array containing car details.
     */
    public String[] ArrayListToCSV() {
        return new String[]{
            String.valueOf(id), // Convert numeric values to String
            type,
            model,
            condition,
            color,
            String.valueOf(capacity),
            String.valueOf(mileage),
            fuelType,
            transmission,
            vin,
            String.valueOf(price),
            String.valueOf(carsAvailable)
        };
    }

    // Getters

    /**
     * @return The ID of the car.
     */
    public int getId() {
        return id;
    }

    /**
     * @return The type of the car.
     */
    public String getType() {
        return type;
    }

    /**
     * @return The model of the car.
     */
    public String getModel() {
        return model;
    }

    /**
     * @return The condition of the car.
     */
    public String getCondition() {
        return condition;
    }

    /**
     * @return The color of the car.
     */
    public String getColor() {
        return color;
    }

    /**
     * @return The capacity of the car.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return The mileage of the car.
     */
    public float getMileage() {
        return mileage;
    }

    /**
     * @return The fuel type of the car.
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * @return The transmission of the car.
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * @return The Vehicle Identification Number of the car.
     */
    public String getVin() {
        return vin;
    }

    /**
     * @return The price of the car.
     */
    public float getPrice() {
        return price;
    }

    /**
     * @return The number of available cars of this model.
     */
    public int getCarsAvailable() {
        return carsAvailable;
    }

    // Setters
    
 
    /**
     * Sets the ID of the car.
     * @param id The new ID for the car.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets the type of the car.
     * @param type The new type for the car.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the model of the car.
     * @param model The new model for the car.
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Sets the condition of the car.
     * @param condition The new condition of the car (e.g., New, Used).
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Sets the color of the car.
     * @param color The new color for the car.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Sets the seating capacity of the car.
     * @param capacity The new seating capacity for the car.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Sets the mileage of the car.
     * @param mileage The new mileage for the car.
     */
    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    /**
     * Sets the fuel type of the car.
     * @param fuelType The new fuel type for the car (e.g., Gasoline, Electric).
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * Sets the transmission type of the car.
     * @param transmission The new transmission type for the car (e.g., Automatic, Manual).
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    /**
     * Sets the Vehicle Identification Number (VIN) of the car.
     * @param vin The new VIN for the car.
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * Sets the price of the car.
     * @param price The new price for the car.
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Sets the number of cars available of this model.
     * @param carsAvailable The new number of available cars.
     */
    public void setCarsAvailable(int carsAvailable) {
        this.carsAvailable = carsAvailable;
    }
}