package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Arrays;

public class Card {

    private char[] suits = new char[]{'♠', '♦', '♥', '♣'};
    private int suit;
    private String[] values = new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    private int cardValue;

    public Card(int suit, int cardValue) {
        this.suit = suit;
        this.cardValue = cardValue;
    }
    public int getSuit() {
        return suit;
    }

    public int getCardValue() {
        return cardValue;
    }

    @Override
    public String toString() {
        return suits[suit] +
                values[cardValue];
    }
}


//    public Card convertNumToCard(int cardNum) {
//
//        for (int i = 0; i<52; i++) {
//            if (cardNum >0 && cardNum <14) {
//                Card newCard = new Card(0,cardNum);
//            } else if (cardNum >13 && cardNum <27) {
//                Card newCard = new Card(0,cardNum);
//            } else if (cardNum >26 && cardNum <40) {
//                Card newCard = new Card(0,cardNum);
//            } else (cardNum >39 && cardNum <54) {
//                Card newCard = new Card(0,cardNum);
//            }
//        }
//        return newCard;
//    }