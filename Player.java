package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Player {
    private String name;
    private Hand hand;
    private int potValue;

    private static int gamesPlayed;

    private int gamesWon;
    public Player(String name, int potValue) {
        this.name = name;
        this.hand = new Hand();
        this.potValue = potValue;
    }

    public void addGamesPlayed(){
        this.gamesPlayed++;
    }

    public void addPoint(){
        gamesWon++;
    }

    public static int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public boolean computerAI(){  // exercise 2.5
        if (hand.getHandValue()<16){
            return true;
        } else {
            return false;
        }
    }
    public String getName() {
        return name;
    }
    public Hand getHand() {
        return hand;
    }
    public int getPotValue() {
        return potValue;
    }

    public void losePotValue(int potValue) {
        this.potValue -= potValue;
    }
    public void gainPotValue(int potValue) {
        this.potValue += potValue;
    }

    public void showHand(){
        System.out.println(hand);
    }

    @Override
    public String toString() {
        return name +
                "'s Pot Value = " + potValue;
    }
}
