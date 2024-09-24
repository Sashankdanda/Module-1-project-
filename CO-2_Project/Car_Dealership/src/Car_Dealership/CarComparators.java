package Car_Dealership;

import java.util.Comparator;

public class CarComparators {
    public static Comparator<Car> compareByMake() {
        return Comparator.comparing(Car::getMake);
    }

    public static Comparator<Car> compareByModel() {
        return Comparator.comparing(Car::getModel);
    }

    public static Comparator<Car> compareByYear() {
        return Comparator.comparingInt(Car::getYear);
    }

    public static Comparator<Car> compareByPrice() {
        return Comparator.comparingDouble(Car::getPrice);
    }
}
