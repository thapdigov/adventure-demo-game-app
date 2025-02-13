package az.turing.location;

import az.turing.monster.Vampire;
import az.turing.player.Player;

public class Forest extends DangerZone{

    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Wood");
    }

}
