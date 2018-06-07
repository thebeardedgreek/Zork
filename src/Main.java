import java.util.Random;
import java.util.Scanner;

public class Main {

    static Boolean isPlaying = true;
    static int playerDirection = 0;
    static int currentRoom;

    public static void main(String[] args) {
        Scanner player = new Scanner(System.in);
        String[] roomList = {"Foyer", "Front Room", "Library", "Kitchen", "Dining Room", "Vault","Parlor","Secret Room"};
        Random rand = new Random();
        int value = rand.nextInt(9);
        System.out.println("Zork Introduction HERE");

        //while is playing
        while (isPlaying){
            chooseRoom(currentRoom);
        }
    }

    public static void chooseRoom(int currentRoom){
        if (currentRoom == 0){
            foyerRoom();
            System.out.println(currentRoom + " " + playerDirection);
            if (playerDirection == 1){
                currentRoom = 2;
                System.out.println(currentRoom + " " + playerDirection);
            }
        } else if (currentRoom == 1){
            frontRoom();
        } else if (currentRoom == 2){
            libraryRoom();
        } else if (currentRoom == 3){
            kitchenRoom();
        } else if (currentRoom == 4){
            diningRoom();
        } else if (currentRoom == 5){
            vaultRoom();
        } else if (currentRoom == 6){
            parlorRoom();
        } else if (currentRoom == 7){
            secretRoom();
        } 
    }
    
    public static int foyerRoom() {
        Scanner player = new Scanner(System.in);
        System.out.print("You are in the Foyer Room.\n"+ "You see a dead scorpion.\nGross..\n" + "{You can enter 1 to exit to the north or press Q to quit.}\n");
        int playerDirection = player.nextInt();
        return playerDirection;
    }
    
    public static void frontRoom() {
        Scanner player = new Scanner(System.in);
        System.out.println("Ok, now you are in the Front Room.\n" + "You can play Piano and enjoy here.\n" +
                "{You can enter 1 to exit to the south, 2 to exit west, 3 to exit to east  or press Q to quit.}");
        int playerDirection = player.nextInt();
    }

    public static void libraryRoom() {
        Scanner player = new Scanner(System.in);
        System.out.println("Ok, now you are in the Library.\n" + "There are lots of spider here, Be Careful!\n" +
                "{You can enter 1 to exit to the east, 2 to exit to the north or press Q to quit}");
        int playerDirection = player.nextInt();
    }

    public static void kitchenRoom() {
        Scanner player = new Scanner(System.in);
        System.out.println("Ok, now you are in the Kitchen.\n"+ "There are bats in this room!\n" +
                "{You can enter 1 to exit to the west, 2 to exit to the north or press Q to quit}");
        int playerDirection = player.nextInt();
    }

    public static void diningRoom() {
        Scanner player = new Scanner(System.in);
        System.out.println("Ok, now you are in the Dining Room.\n" + "You can find dust and an empty box in this room.\n" +
                "{You can enter 1 to exit south or Q to Quit.}");
        int playerDirection = player.nextInt();
    }

    public static void vaultRoom() {
        Scanner player = new Scanner(System.in);
        System.out.println("watch out , There are 3 walking skeletons\n You can enter 1 to exit East or Q to Quit");
        int playerDirection = player.nextInt();
    }

    public static void parlorRoom() {
        Scanner player = new Scanner(System.in);
        System.out.println("You are in the parlor, This is the place for treasure chest.\n  enter 1 to exit west , 2 to exit South or Q to Quit");
        int playerDirection = player.nextInt();
    }

    private static void secretRoom() {
        Scanner player = new Scanner(System.in);
        System.out.println("YAY, You are in the Secret room, All of the Gold in here is yours" );
        int playerDirection = player.nextInt();
    }
}
