import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    private static Boolean isPlaying = true;
    static int playerDirection = 0;
    static int currentRoom, roomCounter = 1;
    static boolean[] roomCount = {false, false, false, false, false, false, false, false};
    static Boolean skellys = false;
    static Random rand = new Random(3);

    public static void main(String[] args) {
        Scanner player = new Scanner(System.in);
        int finalRoomCount = 0;
        out.println("Zork Introduction HERE");
        //while is playing
        while (isPlaying){

            if (currentRoom > 7){
                out.println("Thank you for playing!");
                isPlaying = false;
            }
            try {
                currentRoom = chooseRoom(currentRoom);
            }
            catch (Exception e){
                out.println("Thank you for playing!");
                isPlaying = false;
            }
        }
        finalRoomCount = roomTotal(roomCount);
        System.out.print("You entered " + finalRoomCount + " rooms.");

    }

    public static int chooseRoom(int currentRoom) {
        switch (currentRoom) {
            case 0:
                currentRoom = foyerRoom();
                return currentRoom;
            case 1:
                currentRoom = frontRoom();
                return currentRoom;
            case 2:
                currentRoom = libraryRoom();
                return currentRoom;
            case 3:
                currentRoom = kitchenRoom();
                return currentRoom;
            case 4:
                currentRoom = diningRoom();
                return currentRoom;
            case 5:
                currentRoom = vaultRoom();
                return currentRoom;
            case 6:
                currentRoom = parlorRoom();
                return currentRoom;
            case 7:
                currentRoom = secretRoom();
                return currentRoom;
            default:
                return Integer.parseInt(null);
        }
    }

    public static int foyerRoom() {
        Scanner player = new Scanner(System.in);
        out.print("You are in the Foyer Room.\n"+ "You see a dead scorpion.\nGross..\n" + "{You can enter 1 to exit to the north or press Q to Quit}\n");
        int playerDirection = player.nextInt();
        roomCount[0] = true;
        if (playerDirection != 1){
            playerDirection = 0;
        }
        return playerDirection;
    }

    public static int frontRoom() {
        Scanner player = new Scanner(System.in);
        out.println("Ok, now you are in the Front Room.\n" + "You can play Piano and enjoy here.\n" +
                "{You can enter 1 to exit to the South, 2 to exit West, 3 to exit to East, or press Q to Quit}");
        int playerDirection = player.nextInt();
        roomCount[1] = true;
        if (playerDirection == 1){
            playerDirection = 0;
        } else if (playerDirection != 2 && playerDirection != 3){
            playerDirection = 1;
        }
        return playerDirection;
    }

    public static int libraryRoom() {
        Scanner player = new Scanner(System.in);
        out.println("Ok, now you are in the Library.\n" + "There are lots of spider here, Be Careful!\n" +
                "{You can enter 1 to exit to the East, 2 to exit to the north or press Q to Quit}");
        int playerDirection = player.nextInt();
        roomCount[2] = true;
        if (playerDirection == 2){
            playerDirection = 4;
        } else if (playerDirection != 1){
            playerDirection = 2;
        }
        return playerDirection;
    }

    public static int kitchenRoom() {
        Scanner player = new Scanner(System.in);
        out.println("Ok, now you are in the Kitchen.\n"+ "There are bats in this room!\n" +
                "{You can enter 1 to exit to the West, 2 to exit to the north or press Q to Quit}");
        int playerDirection = player.nextInt();
        roomCount[3] = true;
        if (playerDirection == 2){
            playerDirection = 6;
        } else if(playerDirection != 1){
            playerDirection = 3;
        }
        return playerDirection;
    }

    public static int diningRoom() {
        Scanner player = new Scanner(System.in);
        out.println("Ok, now you are in the Dining Room.\n" + "You can find dust and an empty box in this room.\n" +
                "{You can enter 1 to exit South or Q to Quit}");
        int playerDirection = player.nextInt();
        roomCount[4] = true;
        if (playerDirection == 1){
            playerDirection = 2;
        } else if (playerDirection != 1){
            playerDirection = 4;
        }
        return playerDirection;
    }

    public static int vaultRoom() {
        Scanner player = new Scanner(System.in);
        int randomChance = rand.nextInt(4);
        System.out.println(randomChance);
        if (randomChance > 2){
            out.println("Watch out, there are 3 walking skeletons!\n{You can enter 1 to exit East, or Q to Quit}");
            skellys = true;
        } else {
            out.println("Welcome to the vault! No skeletons today :)\n{You can enter 1 to exit East, or Q to Quit}");
        }
        int playerDirection = player.nextInt();
        roomCount[5] = true;
        if (playerDirection == 1){
            playerDirection = 6;
            //deal with skellys
        } else if(playerDirection != 1){
            currentRoom = 5;
        }
        return playerDirection;
    }

    public static int parlorRoom() {
        Scanner player = new Scanner(System.in);
        out.println("You are in the parlor, this is the place for treasure chest.\n{Enter 1 to exit West, 2 to exit South, or Q to Quit}");
        int playerDirection = player.nextInt();
        roomCount[6] = true;
        if (playerDirection == 1){
            playerDirection = 5;
        } else if (playerDirection == 2){
            playerDirection = 3;
        } else if(playerDirection != 1 && playerDirection != 2){
            playerDirection = 6;
        }
        return playerDirection;
    }

    private static int secretRoom() {
        Scanner player = new Scanner(System.in);
        out.println("YAY, You are in the Secret room, All of the Gold in here is yours" );
        int playerDirection = player.nextInt();
        roomCount[7] = true;
        isPlaying = false;
        return playerDirection;
   }

   private static int roomTotal(boolean[] roomCount){
       for (boolean aRoomCount : roomCount) {
           if (aRoomCount) {
               roomCounter++;
           }
       }
        return roomCounter;
   }
}