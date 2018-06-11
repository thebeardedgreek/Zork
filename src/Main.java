import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    private static Boolean isPlaying = true, hasTreasure = false;
    static int playerDirection = 0;
    static int currentRoom, playerMoney = 0, roomCounter = 0;
    static boolean[] roomCount = {false, false, false, false, false, false, false, false};
    static boolean[] roomMoney = {true, true, true, true, true, true, true, true};
    static Boolean secretRoom = false;
    static Random rand = new Random(3);

    public static void main(String[] args) {
        int finalRoomCount = 0;
        currentRoom = 8;
        out.println("\nWELCOME TO... \n\n");
        out.print(printDesign(1));

        while (isPlaying){

            try {
                currentRoom = chooseRoom(currentRoom);
            }
            catch (Exception e){
                    String output = gameEnd(hasTreasure, currentRoom, playerMoney);
                    out.println(output);
                    isPlaying = false;
            }
        }
        finalRoomCount = roomTotal(roomCount);
        if (finalRoomCount == 1){
            out.print("You only entered " + finalRoomCount + " room! :(");
        } else {
            out.print("You entered " + finalRoomCount + " rooms.");
        }
        
        out.println("\nYou finished with $" + playerMoney);
        int randomChance = rand.nextInt(4);
        if (randomChance > 2){
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
                if (randomChance > 2){
                    currentRoom = secretRoom();
                    return currentRoom;
                } else {
                    currentRoom = parlorRoom();
                    return currentRoom;
                }
            case 8:
                if (hasTreasure){

                }
                currentRoom = outsideRoom();
                return currentRoom;
            default:
                return Integer.parseInt(null);
        }
    }

    private static String gameEnd(Boolean hasTreasure, int isOutside, int playerCash){
        String output = printDesign(2);
        if (hasTreasure && isOutside == 8){
            output += "Well done! You have escaped the house with the treasure and $" + playerCash + " that you found!\nThank you for playing!";
        } else if(hasTreasure && isOutside != 8){
            output += "You found the treasure, but you have to find your way out to win the game!";
            if (playerCash > 0){
                output += "You ended the game with $" + playerCash + "!";
            }
            output += "\nThank you for playing!";
        } else if(!hasTreasure && isOutside != 8){
            output += "You never found the treasure :(";
            if (playerCash > 0){
                output += "You ended the game with $" + playerCash + "!";
            }
            output += "\nThank you for playing!";
        } else if(!hasTreasure && isOutside == 8){
            output += "Well, you didn't get lost in the house.. but you never found the treasure!";
            if (playerCash > 0){
                output += "You get to leave with $" + playerCash + " that you found!";
            }
            output += "\nThank you for playing!";
        }
        return output;
    }

    private static int outsideRoom() {
        Scanner player = new Scanner(System.in);
        out.print("\nYou are outside an old, creepy looking house..\n"+ "You thought you saw a ghost in the window upstairs.\n" + "{You can enter 1 to enter the house to the north, or press Q to Quit}\n");
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
        out.print("\nYou are in the Foyer Room.\n");
            if (roomMoney[0]){
                out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
                int moneyChoice = player.nextInt();
                playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
                out.println("\nYou now have $" + playerMoney + ".");
                roomMoney[0] = false;
            }
        out.print("You see a dead scorpion.\n" + printDesign(3) + "\nGross..\n" + "{You can enter 1 to exit to the north, 2 to exit the house to the south, or press Q to Quit}\n");
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
        out.println("\nOk, now you are in the Front Room.\n" + "You can play Piano and enjoy here.\n" + printDesign(4));
        if (roomMoney[1]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
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
        out.println("\nOk, now you are in the Library.\n" + printDesign(5) + "\nThere are lots of spider here, Be Careful!\n");
        if (roomMoney[2]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
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
        out.println("\nOk, now you are in the Kitchen.\n"+ "There are bats in this room!\n" + printDesign(6));
        if (roomMoney[3]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
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
        out.println("\nOk, now you are in the Dining Room.\n" + "You can find dust and an empty box in this room.\n" + printDesign(7));
        if (roomMoney[4]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
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
        out.println("\nOk, now you are in the vault.\nWatch out, there are 3 walking skeletons!\n" + printDesign(8));
        if (roomMoney[5]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
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
        out.println("\nYou are in the parlor, this is the place for treasure chest.\n" + printDesign(9));
        if (roomMoney[6]){
            out.print("You find $" + randomMoney + " lying on the ground in this room. \nDo you pick it up? \n{You can enter 1 to pick it up, or 2 to ignore it.}\n");
            int moneyChoice = player.nextInt();
            playerMoney = moneyTotal(moneyChoice, playerMoney, randomMoney);
            out.println("\nYou now have $" + playerMoney + ".");
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
        out.println("\nYAY, You are in the Secret room, All of the Gold in here is yours.\n"+ printDesign(10 ) + "Now, try and find your way out ;)\n" +
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

   private static String printDesign(int whichDesign){
        String output = "";
        //1 = zork, 2 = gameover, 3 = dead scorpion, 4 = piano, 5 spiders, 6 = bats, 7 = box, 8 = skeletons, 9 = closed chest, 10 = open chest
        if (whichDesign == 1){
            output += "\n" +
                    "ZZZZZZZZZZZZZZZZZZZ          OOOOOOOOO          RRRRRRRRRRRRRRRRR        KKKKKKKKK    KKKKKKK\n" +
                    "Z:::::::::::::::::Z        OO:::::::::OO        R::::::::::::::::R       K:::::::K    K:::::K\n" +
                    "Z:::::::::::::::::Z      OO:::::::::::::OO      R::::::RRRRRR:::::R      K:::::::K    K:::::K\n" +
                    "Z:::ZZZZZZZZ:::::Z      O:::::::OOO:::::::O     RR:::::R     R:::::R     K:::::::K   K::::::K\n" +
                    "ZZZZZ     Z:::::Z       O::::::O   O::::::O       R::::R     R:::::R     KK::::::K  K:::::KKK\n" +
                    "        Z:::::Z         O:::::O     O:::::O       R::::R     R:::::R       K:::::K K:::::K   \n" +
                    "       Z:::::Z          O:::::O     O:::::O       R::::RRRRRR:::::R        K::::::K:::::K    \n" +
                    "      Z:::::Z           O:::::O     O:::::O       R:::::::::::::RR         K:::::::::::K     \n" +
                    "     Z:::::Z            O:::::O     O:::::O       R::::RRRRRR:::::R        K:::::::::::K     \n" +
                    "    Z:::::Z             O:::::O     O:::::O       R::::R     R:::::R       K::::::K:::::K    \n" +
                    "   Z:::::Z              O:::::O     O:::::O       R::::R     R:::::R       K:::::K K:::::K   \n" +
                    "ZZZ:::::Z     ZZZZZ     O::::::O   O::::::O       R::::R     R:::::R     KK::::::K  K:::::KKK\n" +
                    "Z::::::ZZZZZZZZ:::Z     O:::::::OOO:::::::O     RR:::::R     R:::::R     K:::::::K   K::::::K\n" +
                    "Z:::::::::::::::::Z      OO:::::::::::::OO      R::::::R     R:::::R     K:::::::K    K:::::K\n" +
                    "Z:::::::::::::::::Z        OO:::::::::OO        R::::::R     R:::::R     K:::::::K    K:::::K\n" +
                    "ZZZZZZZZZZZZZZZZZZZ          OOOOOOOOO          RRRRRRRR     RRRRRRR     KKKKKKKKK    KKKKKKK\n";
        } else if(whichDesign == 2){
            output += "\n\n" +
                    "        GGGGGGGGGGGGG                                                                                                 OOOOOOOOO                                                                                          \n" +
                    "     GGG::::::::::::G                                                                                               OO:::::::::OO                                                                                        \n" +
                    "   GG:::::::::::::::G                                                                                             OO:::::::::::::OO                                                                                      \n" +
                    "  G:::::GGGGGGGG::::G                                                                                            O:::::::OOO:::::::O                                                                                     \n" +
                    " G:::::G       GGGGGG       aaaaaaaaaaaaa           mmmmmmm    mmmmmmm            eeeeeeeeeeee                   O::::::O   O::::::O     vvvvvvv           vvvvvvv         eeeeeeeeeeee         rrrrr   rrrrrrrrr        \n" +
                    "G:::::G                     a::::::::::::a        mm:::::::m  m:::::::mm        ee::::::::::::ee                 O:::::O     O:::::O      v:::::v         v:::::v        ee::::::::::::ee       r::::rrr:::::::::r       \n" +
                    "G:::::G                     aaaaaaaaa:::::a      m::::::::::mm::::::::::m      e::::::eeeee:::::ee               O:::::O     O:::::O       v:::::v       v:::::v        e::::::eeeee:::::ee     r:::::::::::::::::r      \n" +
                    "G:::::G    GGGGGGGGGG                a::::a      m::::::::::::::::::::::m     e::::::e     e:::::e               O:::::O     O:::::O        v:::::v     v:::::v        e::::::e     e:::::e     rr::::::rrrrr::::::r     \n" +
                    "G:::::G    G::::::::G         aaaaaaa:::::a      m:::::mmm::::::mmm:::::m     e:::::::eeeee::::::e               O:::::O     O:::::O         v:::::v   v:::::v         e:::::::eeeee::::::e      r:::::r     r:::::r     \n" +
                    "G:::::G    GGGGG::::G       aa::::::::::::a      m::::m   m::::m   m::::m     e:::::::::::::::::e                O:::::O     O:::::O          v:::::v v:::::v          e:::::::::::::::::e       r:::::r     rrrrrrr     \n" +
                    "G:::::G        G::::G      a::::aaaa::::::a      m::::m   m::::m   m::::m     e::::::eeeeeeeeeee                 O:::::O     O:::::O           v:::::v:::::v           e::::::eeeeeeeeeee        r:::::r                 \n" +
                    " G:::::G       G::::G     a::::a    a:::::a      m::::m   m::::m   m::::m     e:::::::e                          O::::::O   O::::::O            v:::::::::v            e:::::::e                 r:::::r                 \n" +
                    "  G:::::GGGGGGGG::::G     a::::a    a:::::a      m::::m   m::::m   m::::m     e::::::::e                         O:::::::OOO:::::::O             v:::::::v             e::::::::e                r:::::r                 \n" +
                    "   GG:::::::::::::::G     a:::::aaaa::::::a      m::::m   m::::m   m::::m      e::::::::eeeeeeee                  OO:::::::::::::OO               v:::::v               e::::::::eeeeeeee        r:::::r                 \n" +
                    "     GGG::::::GGG:::G      a::::::::::aa:::a     m::::m   m::::m   m::::m       ee:::::::::::::e                    OO:::::::::OO                  v:::v                 ee:::::::::::::e        r:::::r                 \n" +
                    "        GGGGGG   GGGG       aaaaaaaaaa  aaaa     mmmmmm   mmmmmm   mmmmmm         eeeeeeeeeeeeee                      OOOOOOOOO                     vvv                    eeeeeeeeeeeeee        rrrrrrr                 \n" +
                    "                                                                                                                                                                                                            \n\n";
        } else if(whichDesign == 3){
            output += "\n" +
                    " ___    ___\n" +
                    "( _<    >_ )\n" +
                    "//        \\\\\n" +
                    "\\\\___xx___//\n" +
                    " `-(    )-'\n" +
                    "   _|__|_\n" +
                    "  /_|__|_\\\n" +
                    "  /_|__|_\\\n" +
                    "  /_\\__/_\\\n" +
                    "   \\ || /  _)\n" +
                    "     ||   ( )\n" +
                    "     \\\\___//\n" +
                    "      `---'\n";
        } else if(whichDesign == 4){
            output += "\n" +
                    " ____________________________________\n" +
                    "|\\                                    \\\n" +
                    "| \\                                    \\\n" +
                    "|  \\____________________________________\\\n" +
                    "|  |       __---_ _---__                |\n" +
                    "|  |      |======|=====|                |\n" +
                    "|  |      |======|=====|                |\n" +
                    "|  |  ____|__---_|_---_|______________  |\n" +
                    "|  | |                                | |\n" +
                    "|   \\ \\                                \\ \\\n" +
                    "|  \\ ||\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\| |\n" +
                    "|  |\\  ,--------------------------------  |\n" +
                    "|  ||| |                               || |\n" +
                    " \\ ||| |           -  -                || |\n" +
                    "  \\'|| |-----------\\\\-\\\\---------------|| |\n" +
                    "    \\|_|            \"  \"               \\|_|\n\n";
        } else if(whichDesign == 5){
            output += "\n" +
                    "                                   _\n" +
                            "       /      \\         __      _\\( )/_\t\t\t\t\t\t      \\_______/\n" +
                            "    \\  \\  ,,  /  /   | /  \\ |    /(O)\\ \t\t\t\t\t\t  `.,-'\\_____/`-.,'\n" +
                            "     '-.`\\()/`.-'   \\_\\\\  //_/    _.._   _\\(o)/_  //  \\\\       /`..'\\ _ /`.,'\\\n" +
                            "    .--_'(  )'_--.   .'/()\\'.   .'    '.  /(_)\\  _\\\\()//_     /  /`.,' `.,'\\  \\\n" +
                            "   / /` /`\"\"`\\ `\\ \\   \\\\  //   /   __   \\       / //  \\\\ \\   /__/__/     \\__\\__\\__\n" +
                            "    |  |  ><  |  |          ,  |   ><   |  ,     | \\__/ |    \\  \\  \\     /  /  /\n" +
                            "    \\  \\      /  /         . \\  \\      /  / .              _  \\  \\,'`._,'`./  /\n" +
                            "   _    '.__.'    _\\(O)/_   \\_'--`(  )'--'_/     __     _\\(_)/_\\,'`./___\\,'`./\n" +
                            "_\\( )/_            /(_)\\      .--'/()\\'--.    | /  \\ |   /(O)\\,'`-./_____\\,-'`.\n" +
                            " /(O)\\  //  \\\\         _     /  /` '' `\\  \\  \\_\\\\  //_/           /       \\\n" +
                            "       _\\\\()//_     _\\(_)/_    |        |      //()\\\\ \n" +
                            "      / //  \\\\ \\     /(o)\\      \\      /       \\\\  //\n" +
                            "       | \\__/ |\n";
        } else if(whichDesign == 6){
            output += "\n" +
                    "   __       __        ____       ____        __       __        \n" +
                    "   ) \\     / (        )   \\     /   (        ) \\     / (        \n" +
                    "  )_  \\_V_/  _(        )_  \\_V_/  _(        )_  \\_V_/  _(        \n" +
                    "    )__   __(            )__   __(            )__   __(            \n" +
                    "       `-'                  `-'                  `-'           \n";
        } else if(whichDesign == 7){
            output += "\n" +
                    "                   _.-+.\n" +
                    "              _.-\"\"     '.\n" +
                    "          +:\"\"            '.\n" +
                    "          J \\               '.\n" +
                    "           L \\             _.-+\n" +
                    "           |  '.       _.-\"   |\n" +
                    "           J    \\  _.-\"       L\n" +
                    "            L    +\"          J\n" +
                    "            +    |           |   \n" +
                    "             \\   |          .+\n" +
                    "              \\  |       .-'\n" +
                    "               \\ |    .-'\n" +
                    "                \\| .-'\n" +
                    "                 +\n";
        } else if(whichDesign == 8){
            output += "\n" +
                    "      .-.         .-.          .-.   ____________\n" +
                    "     (o.o)       (o.o)        (o.o)_/ Hey how ya \\\n" +
                    "      |=|         |=|          |=|  \\____doin?___/\n" +
                    "     __|__       __|__        __|__\n" +
                    "   //.=|=.\\\\   //.=|=.\\\\    //.=|=.\\\\\n" +
                    "  // .=|=. \\\\ // .=|=. \\\\  // .=|=. \\\\\n" +
                    "  \\\\ .=|=. // \\\\ .=|=. //  \\\\ .=|=. //\n" +
                    "   \\\\(_=_)//   \\\\(_=_)//    \\\\(_=_)//\n" +
                    "    (:| |:)     (:| |:)      (:| |:)\n" +
                    "     || ||       || ||        || ||\n" +
                    "     () ()       () ()        () ()\n" +
                    "     || ||       || ||        || ||\n" +
                    "     || ||       || ||        || ||\n" +
                    "    ==' '==     ==' '==      ==' '==       \n" +
                    "\t\t\t\t\t\n";
        } else if(whichDesign == 10){
            output += "\n" +
                    "                            _.--.\n" +
                    "                        _.-'_:-'||\n" +
                    "                    _.-'_.-::::'||\n" +
                    "               _.-:'_.-::::::'  ||\n" +
                    "             .'`-.-:::::::'     ||\n" +
                    "            /.'`;|:::::::'      ||_\n" +
                    "           ||   ||::::::'     _.;._'-._\n" +
                    "           ||   ||:::::'  _.-!oo @.!-._'-.\n" +
                    "           \\'.  ||:::::.-!()oo @!()@.-'_.|\n" +
                    "            '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n" +
                    "              `>'-.!@%()@'@_%-'_.-o _.|'||\n" +
                    "               ||-._'-.@.-'_.-' _.-o  |'||\n" +
                    "               ||=[ '-._.-\\U/.-'    o |'||\n" +
                    "               || '-.]=|| |'|      o  |'||\n" +
                    "               ||      || |'|        _| ';\n" +
                    "               ||      || |'|    _.-'_.-'\n" +
                    "               |'-._   || |'|_.-'_.-'\n" +
                    "                '-._'-.|| |' `_.-'\n" +
                    "                    '-.||_/.-'\n";
        } else if(whichDesign == 9){
            output += "\n" +
                    "                    ____...------------...____\n" +
                    "               _.-\"` /o/__ ____ __ __  __ \\o\\_`\"-._\n" +
                    "             .'     / /                    \\ \\     '.\n" +
                    "             |=====/o/======================\\o\\=====|\n" +
                    "             |____/_/________..____..________\\_\\____|\n" +
                    "             /   _/ \\_     <_o#\\__/#o_>     _/ \\_   \\\n" +
                    "             \\_________\\####/_________/\n" +
                    "              |===\\!/========================\\!/===|\n" +
                    "              |   |=|          .---.         |=|   |\n" +
                    "              |===|o|=========/     \\========|o|===|\n" +
                    "              |   | |         \\() ()/        | |   |\n" +
                    "              |===|o|======{'-.) A (.-'}=====|o|===|\n" +
                    "              | __/ \\__     '-.\\uuu/.-'    __/ \\__ |\n" +
                    "              |==== .'.'^'.'.====|\n" +
                    "              |  _\\o/   __  {.' __  '.} _   _\\o/  _|\n" +
                    "              `\"\"\"\"-\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"-\"\"\"\"`\n";
        }
        return output;
   }
}



