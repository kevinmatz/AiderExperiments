import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextAdventure {

    static class Room {
        String name;
        String description;
        List<Item> items = new ArrayList<>();
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

        void addItem(Item item) {
            items.add(item);
        }

        void removeItem(Item item) {
            items.remove(item);
        }

        boolean containsItem(String itemName) {
            for (Item item : items) {
                if (item.name.equals(itemName)) {
                    return true;
                }
            }
            return false;
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

        Inventory inventory = new Inventory();

        Room currentRoom = room1;

        while (true) {
            System.out.println("You are in " + currentRoom.name + ". " + currentRoom.description);
            System.out.println("Items in the room: " + currentRoom.items);
            System.out.println("Items in your inventory: " + inventory.items);
            System.out.println("You can go: " + currentRoom.directions.keySet());
            System.out.println("Enter a direction, GET <item>, DROP <item>, or Q to quit:");

            String command = scanner.nextLine().toUpperCase();

            if (command.equals("Q")) {
                break;
            } else if (command.startsWith("GET ")) {
                String itemName = command.substring(4);
                if (currentRoom.containsItem(itemName)) {
                    Item item = new Item(itemName);
                    currentRoom.removeItem(item);
                    inventory.add(item);
                } else {
                    System.out.println("That item is not in this room.");
                }
            } else if (command.startsWith("DROP ")) {
                String itemName = command.substring(5);
                Item item = new Item(itemName);
                if (inventory.items.contains(item)) {
                    inventory.remove(item);
                    currentRoom.addItem(item);
                } else {
                    System.out.println("You don't have that item.");
                }
            } else {
                Room nextRoom = currentRoom.navigate(command);

                if (nextRoom == null) {
                    System.out.println("You can't go that way.");
                } else {
                    currentRoom = nextRoom;
                }
            }
        }

        System.out.println("Goodbye!");
    }

}
    static class Item {
        String name;

        Item(String name) {
            this.name = name;
        }
    }

    static class Inventory {
        List<Item> items = new ArrayList<>();
        static final int MAX_ITEMS = 10;

        void add(Item item) {
            if (items.size() < MAX_ITEMS) {
                items.add(item);
            } else {
                System.out.println("Your inventory is full.");
            }
        }

        void remove(Item item) {
            items.remove(item);
        }

        boolean isFull() {
            return items.size() >= MAX_ITEMS;
        }
    }
