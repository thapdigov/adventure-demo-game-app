package az.turing.player;

import az.turing.inventory.Armor;
import az.turing.inventory.Weapon;

import java.util.ArrayList;
import java.util.List;

import static az.turing.util.InputUtil.getInteger;

public class Player {
    private Integer id;
    private String name;
    private Integer damage;
    private Integer money;
    private Integer health;
    private Integer originalHealth = 8;

    private Weapon weapon = new Weapon(0, "none", 0, 0);
    private Armor armor = new Armor(0, "none", 0, 0);
    private List<String> awards = new ArrayList<>();

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Player() {
    }

    public Player(Integer id, String name, Integer damage, Integer money, Integer health) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.money = money;
        this.health = health;
        this.originalHealth = health;
    }

    public void selecterChar() {
        System.out.println("\t\t#####PLAYERS####");
        System.out.println("----------------------------------------------------------");
        Samurai samurai = new Samurai();
        Knight knight = new Knight();
        Archer archer = new Archer();
        System.out.println(samurai);
        System.out.println(archer);
        System.out.println(knight);
        System.out.println("----------------------------------------------------------");
        int playerId = getInteger("Enter the playerId");
        while ((playerId < 1 || playerId > 3)) {
            playerId = getInteger("Invalid input,Enter the value between 1 and 3");
        }
        switch (playerId) {
            case 1 -> {
                printPlayer(samurai, samurai.getId(), samurai.getName(), samurai.getDamage(),
                        samurai.getHealth(), samurai.getMoney());
            }

            case 2 -> {
                printPlayer(knight, knight.getId(), knight.getName(), knight.getDamage(),
                        knight.getHealth(), knight.getMoney());
            }

            case 3 -> {
                printPlayer(archer, archer.getId(), archer.getName(), archer.getDamage(),
                        archer.getHealth(), archer.getMoney());
            }
            default -> System.out.println("Invalid input!");
        }
    }

    public void printPlayer(Player player, Integer id, String name, Integer damage, Integer health, Integer money) {
        System.out.println(player);
        this.id = id;
        this.name = name;
        this.damage = damage + weapon.getDamage();
        this.health = health;
        this.originalHealth = health;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(Integer originalHealth) {
        this.originalHealth = originalHealth;
    }

    public void setHealth(Integer health) {
        if (getHealth() < 0) {
            health = 0;
        }
        this.health = health;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(String award) {
        this.awards.add(award);
    }

    @Override
    public String toString() {
        return "ID: " + id + " ,name: " + name + " ,damage: " + damage + " ,money: " + money + " ,health: " + health;
    }
}
