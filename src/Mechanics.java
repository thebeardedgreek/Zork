import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;


public class Mechanics {

    private static Random rand = new Random();
    static int randomRoom = rand.nextInt(7);

    protected static String gameEnd(Boolean hasTreasure, int isOutside, int playerCash) {
        String output = Graphic.printDesign(2);
        int finalRoomCount;
        finalRoomCount = roomTotal(Game.roomCount);

        if (hasTreasure && isOutside == 8) {
            output += "Well done! You have escaped the house with the treasure!";
        } else if (hasTreasure && isOutside != 8) {
            output += "You found the treasure, but you have to find your way out to win the game!";
        } else if (!hasTreasure && isOutside != 8) {
            output += "You never found the treasure :(\n";
        } else if (!hasTreasure && isOutside == 8) {
            output += "Well, you didn't get lost in the house.. but you never found the treasure!";
        }

        if (finalRoomCount == 1) {
            output += "You only entered " + finalRoomCount + " room! :(";
        } else {
            output += "You entered " + finalRoomCount + " rooms.";
        }

        output += "\nYou finished with $" + Game.playerMoney;
        int randomChance = rand.nextInt(4);
        if (randomChance > 2) {
            output += "\nOh no, that ghost in the window has begun following you!\n\n..I mean the gamess still over but.. OOOOOO SPOOOOKKYYYY!";
        }
        return output;
    }

    protected static int moneyTotal(int playerChoice, int playerMoney, int roomMoney) {
        int moneyTotal;
        if (playerChoice == 1) {
            moneyTotal = Game.playerMoney + roomMoney;
        } else if (playerChoice == 2) {
            moneyTotal = Game.playerMoney;
        } else {
            moneyTotal = Integer.parseInt(null);
        }
        return moneyTotal;
    }

    protected static int roomTotal(boolean[] roomCount) {
        for (boolean aRoomCount : Game.roomCount) {
            if (aRoomCount) {
                Game.roomCounter++;
            }
        }
        return Game.roomCounter;
    }

    protected static void banditSteve(int currentRoom)  {
        if (currentRoom == randomRoom){
            Game.playerMoney = 0;
            out.println(Graphic.printDesign(11) + "Oh no, it's Steve the Bandit!\n\nSteve takes all your cash :(\n\n" +
                    "You're back to $" + Game.playerMoney + ".\nPress any button to continue.\n");
            Game.roomMoney[currentRoom] = false;
            randomRoom = 444;
            Scanner player = new Scanner(System.in);
            String buffer = player.nextLine();
        }
    }
}
