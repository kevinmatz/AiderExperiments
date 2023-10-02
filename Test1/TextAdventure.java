import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextAdventure {

    static class Room {
        String name;
        String description;
        Map<String, Room> directions = new HashMap<>();

        Room(String name, String description) {
            this.name = name;
            this.description = description;
        }

        void connect(String direction, Room room) {
            directions.put(direction, room);
        }

        Room navigate(String direction) {
            return directions.get(direction);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Room room1 = new Room("Room 1", "This is room 1.");
        Room room2 = new Room("Room 2", "This is room 2.");
        Room room3 = new Room("Room 3", "This is room 3.");

        room1.connect("N", room2);
        room2.connect("S", room1);
        room2.connect("E", room3);
        room3.connect("W", room2);

        Room currentRoom = room1;

        while (true) {
            System.out.println("You are in " + currentRoom.name + ". " + currentRoom.description);
            System.out.println("You can go: " + currentRoom.directions.keySet());
            System.out.println("Enter a direction or Q to quit:");

            String command = scanner.nextLine().toUpperCase();

            if (command.equals("Q")) {
                break;
            }

            Room nextRoom = currentRoom.navigate(command);

            if (nextRoom == null) {
                System.out.println("You can't go that way.");
            } else {
                currentRoom = nextRoom;
            }
        }

        System.out.println("Goodbye!");
    }

}
