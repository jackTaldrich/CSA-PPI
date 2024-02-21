import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Blackjack {
    static final Logger LOGGER = Logger.getLogger(Blackjack.class.getName());

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        Scanner scanner = new Scanner(System.in);

        welcome();

        label:
        while (true) {
            ArrayList<Integer> cards;
            int total = 0;

            System.out.println("\n\nType STOP to stop.");
            System.out.println("Here are your cards:");

            cards = dealer.dealCards();
            for (int card : cards) {
                System.out.print(card + " ");
                total += card;
            }

            System.out.println("\n\nHit or Stand? (h/s)");
            String hitOrStand = scanner.nextLine();
            hitOrStand = hitOrStand.toLowerCase(Locale.ROOT);

            switch (hitOrStand) {
                case "h":
                    dealer.hit();
                    break;
                case "s":
                    ArrayList<Integer> dealerCards = dealer.stand();

                    int dealerTotal = 0;
                    for (int card : dealerCards) {
                        dealerTotal += card;
                    }

                    System.out.println("Dealer Total: " + dealerTotal);
                    System.out.println("Your Total: " + total);

                    if (dealerTotal > 21) {
                        System.out.println("Dealer busts! You win!");
                    } else if (dealerTotal == total) {
                        System.out.println("It's a tie!");
                    } else if (dealerTotal > total) {
                        System.out.println("Dealer wins!");
                    } else {
                        System.out.println("You win!");
                    }
                    break;
                case "stop":
                    break label;
                default:
                    System.out.println("Invalid input (h/s).");
                    break;
            }
        }
    }

    private static void welcome() {
        System.out.println("Welcome to Blackjack!");
        sleep(1000);
        System.out.println("This was made by Jack and Philipp.");
        sleep(2000);
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Interrupted", e);
        }
    }
}