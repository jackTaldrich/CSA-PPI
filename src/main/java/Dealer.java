import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Dealer {
    Random random = new Random();

    public ArrayList<Integer> dealCards() {
        ArrayList<Integer> cards = new ArrayList<>();
        cards.add(drawCard());
        cards.add(drawCard());

        return cards;
    }

    public void hit() { }

    public ArrayList<Integer> stand() {
        ArrayList<Integer> dealerCards = new ArrayList<>();

        // draw two cards
        dealerCards.add(drawCard());
        dealerCards.add(drawCard());

        int dealerTotal = dealerCards.get(0) + dealerCards.get(1);

        // simple hit or stand logic employed by casinos
        while (dealerTotal < 17) {
            int newCard = drawCard();
            dealerCards.add(newCard);

            dealerTotal += newCard;
        }

        return dealerCards;
    }

    public int drawCard() {
        return random.nextInt(10) + 1;
    }
}
