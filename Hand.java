package labs_examples.objects_classes_methods.labs.oop.C_blackjack;
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private int handValue;
    private int[] values= {11,2,3,4,5,6,7,8,9,10,10,10,10};

    public Hand() {
        this.cards = new ArrayList<>();
        this.handValue = 0;
    }

    public void clear(){
        cards.clear();
    }

    public int returnHandScore(){

        handValue = 0;

        for (Card card: cards) {
            int value = card.getCardValue();
            handValue += values[value];
        }

        for (Card card: cards) {
            if(card.getCardValue() == 0 && handValue >21) {
                handValue -= 10;
            }
        }
        return handValue;
    }

    public boolean isGreaterThan21() { // exercise 2.4
        if (this.handValue>21) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getHandValue() {
        return handValue;
    }

    public void setHandValue(int handValue) {
        this.handValue = handValue;
    }

    public void addCard(Card card) {
        cards.add(card);
        returnHandScore();
    }

    @Override
    public String toString() {
        return "Hand: " + cards +
                ", Hand value = " + handValue;
    }
}
