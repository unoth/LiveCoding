import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // task1 создать лист интов, заполнить данными и удалить чётные элементы
        List<Integer> list = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
        for (int i = 0; i <= list.size(); i++) {
            list.removeIf(integer -> integer % 2 == 0);
        }
        System.out.println("task1: " + list);


        // task2 есть класс машина и лодка, нужно из них сделать амфибию (класс, который ведёт себя как оба эти класса)
        // множественное наследование

        Car car = new Car();
        Boat boat = new Boat();
        Amphibious amphibious = new Amphibious();
        drive(car);
        flow(boat);
        drive(amphibious);
        flow(amphibious);
    }

    static void drive(Car car) {
        car.drive();
    }

    static void flow(Boat boat) {
        boat.flow();
    }

    static void flow(Amphibious amphibious) {
        amphibious.flow();
    }

    static void drive(Amphibious amphibious) {
        amphibious.drive();
    }

    static class Car implements CarI {
    }

    static class Boat implements BoatI {
    }

    interface CarI {
        default void drive() {
            System.out.println("Many code: car drive");
        }
    }

    interface BoatI {
        default void flow() {
            System.out.println("Many code: boat flow");
        }
    }

    static class Amphibious implements CarI, BoatI {

        @Override
        public void flow() {
            System.out.println("Many code: amphibious flow");
        }

        @Override
        public void drive() {
            System.out.println("Many code: amphibious drive");
        }
    }
}

