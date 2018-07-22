import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    static public final int MAX_TRIPS = 100;

    int currentFloor = 0;
    Direction direction = Direction.IDLE;
    boolean maintenanceMode = false;
    int totalTrips = 0;
    int totalFloorsPassed = 0;
    List<Integer> requests = new ArrayList<>();

    public Elevator() {

    }

    public void move() {
        //TODO: move up or down based on next request, or stay idle?
    }

    public void moveUp() {
        System.out.println("Moving Down");
        currentFloor++;
        totalFloorsPassed++;
    }

    public void moveDown() {
        System.out.println("Moving Down");
        currentFloor--;
        totalFloorsPassed++;
    }

    public void openDoors() {
        System.out.println("Opening Door on floor" + currentFloor);
    }

    public void closeDoors() {
        System.out.println("Closing Door on floor" + currentFloor);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void addRequest(int newRequest) {
        if (requests.isEmpty()) {
            requests.add(newRequest);
        } else if (!requests.contains(newRequest)) {
            for (int i = 0; i < requests.size(); i++) {
                switch (direction) {
                    case DOWN:
                        break;
                    case UP:
                        if (newRequest > currentFloor && newRequest < requests.get(i)) {
                            requests.add(i, newRequest);
                        } else if ()
                        break;
                    default:
                        throw new RuntimeException("Unsupported direction: " + direction);
                }
            }
        }
    }

    public boolean isMaintenanceMode() {
        return maintenanceMode;
    }

    public void service() {
        maintenanceMode = false;
    }

    private void checkMaintenance() {
        if (totalTrips > MAX_TRIPS) {
            maintenanceMode = true;
        }
    }
}
