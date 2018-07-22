import java.util.ArrayList;
import java.util.List;

public class Elevator {

    static public final int MAX_TRIPS = 100;

    int currentFloor = 0;
    int direction = 0; //up -1, idle = 0, up = 1
    boolean maintenanceMode = false;
    int totalTrips = 0;
    int totalFloorsPassed = 0;
    List<Integer> requests = new ArrayList<>();

    public Elevator() {

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

    public int getDirection() {
        return direction;
    }

    public void addRequest(int request) {
        if(currentFloor )
        requests.add(request);
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
