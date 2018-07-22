import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    int minFloor = 1;
    int maxFloor;
    List<Elevator> elevators;

    public ElevatorController(int maxFloor, int totalElevators) {
        this.maxFloor = maxFloor;
        this.elevators = new ArrayList<>(totalElevators);
        for (int i = 0; i < totalElevators; i++) {
            elevators.add(new Elevator());
        }
    }

    public void requestFloor(int toFloor, int fromFloor) {
        if (toFloor > maxFloor || toFloor < minFloor) {
            throw new IndexOutOfBoundsException("Unable to request floor " + toFloor);
        }
        System.out.println(toFloor +" floor requested");
        for (Elevator elevator : elevators) {
            if (elevator.getCurrentFloor() == toFloor) {
                elevator.addRequest(toFloor);
            }
        }

    }
}
