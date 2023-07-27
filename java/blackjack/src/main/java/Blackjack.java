import java.util.HashMap;
import java.util.Map;

public class Blackjack {
    Map<String, Integer> cardValues;

    public Blackjack() {
        cardValues = new HashMap<>();
        cardValues.put("ace", 11);
        cardValues.put("two", 2);
        cardValues.put("three", 3);
        cardValues.put("four", 4);
        cardValues.put("five", 5);
        cardValues.put("six", 6);
        cardValues.put("seven", 7);
        cardValues.put("eight", 8);
        cardValues.put("nine", 9);
        cardValues.put("ten", 10);
        cardValues.put("jack", 10);
        cardValues.put("queen", 10);
        cardValues.put("king", 10);
    }

    public int parseCard(String card) {
        if (cardValues.containsKey(card.toLowerCase())) {
            return cardValues.get(card.toLowerCase());
        }
        return 0;
    }

    public boolean isBlackjack(String card1, String card2) {
        return (parseCard(card1) + parseCard(card2)) == 21;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        // rules:
        // - if you have a pair of aces -> P 
        // - blackjack and dealer has no ace or face -> W
        // using dealer value as a proxy for dealer hand
        if (isBlackjack && dealerScore < 10) {
            return "W";
        }

        // blackjack and dealer has ace or face -> S
        if (isBlackjack ) {
            return "S";
        }

        // split
        return "P";
    }

    public String smallHand(int handScore, int dealerScore) {
        // rules:
        // - hand: 17+ -> S
        // - hand: 11- -> H
        // - hand: 12-16 && dealer: 7+ -> H
        // - default -> S
        if (handScore >= 17) {
            return "S";
        }

        if (handScore <= 11) {
            return "H";
        }

        if (handScore <= 16 && dealerScore >= 7) {
            return "H";
        }

        return "S";
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
