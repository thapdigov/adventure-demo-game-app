package az.turing.monster;

public class Monster {

    private String name;
    private Integer damage;
    private Integer health;
    private Integer originalHealth;
    private Integer originalDamage;
    private Integer gold;

    public Monster(String name, Integer damage, Integer health, Integer gold) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.originalHealth = health;
        this.originalDamage = damage;
        this.gold = gold;
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

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(Integer originalHealth) {
        this.originalHealth = originalHealth;
    }

    public Integer getOriginalDamage() {
        return originalDamage;
    }

    public void setOriginalDamage(Integer originalDamage) {
        this.originalDamage = originalDamage;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", health=" + health +
                ", gold=" + gold +
                '}';
    }
}
