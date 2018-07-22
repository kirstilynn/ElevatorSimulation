public class Main {

    public static void main(String[] args) {

        ElevatorController controller = new ElevatorController(10, 1);
        controller.requestFloor(1,7);
        controller.requestFloor(2,3);

    }
}