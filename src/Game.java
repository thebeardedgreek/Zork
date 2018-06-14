import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Game {

    protected static Boolean isPlaying = true, hasTreasure = false;
    //protected static int playerDirection = 0;
    protected static int currentRoom, playerMoney = 0, roomCounter = 0;
    //protected static boolean[] roomCount = {false, false, false, false, false, false, false, false};
    //protected static boolean[] roomMoney = {true, true, true, true, true, true, true, true};
    protected static Random rand = new Random(3);

    public static void main(String[] args) {
        currentRoom = 8;
        Graphic Graphic = new Graphic();
        out.println(Graphic.printDesign(1));

        while (isPlaying) {

            try {
                currentRoom = Room.chooseRoom(currentRoom);
            } catch (Exception e) {
                String output = Room.gameEnd(hasTreasure, currentRoom, playerMoney);
                out.println(output);
                isPlaying = false;
            }
        }

        Room.displayGameEnd();

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