public class Main {

    public static void main(String[] args) {

        ElevatorController controller = new ElevatorController(10, 1);
        controller.requestFloor(7);
        controller.requestFloor(5);
        controller.requestFloor(2);

    }
}