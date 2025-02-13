package az.turing.location;

import az.turing.monster.Zombie;
import az.turing.player.Player;

public class Cave extends DangerZone {
    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food");
    }
}
