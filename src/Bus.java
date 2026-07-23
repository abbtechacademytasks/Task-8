import java.util.ArrayList;
import java.util.List;

public class Bus {
    private static final int BUS_CAPACITY = 5;
    private final List<Passenger> passengers = new ArrayList<>();

    boolean addPassenger(Passenger passenger) {
        if (passenger == null) {
            return false;
        }

        if (passengers.contains(passenger)) {
            return false;
        }

        if (isBusFull()) {
            return false;
        }

        passengers.add(passenger);
        return true;
    }

    boolean removePassenger(Passenger passenger) {
        return passengers.remove(passenger);
    }

    List<Passenger> getPassengersCopy() {
        return new ArrayList<>(passengers);
    }

    boolean isBusFull() {
        return passengers.size() >= BUS_CAPACITY;
    }

    @Override
    public String toString() {
        return passengers.toString();
    }
}
