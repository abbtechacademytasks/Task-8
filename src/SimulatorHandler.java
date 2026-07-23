import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulatorHandler {
    private static final int EXITED_PASSENGERS_MIN_COUNT = 1;
    private static final int EXITED_PASSENGERS_MAX_COUNT = 2;
    private final Random rand = new Random();
    private static final List<String> NAMES =
            List.of(
                    "Alice",
                    "Bob",
                    "Carol",
                    "Daniel",
                    "Eve",
                    "Mark",
                    "Rasim",
                    "Ruslan",
                    "Sara",
                    "Veli", // 10
                    "Eli",
                    "Don",
                    "Emin",
                    "Gulnar",
                    "Adil",
                    "Fazil",
                    "Fariz",
                    "Ismayil",
                    "Islam",
                    "Perviz", // 20
                    "Qudret",
                    "Sirvan",
                    "Pervane",
                    "Jack",
                    "Vadim",
                    "Andrey",
                    "Aleksey",
                    "Medina",
                    "Leo",
                    "Cristiano", // 30
                    "Lamine",
                    "Tural",
                    "Turan",
                    "Pasha",
                    "Vaqif"
            );

    private final List<String> availableNames = new ArrayList<>(NAMES);

    void runSimulation() {
        Bus bus = generateBus();
        System.out.println("Simulation started.");

        BusStop stop1 = generateBusStop("Stop 1");
        BusStop stop2 = generateBusStop("Stop 2");
        BusStop stop3 = generateBusStop("Stop 3");

        simulateBusStop(bus, stop1);
        simulateBusStop(bus, stop2);
        simulateBusStop(bus, stop3);

        System.out.println("Simulation finished.");
        showFinalBusState(bus);
        showCurrentBusStopState(stop1);
        showCurrentBusStopState(stop2);
        showCurrentBusStopState(stop3);
    }

    void simulateBusStop(Bus bus, BusStop busStop) {
        int exitedPassengerCount = rand.nextInt(EXITED_PASSENGERS_MIN_COUNT, EXITED_PASSENGERS_MAX_COUNT + 1);

        showCurrentBusStopReachedMessage(busStop);

        for (int i = 0; i < exitedPassengerCount; i++) {
            if (bus.isBusEmpty()) break;
            List<Passenger> passengers = bus.getPassengers();
            Passenger passenger = passengers.get(rand.nextInt(passengers.size()));
            boolean result = bus.removePassenger(passenger);

            if (result) {
                System.out.println(passenger + " left the bus");
            } else {
                System.out.println(passenger + " something went wrong when trying to leave the bus");
            }
        }

        while (!bus.isBusFull() && !busStop.isBusStopEmpty()) {
            Passenger passenger = busStop.pollNextPassenger();
            boolean result = bus.addPassenger(passenger);

            if (result) {
                System.out.println(passenger + " boarded the bus.");
            } else {
                System.out.println(passenger + " something went wrong when trying to enter the bus");
            }
        }

        showCurrentBusState(bus);
        showCurrentBusStopState(busStop);
    }

    void showCurrentBusStopReachedMessage(BusStop busStop) {
        System.out.println(busStop.getName() + " reached.");
    }

    void showCurrentBusStopState(BusStop busStop) {
        System.out.println(busStop);
    }

    void showCurrentBusState(Bus bus) {
        System.out.println("Bus now: " + bus);
    }

    void showFinalBusState(Bus bus) {
        System.out.println("Final passengers in bus: " + bus);
    }

    Bus generateBus() {
        return new Bus();
    }

    BusStop generateBusStop(String name) {
        BusStop busStop = new BusStop(name);
        int passengerCount = rand.nextInt(3, 6);


        for (int i = 0; i < passengerCount; i++) {
            busStop.addPassenger(generateRandomPassenger());
        }

        return busStop;
    }

    Passenger generateRandomPassenger() {
        if (availableNames.isEmpty()) {
            return null;
        }

        int randomIndex = rand.nextInt(availableNames.size());
        String randomName = availableNames.remove(randomIndex);
        boolean isPriority = rand.nextBoolean();

        return new Passenger(randomName, isPriority);
    }
}
