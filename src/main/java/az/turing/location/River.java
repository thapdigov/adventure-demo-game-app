package az.turing.location;

import az.turing.monster.Bear;
import az.turing.player.Player;

public class River extends DangerZone{
    public River(Player player) {
        super(player,"River",new Bear(),"Water");
    }
}
