package az.turing.location;

import az.turing.monster.Monster;
import az.turing.player.Player;

import java.util.Random;
import java.util.stream.Stream;

import static az.turing.util.InputUtil.getInteger;

public class DangerZone extends Location {
    private Monster monster;
    private String award;
    private final Random random = new Random();

    public DangerZone(Player player, String name, Monster monster, String award) {
        super(player, name);
        this.monster = monster;
        this.award = award;
    }

    @Override
    public boolean onLocation() {
        for (String s : getPlayer().getAwards()) {
            if ((this instanceof Cave && s.equals("Food")) ||
                    (this instanceof Forest && s.equals("Wood"))
                    || (this instanceof River && s.equals("Water"))) {
                System.out.println("You have already fight this zone");
                return false;
            }
        }
        int monsterCount = random.nextInt(3) + 1;
        System.out.printf("You are at %s,Be careful,It can be %s here,there is %d monster!\n",
                getName(), getMonster().getName(), monsterCount);
        for (int i = 0; i < monsterCount; i++) {
            boolean flag = true;
            while (flag) {
                System.out.println("Your health: " + getPlayer().getHealth());
                getMonster().setHealth(getMonster().getOriginalHealth());
                int choose = getInteger("""
                        Your choose
                        1.Fight
                        2.Come back To Area""");
                getMonster().setDamage(getMonster().getOriginalDamage());
                if (!(getPlayer().getArmor().equals("none"))) {
                    getMonster().setDamage(getMonster().getDamage() - getPlayer().getArmor().getBlocke());
                }
                switch (choose) {
                    case 1 -> {
                        System.out.println(i + 1 + ". Monster: " + getMonster());
                        while (getPlayer().getHealth() > 0 && getMonster().getHealth() > 0) {
                            boolean fit = random.nextBoolean();
                            if (fit) {
                                if (getPlayer().getHealth() > 0) {
                                    getMonster().setHealth(getMonster().getHealth() - this.getPlayer().getDamage());
                                    System.out.println("You hit the monster ,monster health: " + getMonster().getHealth());
                                }
                                if (getMonster().getHealth() > 0) {
                                    getPlayer().setHealth(getPlayer().getHealth() - getMonster().getDamage());
                                    System.out.println("Monster hit you ,your health: " + getPlayer().getHealth());
                                }
                            } else {
                                if (getMonster().getHealth() > 0) {
                                    getPlayer().setHealth(getPlayer().getHealth() - getMonster().getDamage());
                                    System.out.println("Monster hit you ,your health: " + getPlayer().getHealth());
                                }
                                if (getPlayer().getHealth() > 0) {
                                    getMonster().setHealth(getMonster().getHealth() - this.getPlayer().getDamage());
                                    System.out.println("You hit the monster ,monster health: " + getMonster().getHealth());
                                }
                            }
                        }
                        if (getMonster().getHealth() <= 0) {
                            System.out.printf("You hava dead the monster and won the %s gold", getMonster().getGold());
                            getPlayer().setMoney(getPlayer().getMoney() + getMonster().getGold());
                            flag = false;

                        }
                        if (getPlayer().getHealth() <= 0) {
                            System.err.println("You are dead, GAME OVER!");
                            return false;
                        }
                    }
                    case 2 -> {
                        return true;
                    }
                    default -> System.out.println("Invalid input, enter 1 or 2!");
                }
            }
        }
        System.out.println("You killed all of the monsters and won the award, your award: " + getAward());
        getPlayer().setAwards(getAward());
        if (Stream.of("Wood", "Food", "Water").allMatch(getPlayer().getAwards()::contains)) {
            System.out.println("You have cleaned all of zone and Win the Game!");
            return false;
        }
        return true;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
