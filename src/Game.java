import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Game {

    private static Boolean isPlaying = true, hasTreasure = false;
    static int playerDirection = 0;
    static int currentRoom, playerMoney = 0, roomCounter = 0;
    static boolean[] roomCount = {false, false, false, false, false, false, false, false};
    static boolean[] roomMoney = {true, true, true, true, true, true, true, true};
    //static Boolean secretRoom = false;
    static Graphic graphics = new Graphic();
    static Random rand = new Random(3);

    public static void main(String[] args) {
        int finalRoomCount = 0;
        currentRoom = 8;
        Graphic graphics = new Graphic();
        out.println(graphics.printDesign(1));

        while (isPlaying) {

            try {
                currentRoom = chooseRoom(currentRoom);
            } catch (Exception e) {
                String output = gameEnd(hasTreasure, currentRoom, playerMoney);
                out.println(output);
                isPlaying = false;
            }
        }
        finalRoomCount = roomTotal(roomCount);
        if (finalRoomCount == 1) {
            out.print("You only entered " + finalRoomCount + " room! :(");
        } else {
            out.print("You entered " + finalRoomCount + " rooms.");
        }

        out.println("\nYou finished with $" + playerMoney);
        int randomChance = rand.nextInt(4);
        if (randomChance > 2) {
            out.println("\nOh no, that ghost in the window has begun following you!\n\n..I mean the gamess still over but.. OOOOOO SPOOOOKKYYYY!");
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
                if (randomChance > 2) {
                    currentRoom = secretRoom();
                    return currentRoom;
                } else {
                    currentRoom = parlorRoom();
                    return currentRoom;
                }
            case 8:
                if (hasTreasure) {

                }
                currentRoom = outsideRoom();
                return currentRoom;
            default:
                return Integer.parseInt(null);
        }
    }

    private static String gameEnd(Boolean hasTreasure, int isOutside, int playerCash) {
        String output = graphics.printDesign(2);
        ;
        if (hasTreasure && isOutside == 8) {
            output += "Well done! You have escaped the house with the treasure and $" + playerCash + " that you found!\nThank you for playing!";
        } else if (hasTreasure && isOutside != 8) {
            output += "You found the treasure, but you have to find your way out to win the game!";
            if (playerCash > 0) {
                output += "You ended the game with $" + playerCash + "!";
            }
            output += "\nThank you for playing!";
        } else if (!hasTreasure && isOutside != 8) {
            output += "You never found the treasure :(";
            if (playerCash > 0) {
                output += "You ended the game with $" + playerCash + "!";
            }
            output += "\nThank you for playing!";
        } else if (!hasTreasure && isOutside == 8) {
            output += "Well, you didn't get lost in the house.. but you never found the treasure!";
            if (playerCash > 0) {
                output += "You get to leave with $" + playerCash + " that you found!";
            }
            output += "\nThank you for playing!";
        }
        return output;
    }

    private static int outsideRoom() {
        Scanner player = new Scanner(System.in);
        out.print("\nYou are outside an old, creepy looking house..\n" + "You thought you saw a ghost in the window upstairs.\n" + "{You can enter the house to the North by typing 'N' or press 'Q' to Quit}\n");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("n")) {
            playerDirection = 0;
        } else if (!playerChoice.equalsIgnoreCase("n")) {
            playerDirection = 8;
        }
        return playerDirection;
    }
