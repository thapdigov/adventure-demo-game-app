package az.turing.location;

import az.turing.player.Player;

public class SafeHouse extends Location {
    public SafeHouse(Player player) {
        super(player, "SafeHouse");
    }

    @Override
    public boolean onLocation() {
        System.out.printf("You are at %s your health hass fulled %d", getName(), getPlayer().getHealth());
        getPlayer().setHealth(getPlayer().getOriginalHealth());
        return true;
    }
}
