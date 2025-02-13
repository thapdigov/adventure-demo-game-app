package az.turing.location;

import az.turing.inventory.Armor;
import az.turing.inventory.Inventory;
import az.turing.inventory.Weapon;
import az.turing.player.Player;

import static az.turing.util.InputUtil.getInteger;

public class ToolStore extends Location {
    public ToolStore(Player player) {
        super(player, "ToolStore");
    }

    @Override
    public boolean onLocation() {
        System.out.printf("Your are at %s ", getName() + ",you can buy weapon or armor!\n");
        boolean flag = true;
        while (flag) {
            Integer choose = getInteger("""
                    1.Weapon
                    2.Armor
                    3.Back to menu""");
            switch (choose) {
                case 1 -> selectWeapon();
                case 2 -> selectArmor();
                case 3 -> flag = false;
            }
        }
        return flag;
    }

    public void selectWeapon() {
        System.out.printf("Your balance : " + this.getPlayer().getMoney() + "\n");
        System.out.println("#####WEAPONS#######");
        for (Weapon weapon : Inventory.weapons()) {
            System.out.println(weapon);
        }
        int selectId = getInteger("Enter the weapon id");
        while (selectId < 1 || selectId > 3) {
            selectId = getInteger("Invalid input,enter the ID between 1 and 3");
        }
        Weapon selectedweapon = Inventory.weaponById(selectId);
        if (this.getPlayer().getMoney() >= selectedweapon.getPrice()) {
            System.out.println("Your old weapon: " + getPlayer().getWeapon());
            this.getPlayer().setWeapon(selectedweapon);
            System.out.println("Your new weapon " + this.getPlayer().getWeapon());
            this.getPlayer().setDamage(this.getPlayer().getDamage() + selectedweapon.getDamage());
            this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedweapon.getPrice());
        } else {
            System.out.println("you don't have enough money!");
        }
    }

    public void selectArmor() {
        System.out.printf("Your balance : " + this.getPlayer().getMoney() + "\n");
        System.out.println("#####ARMORS#######");
        for (Armor armor : Inventory.armorsList()) {
            System.out.println(armor);
        }
        int selectId = getInteger("Enter the armor id");
        while (selectId < 1 || selectId > 3) {
            selectId = getInteger("Invalid input,enter the ID between 1 and 3");
        }
        Armor selectedArmor = Inventory.armorById(selectId);
        if (this.getPlayer().getMoney() >= selectedArmor.getPrice()) {
            System.out.println("Your old armor: " + getPlayer().getArmor());
            this.getPlayer().setArmor(selectedArmor);
            System.out.println("Your new armor " + this.getPlayer().getArmor());
            this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
        } else {
            System.out.println("you don't have enough money!");
        }
    }
}
