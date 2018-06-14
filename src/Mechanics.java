import java.util.Random;

import static java.lang.System.out;


public class Mechanics {

    protected static String gameEnd(Boolean hasTreasure, int isOutside, int playerCash) {
        String output = Graphic.printDesign(2);

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
            output += "\nThank you for playing!\n\n";
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

    protected static void displayGameEnd(){
        int finalRoomCount;
        finalRoomCount = roomTotal(Game.roomCount);
        if (finalRoomCount == 1) {
            out.print("You only entered " + finalRoomCount + " room! :(");
        } else {
            out.print("You entered " + finalRoomCount + " rooms.");
        }

        out.println("\nYou finished with $" + Game.playerMoney);
        int randomChance = rand.nextInt(4);
        if (randomChance > 2) {
            out.println("\nOh no, that ghost in the window has begun following you!\n\n..I mean the gamess still over but.. OOOOOO SPOOOOKKYYYY!");
        }
    }

    protected static Random rand = new Random();

    protected static void banditSteve(int currentRoom, int currentCash){
        int randomRoom = rand.nextInt(8);
        if (currentRoom == randomRoom){
            out.println(Graphic.printDesign(11) + "Oh no, it's Steve the Bandit!\n\nSteve takes all your cash :(\n\n" +
                    "You're back to $" + currentCash + "\n\n");
        }
        Game.roomMoney[currentRoom] = false;
    }
}
