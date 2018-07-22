public class Elevator {

    int currentFloor = 0;
    int direction = 0; //up -1, idle = 0, up = 1
    boolean maintenanceMode = false;
    int totalTrips = 0;
    int totalFloorsPassed = 0;

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
}
