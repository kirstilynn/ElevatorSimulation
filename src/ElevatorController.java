import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    int minFloor = 1;
    int maxFloor;
    int totalFloors;
    List<Elevator> elevators;

    public ElevatorController(int maxFloor, int totalElevators) {
        this.maxFloor = maxFloor;
        this.elevators = new ArrayList<>(totalElevators);
        for (int i = 0; i < totalElevators; i++) {
            elevators.add(new Elevator());
        }
    }

    public void requestFloor(int floor) {
        System.out.println(floor +" floor requested");
    }
}