//
//    public static void getMoney(boolean roomMoney, boolean userChoice, int randomMoney){
//        if(roomMoney){
//            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{Enter 'y' for yes, or 'n' for no}\n");
//            try {
//                playerMoney = moneyTotal()
//            }
//        }
//    }

    public static int foyerRoom() {
        roomCount[0] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.print("\nYou are in the Foyer Room.\n");
        if (roomMoney[0]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            try {
                int moneyChoice = player.nextInt();
                playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
                out.println("\nYou now have $" + playerMoney + ".");
                roomMoney[0] = false;
            } catch (Exception e) {
                out.println("Invalid entry!\n");
                playerDirection = 0;
            }
        }
        out.print("You see a dead scorpion.\n" + graphics.printDesign(3) + "\nGross..\n" + "{You can enter 'N' to exit to the North, 'S' to exit the house to the south, or press Q to Quit}\n");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("n")) {
            playerDirection = 1;
        } else if (playerChoice.equalsIgnoreCase("s")) {
            playerDirection = 8;
        } else if (!playerChoice.equalsIgnoreCase("n") || !playerChoice.equalsIgnoreCase("s")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = gameEnd(hasTreasure, currentRoom, playerMoney);
                out.println(output);
                isPlaying = false;
            }
            playerDirection = 0;
        }
        return playerDirection;
    }

    public static int frontRoom() {
        roomCount[1] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the Front Room.\n");
        if (roomMoney[1]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
            roomMoney[1] = false;
        }
        out.println("You can play Piano and enjoy here.\n" + graphics.printDesign(4) + "{You can enter 'S' to exit to the South, 'W' to exit West, 'E' to exit to East, or press Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("s")) {
            playerDirection = 0;
        } else if (playerChoice.equalsIgnoreCase("w")) {
            playerDirection = 2;
        } else if (playerChoice.equalsIgnoreCase("e")) {
            playerDirection = 3;
        } else if (!playerChoice.equalsIgnoreCase("w") && !playerChoice.equalsIgnoreCase("e") && !playerChoice.equalsIgnoreCase("s")) {
            playerDirection = 1;
        }
        return playerDirection;
    }

    public static int libraryRoom() {
        roomCount[2] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the Library.\n");
        if (roomMoney[2]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
            roomMoney[2] = false;
        }
        out.println(graphics.printDesign(5) + "\nThere are lots of spider here, Be Careful!\n" + "{You can enter 'E' to exit to the East, 'N' to exit to the North, or press Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("n")) {
            playerDirection = 4;
        } else if (playerChoice.equalsIgnoreCase("e")) {
            playerDirection = 1;
        } else if (!playerChoice.equalsIgnoreCase("n") && !playerChoice.equalsIgnoreCase("e")) {
            playerDirection = 2;
        }
        return playerDirection;
    }

    public static int kitchenRoom() {
        roomCount[3] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the Kitchen.\n");
        if (roomMoney[3]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
            roomMoney[3] = false;
        }
        out.println("There are bats in this room!\n" + graphics.printDesign(6) + "{You can enter 'W' to exit to the West, 'N' to exit to the North or press Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("w")) {
            playerDirection = 1;
        } else if (playerChoice.equalsIgnoreCase("n")) {
            playerDirection = 6;
        } else if (!playerChoice.equalsIgnoreCase("n") && !playerChoice.equalsIgnoreCase("w")) {
            playerDirection = 3;
        }
        return playerDirection;
    }

    public static int diningRoom() {
        roomCount[4] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the Dining Room.\n");
        if (roomMoney[4]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
            roomMoney[4] = false;
        }
        out.println("You can find dust and an ugly looking empty box in this room.\n" + graphics.printDesign(7) + "{You can enter 'S' to exit South or Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("s")) {
            playerDirection = 2;
        } else if (!playerChoice.equalsIgnoreCase("s")) {
            playerDirection = 4;
        }
        return playerDirection;
    }

    public static int vaultRoom() {
        roomCount[5] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the vault.\n");
        if (roomMoney[5]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
            roomMoney[5] = false;
        }
        out.println("Watch out, there are 3 walking skeletons!\n" + graphics.printDesign(8) + "{You can enter 'E' to exit East, or Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("e")) {
            playerDirection = 7;
        } else if (!playerChoice.equalsIgnoreCase("e")) {
            currentRoom = 5;
        }
        return playerDirection;
    }

    public static int parlorRoom() {
        roomCount[6] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the parlor.");
        if (roomMoney[6]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
            roomMoney[6] = false;
        }
        out.println("In the middle of the room you see a locked treasure chest.\n" + graphics.printDesign(9) + "{Enter 'W' to exit West, 'S' to exit South, or Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("w")) {
            playerDirection = 5;
        } else if (playerChoice.equalsIgnoreCase("s")) {
            playerDirection = 3;
        } else if (!playerChoice.equalsIgnoreCase("w") && playerChoice.equalsIgnoreCase("s")) {
            playerDirection = 6;
        }
        return playerDirection;
    }

    private static int secretRoom() {
        roomCount[7] = true;
        Scanner player = new Scanner(System.in);
        out.println("\nYAY, You are in the Secret room, All of the Gold in here is yours.\n" + graphics.printDesign(10) + "Now, try and find your way out ;)\n" +
                "{Enter 'W' to exit West, or Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("w")) {
            playerDirection = 5;
        } else if (!playerChoice.equalsIgnoreCase("w")) {
            playerDirection = 7;
        }
        hasTreasure = true;
        roomCount[7] = true;
        return playerDirection;
    }

    private static int roomTotal(boolean[] roomCount) {
        for (boolean aRoomCount : roomCount) {
            if (aRoomCount) {
                roomCounter++;
            }
        }
        return roomCounter;
    }

    private static int moneyTotal(int playerChoice, int playerMoney, int roomMoney) {
        int moneyTotal = 0;
        if (playerChoice == 1) {
            moneyTotal = playerMoney + roomMoney;
        } else if (playerChoice == 2) {
            moneyTotal = playerMoney;
        } else {
            moneyTotal = Integer.parseInt(null);
        }
        return moneyTotal;
    }
}