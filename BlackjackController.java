package labs_examples.objects_classes_methods.labs.oop.C_blackjack;
import java.util.Scanner;

public class BlackjackController {
    public static void main(String[] args) {

        playBlackJack();
    }

    public static void playBlackJack(){

        Deck deck = new Deck();

        boolean unique = false;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Player 1's name: ");
        String name = scanner.nextLine();

        Player player1 = new Player(name, 100);
        Player player2 = new Player("AI", 100);
        System.out.println(player1);


        while(true) {

            System.out.println("How much do you want to bet? ");
            int betAmount = Integer.valueOf(scanner.nextLine());

            deck.deal(player1);
            deck.deal(player1);
            deck.deal(player2);
            deck.deal(player2);

            System.out.println(player1.getName() + "'s " + player1.getHand());
            System.out.println("AI's hand: [" + player2.getHand().getCards().get(0) + ", ?]");


            while (true) {
                System.out.println("Do you want to draw another card? (y or n)");
                String answer = scanner.nextLine();

                if (answer.equals("y")) {
                    deck.deal(player1);
                }
                System.out.println(player1.getName() + "'s " + player1.getHand());

                boolean aiAnswer = player2.computerAI();

                if (aiAnswer == true) {
                    deck.deal(player2);
                    System.out.println("AI draws a card");
                    System.out.println("AI's hand: [" + player2.getHand().getCards().get(0) + ", ?, ?]");
                } else {
                    System.out.println("AI did not draw a card");
                    System.out.println("AI's hand: [" + player2.getHand().getCards().get(0) + ", ?]");
                }
                if (player1.getHand().getHandValue() > 21) {
                    break;
                }

                if (!answer.equals("y") && aiAnswer == false) {
                    break;
                }



            }

            if (player1.getHand().getHandValue() > 21 && player2.getHand().getHandValue() > 21) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~ Both busted, draw! " + "AI's hand value was "+ player2.getHand().getHandValue() + " ~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("AI's " + player2.getHand());
            } else if (player1.getHand().getHandValue() == player2.getHand().getHandValue()) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~ Same value, draw! " + "AI's hand value was "+ player2.getHand().getHandValue() + " ~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("AI's " + player2.getHand());
            } else if (player1.getHand().getHandValue() > 21) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~ Busted, you lose! " + "AI's hand value was "+ player2.getHand().getHandValue() + " ~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("AI's " + player2.getHand());
                player1.losePotValue(betAmount);
                player2.gainPotValue(betAmount);
                player2.addPoint();
            } else if (player2.getHand().getHandValue() > 21) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~ AI Busted, you win! "+ "AI's hand value was " + player2.getHand().getHandValue() + " ~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("AI's " + player2.getHand());
                player2.losePotValue(betAmount);
                player1.gainPotValue(betAmount);
                player1.addPoint();
            } else if (player1.getHand().getHandValue() > player2.getHand().getHandValue()) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~ You win!" + " AI's hand value was " + player2.getHand().getHandValue() + " ~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("AI's " + player2.getHand());
                player2.losePotValue(betAmount);
                player1.gainPotValue(betAmount);
                player1.addPoint();
            } else {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~ You lose!" + " AI's hand value was " + player2.getHand().getHandValue() + " ~~~~~~~~~~~~~~~~~~~~~~" );
                System.out.println("AI's " + player2.getHand());
                player1.losePotValue(betAmount);
                player2.gainPotValue(betAmount);
                player2.addPoint();
            }

            deck.usedCards.clear();
            player1.getHand().clear();
            player2.getHand().clear();
            player1.addGamesPlayed();

            System.out.println();
            System.out.println("Total games played: " + player1.getGamesPlayed());
            System.out.println("Your score: " + player1.getGamesWon());
            System.out.println("AI score: " + player2.getGamesWon());


            if (player1.getPotValue()<=0) {
                System.out.println("You went broke, see ya!");
                break;
            }

            System.out.println();
            System.out.println("Do you want to play again? (y or n)");
            System.out.println();
            System.out.println(player1);
            if (scanner.nextLine().equals("n")){
                break;
            }
        }

        System.out.println("Play again sometime, Goodbye " + player1.getName() + "!");


    }
}
