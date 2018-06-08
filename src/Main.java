import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    private static Boolean isPlaying = true, hasTreasure = false;
    static int playerDirection = 0;
    static int currentRoom, playerMoney = 0, roomCounter = 1;
    static boolean[] roomCount = {false, false, false, false, false, false, false, false};
    static boolean[] roomMoney = {true, true, true, true, true, true, true, true};
    static Boolean secretRoom = false;
    static Random rand = new Random(3);

    public static void main(String[] args) {
        Scanner player = new Scanner(System.in);
        int finalRoomCount = 0;
        currentRoom = 8;
        out.println("WELCOME TO... \n\n" +
                "ZZZZZZZZZZZZZZZZZZZ                                    kkkkkkkk           \n" +
                "Z:::::::::::::::::Z                                    k::::::k           \n" +
                "Z:::::::::::::::::Z                                    k::::::k           \n" +
                "Z:::ZZZZZZZZ:::::Z                                     k::::::k           \n" +
                "ZZZZZ     Z:::::Z     ooooooooooo   rrrrr   rrrrrrrrr   k:::::k    kkkkkkk\n" +
                "        Z:::::Z     oo:::::::::::oo r::::rrr:::::::::r  k:::::k   k:::::k \n" +
                "       Z:::::Z     o:::::::::::::::or:::::::::::::::::r k:::::k  k:::::k  \n" +
                "      Z:::::Z      o:::::ooooo:::::orr::::::rrrrr::::::rk:::::k k:::::k   \n" +
                "     Z:::::Z       o::::o     o::::o r:::::r     r:::::rk::::::k:::::k    \n" +
                "    Z:::::Z        o::::o     o::::o r:::::r     rrrrrrrk:::::::::::k     \n" +
                "   Z:::::Z         o::::o     o::::o r:::::r            k:::::::::::k     \n" +
                "ZZZ:::::Z     ZZZZZo::::o     o::::o r:::::r            k::::::k:::::k    \n" +
                "Z::::::ZZZZZZZZ:::Zo:::::ooooo:::::o r:::::r           k::::::k k:::::k   \n" +
                "Z:::::::::::::::::Zo:::::::::::::::o r:::::r           k::::::k  k:::::k  \n" +
                "Z:::::::::::::::::Z oo:::::::::::oo  r:::::r           k::::::k   k:::::k \n" +
                "ZZZZZZZZZZZZZZZZZZZ   ooooooooooo    rrrrrrr           kkkkkkkk    kkkkkkk\n" +
                "                                                                         ");
        //while is playing
        while (isPlaying){

            try {
                currentRoom = chooseRoom(currentRoom);
            }
            catch (Exception e){
                if(hasTreasure){
                    out.println("You found the treasure, but you have to find your way out to win the game!\nThank you for playing!");
                    isPlaying = false;
                } else {
                    out.println("Thank you for playing!");
                    isPlaying = false;
                }
            }
        }
        finalRoomCount = roomTotal(roomCount);
        if (finalRoomCount == 1){
            System.out.print("You only entered " + finalRoomCount + " room! :(");
        } else {
            System.out.print("You entered " + finalRoomCount + " rooms.");
        }

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
                int randomChance = rand.nextInt(4);
                if (randomChance > 2){
                    currentRoom = secretRoom();
                    return currentRoom;
                } else {
                    currentRoom = parlorRoom();
                    return currentRoom;
                }
            case 8:
                currentRoom = outsideRoom();
                return currentRoom;
            default:
                return Integer.parseInt(null);
        }
    }

    private static int outsideRoom() {
        Scanner player = new Scanner(System.in);
        out.print("You are outside an old, creepy looking house..\n"+ "You thought you saw a ghost in the window upstairs.\n" + "{You can enter 1 to enter the house to the north or press Q to Quit}\n");
        int playerDirection = player.nextInt();
        if (playerDirection == 1){
            playerDirection = 0;
        } else if(playerDirection != 1){
            playerDirection = 8;
        }
        return playerDirection;
    }

    public static int foyerRoom() {
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.print("You are in the Foyer Room.\n");
            if (roomMoney[0]){
                out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
                int moneyChoice = player.nextInt();
                playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
                out.println("You now have $" + playerMoney + ".");
                roomMoney[0] = false;
            }
        out.print("You see a dead scorpion.\nGross..\n" + "{You can enter 1 to exit to the north, 2 to exit the house to the south, or press Q to Quit}\n");
        int playerDirection = player.nextInt();
        roomCount[0] = true;
        if (playerDirection == 2){
            playerDirection = 8;
        }
        else if (playerDirection != 1){
            playerDirection = 0;
        }
        return playerDirection;
    }

    public static int frontRoom() {
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("Ok, now you are in the Front Room.\n" + "You can play Piano and enjoy here.\n");
        if (roomMoney[1]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("You now have $" + playerMoney + ".");
            roomMoney[1] = false;
        }
        out.println("{You can enter 1 to exit to the South, 2 to exit West, 3 to exit to East, or press Q to Quit}");
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
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("Ok, now you are in the Library.\n" + "There are lots of spider here, Be Careful!\n");
        if (roomMoney[2]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("You now have $" + playerMoney + ".");
            roomMoney[2] = false;
        }
        out.println("{You can enter 1 to exit to the East, 2 to exit to the north or press Q to Quit}");
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
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("Ok, now you are in the Kitchen.\n"+ "There are bats in this room!\n");
        if (roomMoney[3]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("You now have $" + playerMoney + ".");
            roomMoney[3] = false;
        }
        out.println("{You can enter 1 to exit to the West, 2 to exit to the north or press Q to Quit}");
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
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("Ok, now you are in the Dining Room.\n" + "You can find dust and an empty box in this room.\n");
        if (roomMoney[4]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("You now have $" + playerMoney + ".");
            roomMoney[4] = false;
        }
        out.println("{You can enter 1 to exit South or Q to Quit}");
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
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("Ok, now you are in the vault.\nWatch out, there are 3 walking skeletons!\n");
        if (roomMoney[5]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("You now have $" + playerMoney + ".");
            roomMoney[5] = false;
        }
        out.println("{You can enter 1 to exit East, or Q to Quit}");
        int playerDirection = player.nextInt();
        roomCount[5] = true;
        if (playerDirection == 1){
            playerDirection = 7;
        } else if(playerDirection != 1){
            currentRoom = 5;
        }
        return playerDirection;
    }

    public static int parlorRoom() {
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("You are in the parlor, this is the place for treasure chest.\n");
        if (roomMoney[6]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("You now have $" + playerMoney + ".");
            roomMoney[6] = false;
        }
        out.println("{Enter 1 to exit West, 2 to exit South, or Q to Quit}");
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
        out.println("YAY, You are in the Secret room, All of the Gold in here is yours.\nNow, try and find your way out ;)\n" +
                "{Enter 1 to exit West, or Q to Quit}" );
        int playerDirection = player.nextInt();
        if (playerDirection == 1){
            playerDirection = 5;
        }
        hasTreasure = true;
        roomCount[7] = true;
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

   private static int moneyTotal(int playerChoice, int playerMoney, int roomMoney){
        int moneyTotal = 0;
        if (playerChoice == 1){
            moneyTotal = playerMoney + roomMoney;
        } else if(playerChoice == 2){
            moneyTotal = playerMoney;
        }
        return moneyTotal;
   }
}