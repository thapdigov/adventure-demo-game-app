package az.turing.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static Weapon[] weapons() {
        Weapon[] weapons = new Weapon[3];
        weapons[0] = new Weapon(1, "Pistol", 4, 25);
        weapons[2] = new Weapon(2, "AK-47", 5, 25);
        weapons[1] = new Weapon(3, "Sniper", 6, 30);
        return weapons;
    }

    public static Weapon weaponById(int id) {
        Weapon weapon = null;
        for (Weapon w : weapons()) {
            if (w.getID().equals(id)) {
                weapon = w;
            }
        }
        return weapon;
    }

    public static List<Armor> armorsList() {
        List<Armor> armorList = new ArrayList<>();
        Armor leather = new Armor(1, "Leater", 2, 15);
        Armor iron = new Armor(2, "Iron", 3, 20);
        Armor diamond = new Armor(3, "Diamond", 4, 25);
        armorList.add(leather);
        armorList.add(iron);
        armorList.add(diamond);
        return armorList;
    }

    public static Armor armorById(int id) {
        return armorsList().get(id - 1);
    }
}
