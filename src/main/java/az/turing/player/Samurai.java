package az.turing.player;

public class Samurai extends Player{
    public Samurai() {
        super(1, "Samurai", 5, 25, 20);
    }

    @Override
    public String toString() {
        return "Samurai - > "+super.toString();
    }
}
