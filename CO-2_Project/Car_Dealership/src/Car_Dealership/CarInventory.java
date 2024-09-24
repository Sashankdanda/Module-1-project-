package Car_Dealership;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarInventory implements Iterable<Car> {
    private List<Car> cars;

    public CarInventory() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}

