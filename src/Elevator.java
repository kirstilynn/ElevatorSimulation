import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Elevator {

    static public final int MAX_TRIPS = 100;
    static public final int DOORS_OPEN_TIME = 10;

    int currentFloor = 0;
    Direction direction = Direction.IDLE;
    boolean maintenanceMode = false;
    int totalTrips = 0;
    int totalFloorsPassed = 0;
    List<Integer> requests = new ArrayList<>();

    public Elevator() {

    }

    public void move() throws InterruptedException {
        checkCurrentRequest();
        //TODO: move up or down based on next request, or stay idle
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
                        if (newRequest < currentFloor && newRequest > requests.get(i)) {
                            requests.add(i, newRequest);
                        }
                        break;
                    case UP:
                        if (newRequest > currentFloor && newRequest < requests.get(i)) {
                            requests.add(i, newRequest);
                        } //TODO: add logic for edge cases
                        break;
                    default:
                        throw new UnsupportedOperationException("Unsupported direction: " + direction);
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

    private void checkCurrentRequest() throws InterruptedException {
        if(!requests.isEmpty() && requests.get(0).equals(currentFloor)) {
            openDoors();
            TimeUnit.SECONDS.sleep(DOORS_OPEN_TIME);
            closeDoors();
            requests.remove(0);
        }
    }

    private void checkMaintenance() {
        if (totalTrips > MAX_TRIPS) {
            maintenanceMode = true;
        }
    }
}
