package Car_Dealership;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        CarInventory inventory = new CarInventory();

        inventory.addCar(new Car("Toyota", "Camry", 2020, 24000));
        inventory.addCar(new Car("Honda", "Accord", 2019, 22000));
        inventory.addCar(new Car("Ford", "Mustang", 2021, 26000));
        inventory.addCar(new Car("Chevrolet", "Malibu", 2018, 20000));

        System.out.println("Original Inventory:");
        for (Car car : inventory) {
            System.out.println(car);
        }

        Collections.sort(inventory.getCars());
        System.out.println("\nInventory sorted by price:");
        for (Car car : inventory) {
            System.out.println(car);
        }

        Collections.sort(inventory.getCars(), CarComparators.compareByMake());
        System.out.println("\nInventory sorted by make:");
        for (Car car : inventory) {
            System.out.println(car);
        }

        Collections.sort(inventory.getCars(), CarComparators.compareByYear());
        System.out.println("\nInventory sorted by year:");
        for (Car car : inventory) {
            System.out.println(car);
        }
    }
}

