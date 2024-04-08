import java.util.ArrayList;
import java.util.List;

/**
 * Provides functionality to load car information from a CSV file and
 * create corresponding Car objects.
 */
public class loadAllCars {
	
	
    /**
     * Static variable to hold the header from the user CSV file. This header is used
     * to used when updating the CSV file to append. 
     */
	public static String[] header;

    /**
     * Reads car data from a CSV file and initializes a list of Car objects
     * based on the data. This method dynamically creates instances of Car and
     * its subclasses (e.g., Sedan, SUV, Hatchback, Pickup) based on the type
     * specified in the CSV file.
     * <p>
     * The first row of the CSV is expected to be a header row and is skipped.
     * Each row after the header is used to instantiate a Car object or one of its
     * subclasses with the values from the row. Specific car attributes like trunk space
     * for Sedans, four-wheel drive capability for SUVs, foldable seats for Hatchbacks,
     * and towing capacity for Pickups are set with the default value true. 
     *
     * @return A list of Car objects (including subclasses of Car) initialized with the data read from the CSV.
     */
    public static List<Car> loadCarsFromCSV() {
        boolean isFirstRow = true; 
        List<String[]> carData = CSVManager.readFromCSV("car_data.csv");
        List<Car> cars = new ArrayList<>();

        for (String[] carInfo : carData) {
            if (isFirstRow) {
                isFirstRow = false;
                header = carInfo;
                continue;
            }
            try {
                int id = Integer.parseInt(carInfo[0]);
                String type = carInfo[1];
                String model = carInfo[2];
                String condition = carInfo[3];
                String color = carInfo[4];
                int capacity = Integer.parseInt(carInfo[5]);
                float mileage = Float.parseFloat(carInfo[6]);
                String fuelType = carInfo[7];
                String transmission = carInfo[8];
                String vin = carInfo[9];
                float price = Float.parseFloat(carInfo[10]);
                int carsAvailable = Integer.parseInt(carInfo[11]);

                Car car;
                switch (type) {
                    case "Sedan":
                        car = new Sedan(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable, 10.0f);
                        break;
                    case "SUV":
                        car = new SUV(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable, true);
                        break;
                    case "Hatchback":
                        car = new Hatchback(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable, true);
                        break;
                    case "Pickup":
                        car = new Pickup(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable, 5000.0f);
                        break;
                    default:
                        car = new Car(id, type, model, condition, color, capacity, mileage, fuelType, transmission, vin, price, carsAvailable);
                        break;
                }
                cars.add(car);
            } catch (NumberFormatException e) {
                System.out.println("Error parsing car data: " + e.getMessage());
            }
        }

        return cars;
    }
}