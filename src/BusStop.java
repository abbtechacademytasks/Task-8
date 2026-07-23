import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class BusStop {
    private final String name;
    private static final int MAX_BUS_STOP_CAPACITY = 10;
    private final Queue<Passenger> regularPassengers = new LinkedList<>();
    private final Queue<Passenger> priorityPassengers = new LinkedList<>();

    public BusStop(String name) {
        this.name = name;
    }

    void addPassenger(Passenger passenger) {
        if (passenger == null) {
            return;
        }

        if (isBusStopFull()) {
            return;
        }

        if (passenger.isPriority()) {
            priorityPassengers.offer(passenger);
        } else {
            regularPassengers.offer(passenger);
        }
    }

    Passenger pollNextPassenger() {
        if (priorityPassengers.isEmpty()) {
            return regularPassengers.poll();
        } else  {
            return priorityPassengers.poll();
        }
    }

    boolean isBusStopFull() {
        return regularPassengers.size() + priorityPassengers.size() >= MAX_BUS_STOP_CAPACITY;
    }

    boolean isBusStopEmpty() {
        return regularPassengers.isEmpty() && priorityPassengers.isEmpty();
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[" + name + "] ");
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");

        if (isBusStopEmpty()) {
            stringBuilder.append("is empty");
        }

        for (Passenger passenger : priorityPassengers) {
            stringJoiner.add(passenger.toString());
        }

        for (Passenger passenger : regularPassengers) {
            stringJoiner.add(passenger.toString());
        }

        return stringBuilder.append(stringJoiner).toString();
    }
}
