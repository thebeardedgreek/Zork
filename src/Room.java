import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Room {

    protected static Random rand = new Random();

    protected static int chooseRoom(int currentRoom) {
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
                if (Game.hasTreasure) {

                }
                currentRoom = outsideRoom();
                return currentRoom;
            default:
                return Integer.parseInt(null);
        }
    }


    
    protected static int outsideRoom() {
        Scanner player = new Scanner(System.in);
        out.print("\nYou are outside an old, creepy looking house..\n" + "You thought you saw a ghost in the window upstairs.\n" + "{You can enter the house to the North by typing 'N' or press 'Q' to Quit}\n");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("n")) {
            Game.playerDirection = 0;
        } else if (!playerChoice.equalsIgnoreCase("n")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = Mechanics.gameEnd(Game.hasTreasure, Game.currentRoom, Game.playerMoney);
                out.println(output);
                Game.isPlaying = false;
            }
            Game.playerDirection = 8;
        }
        return Game.playerDirection;
    }


    protected static int foyerRoom() {
        Game.roomCount[0] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.print("\nOk, now you are in the Foyer Room.\n");
        Mechanics.banditSteve(Game.currentRoom);
        if (Game.roomMoney[0]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            try {
                int moneyChoice = player.nextInt();
                Game.playerMoney = Mechanics.moneyTotal(moneyChoice, Game.playerMoney, randomMoney);
                out.println("\nYou now have $" + Game.playerMoney + ".");
                Game.roomMoney[0] = false;
            } catch (Exception e) {
                out.println("Invalid entry!\n");
                Game.playerDirection = 0;
            }
        }
        out.print("You see a dead scorpion.\n" + Graphic.printDesign(3) + "\nGross..\n" + "{You can enter 'N' to exit to the North, 'S' to exit the house to the south, or press Q to Quit}\n");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("n")) {
            Game.playerDirection = 1;
        } else if (playerChoice.equalsIgnoreCase("s")) {
            Game.playerDirection = 8;
        } else if (!playerChoice.equalsIgnoreCase("n") || !playerChoice.equalsIgnoreCase("s")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = Mechanics.gameEnd(Game.hasTreasure, Game.currentRoom, Game.playerMoney);
                out.println(output);
                Game.isPlaying = false;
            }
            Game.playerDirection = 0;
        }
        return Game.playerDirection;
    }

    protected static int frontRoom() {
        Game.roomCount[1] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the Front Room.\n");
        Mechanics.banditSteve(Game.currentRoom);
        if (Game.roomMoney[1]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            Game.playerMoney = Mechanics.moneyTotal(moneyChoice, Game.playerMoney, randomMoney);
            out.println("\nYou now have $" + Game.playerMoney + ".");
            Game.roomMoney[1] = false;
        }
        out.println("You can play Piano and enjoy here.\n" + Graphic.printDesign(4) + "{You can enter 'S' to exit to the South, 'W' to exit West, 'E' to exit to East, or press Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("s")) {
            Game.playerDirection = 0;
        } else if (playerChoice.equalsIgnoreCase("w")) {
            Game.playerDirection = 2;
        } else if (playerChoice.equalsIgnoreCase("e")) {
            Game.playerDirection = 3;
        } else if (!playerChoice.equalsIgnoreCase("w") && !playerChoice.equalsIgnoreCase("e") && !playerChoice.equalsIgnoreCase("s")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = Mechanics.gameEnd(Game.hasTreasure, Game.currentRoom, Game.playerMoney);
                out.println(output);
                Game.isPlaying = false;
            }
            Game.playerDirection = 1;
        }
        return Game.playerDirection;
    }

    protected static int libraryRoom() {
        Game.roomCount[2] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the Library.\n");
        Mechanics.banditSteve(Game.currentRoom);
        if (Game.roomMoney[2]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            Game.playerMoney = Mechanics.moneyTotal(moneyChoice, Game.playerMoney, randomMoney);
            out.println("\nYou now have $" + Game.playerMoney + ".");
            Game.roomMoney[2] = false;
        }
        out.println(Graphic.printDesign(5) + "\nThere are lots of spider here, Be Careful!\n" + "{You can enter 'E' to exit to the East, 'N' to exit to the North, or press Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("n")) {
            Game.playerDirection = 4;
        } else if (playerChoice.equalsIgnoreCase("e")) {
            Game.playerDirection = 1;
        } else if (!playerChoice.equalsIgnoreCase("n") && !playerChoice.equalsIgnoreCase("e")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = Mechanics.gameEnd(Game.hasTreasure, Game.currentRoom, Game.playerMoney);
                out.println(output);
                Game.isPlaying = false;
            }
            Game.playerDirection = 2;
        }
        return Game.playerDirection;
    }

    protected static int kitchenRoom() {
        Game.roomCount[3] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the Kitchen.\n");
        Mechanics.banditSteve(Game.currentRoom);
        if (Game.roomMoney[3]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            Game.playerMoney = Mechanics.moneyTotal(moneyChoice, Game.playerMoney, randomMoney);
            out.println("\nYou now have $" + Game.playerMoney + ".");
            Game.roomMoney[3] = false;
        }
        out.println("There are bats in this room!\n" + Graphic.printDesign(6) + "{You can enter 'W' to exit to the West, 'N' to exit to the North or press Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("w")) {
            Game.playerDirection = 1;
        } else if (playerChoice.equalsIgnoreCase("n")) {
            Game.playerDirection = 6;
        } else if (!playerChoice.equalsIgnoreCase("n") && !playerChoice.equalsIgnoreCase("w")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = Mechanics.gameEnd(Game.hasTreasure, Game.currentRoom, Game.playerMoney);
                out.println(output);
                Game.isPlaying = false;
            }
            Game.playerDirection = 3;
        }
        return Game.playerDirection;
    }

    protected static int diningRoom() {
        Game.roomCount[4] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the Dining Room.\n");
        Mechanics.banditSteve(Game.currentRoom);
        if (Game.roomMoney[4]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            Game.playerMoney = Mechanics.moneyTotal(moneyChoice, Game.playerMoney, randomMoney);
            out.println("\nYou now have $" + Game.playerMoney + ".");
            Game.roomMoney[4] = false;
        }
        out.println("You can find dust and an ugly looking empty box in this room.\n" + Graphic.printDesign(7) + "{You can enter 'S' to exit South or Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("s")) {
            Game.playerDirection = 2;
        } else if (!playerChoice.equalsIgnoreCase("s")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = Mechanics.gameEnd(Game.hasTreasure, Game.currentRoom, Game.playerMoney);
                out.println(output);
                Game.isPlaying = false;
            }
            Game.playerDirection = 4;
        }
        return Game.playerDirection;
    }

    protected static int vaultRoom() {
        Game.roomCount[5] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the vault.\n");
        Mechanics.banditSteve(Game.currentRoom);
        if (Game.roomMoney[5]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            Game.playerMoney = Mechanics.moneyTotal(moneyChoice, Game.playerMoney, randomMoney);
            out.println("\nYou now have $" + Game.playerMoney + ".");
            Game.roomMoney[5] = false;
        }
        out.println("Watch out, there are 3 walking skeletons!\n" + Graphic.printDesign(8) + "{You can enter 'E' to exit East, or Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("e")) {
            Game.playerDirection = 7;
        } else if (!playerChoice.equalsIgnoreCase("e")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = Mechanics.gameEnd(Game.hasTreasure, Game.currentRoom, Game.playerMoney);
                out.println(output);
                Game.isPlaying = false;
            }
            Game.playerDirection = 5;
        }
        return Game.playerDirection;
    }

    protected static int parlorRoom() {
        Game.roomCount[6] = true;
        int randomMoney = 1 + rand.nextInt(1000);
        Scanner player = new Scanner(System.in);
        out.println("\nOk, now you are in the parlor.");
        Mechanics.banditSteve(Game.currentRoom);
        if (Game.roomMoney[6]) {
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            Game.playerMoney = Mechanics.moneyTotal(moneyChoice, Game.playerMoney, randomMoney);
            out.println("\nYou now have $" + Game.playerMoney + ".");
            Game.roomMoney[6] = false;
        }
        out.println("In the middle of the room you see a locked treasure chest.\n" + Graphic.printDesign(9) + "{Enter 'W' to exit West, 'S' to exit South, or Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("w")) {
            Game.playerDirection = 5;
        } else if (playerChoice.equalsIgnoreCase("s")) {
            Game.playerDirection = 3;
        } else if (!playerChoice.equalsIgnoreCase("w") && playerChoice.equalsIgnoreCase("s")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = Mechanics.gameEnd(Game.hasTreasure, Game.currentRoom, Game.playerMoney);
                out.println(output);
                Game.isPlaying = false;
            }
            Game.playerDirection = 6;
        }
        return Game.playerDirection;
    }

    protected static int secretRoom() {
        Game.roomCount[7] = true;
        Scanner player = new Scanner(System.in);
        out.println("\nYAY, You are in the Secret room, All of the Gold in here is yours.\n" + Graphic.printDesign(10) + "Now, try and find your way out ;)\n" +
                "{Enter 'W' to exit West, or Q to Quit}");
        String playerChoice = player.next();
        if (playerChoice.equalsIgnoreCase("w")) {
            Game.playerDirection = 5;
        } else if (!playerChoice.equalsIgnoreCase("w")) {
            if (playerChoice.equalsIgnoreCase("q")) {
                String output = Mechanics.gameEnd(Game.hasTreasure, Game.currentRoom, Game.playerMoney);
                out.println(output);
                Game.isPlaying = false;
            }
            Game.playerDirection = 7;
        }
        Game.hasTreasure = true;
        Game.roomCount[7] = true;
        return Game.playerDirection;
    }


}
