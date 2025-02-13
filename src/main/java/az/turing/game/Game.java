package az.turing.game;

import az.turing.location.Cave;
import az.turing.location.Forest;
import az.turing.location.Location;
import az.turing.location.River;
import az.turing.location.SafeHouse;
import az.turing.location.ToolStore;
import az.turing.player.Player;

import static az.turing.util.InputUtil.getInteger;
import static az.turing.util.InputUtil.getText;

public class Game {

    public static void start() {
        System.out.println("\n\t\t\tWelcome to the Adventure Game!");
        String name = getText("Enter the name");
        System.out.printf("Hello %s ,,Everthing is real you see here\n", name);
        Player player = new Player();
        player.selecterChar();
        System.out.println("You have choosen player,now You choose that you want to go!");
        Location location = null;
        boolean flag = true;
        while (flag) {
            System.out.println(player);
            int menu = getInteger("""
                    #######LOCATIONS#####
                    1.SafeHouse
                    2.TooStore
                    3.Cave
                    4.Forest
                    5.River
                    6.Exit""");
            switch (menu) {
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new ToolStore(player);
                case 3 -> location = new Cave(player);
                case 4 -> location = new Forest(player);
                case 5 -> location = new River(player);
                case 6 -> flag = false;
            }

            if (location != null && location.onLocation()) {
                location.onLocation();
            }
        }
    }
}
