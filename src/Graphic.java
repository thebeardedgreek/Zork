public class Graphic {
    protected static String printDesign(int whichDesign){
        String output = "";
        //1 = zork, 2 = gameover, 3 = dead scorpion, 4 = piano, 5 spiders, 6 = bats, 7 = box, 8 = skeletons, 9 = closed chest, 10 = open chest
        output = getGraphic(whichDesign, output);
        return output;
    }

    static String getGraphic(int whichDesign, String output) {
        if (whichDesign == 1){
            output += "\n" + "\nWELCOME TO... \n\n" +
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
                    "       `-'                  `-'                  `-'           \n\n\n";
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
                    "                 +\n\n";
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
                    "                        _.--.\n" +
                    "                    _.-'_:-'||\n" +
                    "                _.-'_.-::::'||\n" +
                    "           _.-:'_.-::::::'  ||\n" +
                    "         .'`-.-:::::::'     ||\n" +
                    "        /.'`;|:::::::'      ||_\n" +
                    "       ||   ||::::::'     _.;._'-._\n" +
                    "       ||   ||:::::'  _.-!oo @.!-._'-.\n" +
                    "       \\'.  ||:::::.-!()oo @!()@.-'_.|\n" +
                    "        '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n" +
                    "          `>'-.!@%()@'@_%-'_.-o _.|'||\n" +
                    "           ||-._'-.@.-'_.-' _.-o  |'||\n" +
                    "           ||=[ '-._.-\\U/.-'    o |'||\n" +
                    "           || '-.]=|| |'|      o  |'||\n" +
                    "           ||      || |'|        _| ';\n" +
                    "           ||      || |'|    _.-'_.-'\n" +
                    "           |'-._   || |'|_.-'_.-'\n" +
                    "            '-._'-.|| |' `_.-'\n" +
                    "                '-.||_/.-'\n\n";
        } else if(whichDesign == 9){
            output += "\n" +
                    "              ____...------------...____\n" +
                    "         _.-\"` /o/__ ____ __ __  __ \\o\\_`\"-._\n" +
                    "       .'     / /                    \\ \\     '.\n" +
                    "       |=====/o/======================\\o\\=====|\n" +
                    "       |____/_/________..____..________\\_\\____|\n" +
                    "       /   _/ \\_     <_o#\\__/#o_>     _/ \\_   \\\n" +
                    "       \\_________\\####/_________/\n" +
                    "        |===\\!/========================\\!/===|\n" +
                    "        |   |=|          .---.         |=|   |\n" +
                    "        |===|o|=========/     \\========|o|===|\n" +
                    "        |   | |         \\() ()/        | |   |\n" +
                    "        |===|o|======{'-.) A (.-'}=====|o|===|\n" +
                    "        | __/ \\__     '-.\\uuu/.-'    __/ \\__ |\n" +
                    "        |==== .'.'^'.'.====|\n" +
                    "        |  _\\o/   __  {.' __  '.} _   _\\o/  _|\n" +
                    "        `\"\"\"\"-\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"-\"\"\"\"`\n\n";
        } else if(whichDesign == 11){
            output += "\n" +
                    "        ############# " +
                    "        ##         ##" +
                    "        #  ~~   ~~  #" +
                    "        # (o)   (o) #" +
                    "        (     ^     )" +
                    "         |         |" +
                    "         |         |" +
                    "         |  {===}  |" +
                    "         \\       /" +
                    "         /  -----  \\ " +
                    "      ---  |%\\ /%|  ---" +
                    "     /     |%%%%%|     \\ " +
                    "           |%/ \\%|\n\n";

        }
        return output;
    }
}
