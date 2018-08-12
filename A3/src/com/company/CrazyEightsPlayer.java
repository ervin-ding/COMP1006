//Ervin Ding
package com.company;

import java.util.List;

public class CrazyEightsPlayer extends Player {
    public CrazyEightsPlayer(Hand hand) {
        super(hand);
    }

    @Override
    public Card play(Card top_of_discard_pile, Deck deck) {
        List<Card> cardsinHand = this.hand.getCards();
        Card cardtoPlay = null;
        // calls canPlay to determine if a playable card is in the hand. If not, call drawCard to draw a new card. Loops until canPlay is true.
        while (!canPlay(top_of_discard_pile)) {
            this.hand.add(drawCard(deck));
        }
        // when playable, loop through the hand to determine which card to play. If the card is an 8, randomly sets the suit of the card. Removes the card from the hand and returns it.
        for (int i = 0; i < this.hand.getCards().size(); i += 1) {
            if (cardsinHand.get(i).getSuit() == top_of_discard_pile.getSuit()) {
                cardtoPlay=cardsinHand.get(i);
                break;
            } else if (cardsinHand.get(i).getRank() == top_of_discard_pile.getRank()) {
                cardtoPlay=cardsinHand.get(i);
                break;
            } else if (cardsinHand.get(i).getRank() == 8) {
                int num = (int)(Math.random() * 4);
                hand.remove(cardsinHand.get(i));
                hand.add(new StandardCard(8,Card.SUITS[num]));
                cardtoPlay=cardsinHand.get(i);
                break;
            }
        }
        removeCardfromHand(cardtoPlay);
        return cardtoPlay;
    }

    // removes card from hand.
    public void removeCardfromHand(Card cardPlayed) {
        this.hand.remove(cardPlayed);
    }

    // loops through the hand to determine if the player can play.
    public boolean canPlay(Card top_of_discard_pile) {
        List<Card> cardsinHand = this.hand.getCards();
        boolean canPlay = false;
            for (int i = 0; i < this.hand.getCards().size(); i += 1) {
                if (cardsinHand.get(i).getSuit() == top_of_discard_pile.getSuit()) {
                    canPlay=true;
                    break;
                } else if (cardsinHand.get(i).getRank() == top_of_discard_pile.getRank()) {
                    canPlay=true;
                    break;
                } else if (cardsinHand.get(i).getRank() == 8) {
                    canPlay=true;
                    break;
                }
            }
        return canPlay;
    }

    // draws a card from the deck if there are cards left. if not, return null.
    public Card drawCard(Deck deck){
        Card card = null;
        if (deck.numberOfCards() > 0) {
            card = deck.getCard();
        }
        return card;
    }
    // check if deck is empty.. does so by checking is drawCard returns null to determine is game is over
    public boolean isGameover(Deck deck){
        if (drawCard(deck) == null){
            return true;
        }
        else {
            return false;
        }
    }

    // check if hand is empty to determine is player has won
    public boolean isWin(Hand hand){
        if (hand.numberOfCards() == 0){
            return true;
        }
        else {
            return false;
        }
    }
}
