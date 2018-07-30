package com.company;

import java.util.ArrayList;
import java.util.List;

public class CrazyEightsPlayer extends Player {
    public CrazyEightsPlayer(Hand hand) {
        super(hand);
    }
    protected boolean gameover = false;
    protected boolean win = false;

    @Override
    public Card play(Card top_of_discard_pile, Deck deck) {
        if (hand.numberOfCards() > 0) {
            while (!canPlay(top_of_discard_pile)) {
                this.hand.add(drawCard(deck));
            }
            // removeCardfromHand(cardtoPlay(top_of_discard_pile));
            return cardtoPlay(top_of_discard_pile);
        }
        else {
            win = true;
        }
    }

    public Card cardtoPlay(Card top_of_discard_pile) {
        List<Card> cardsinHand = this.hand.getCards();
        Card cardtoPlay = null;
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
//                System.out.println("Before"+cardsinHand.get(i));

//                cardsinHand.get(i).suit=Card.SUITS[num];
//                System.out.println(cardsinHand.get(i));
                cardtoPlay=cardsinHand.get(i);
                break;
            }
        }
        return cardtoPlay;
    }

    public void removeCardfromHand(Card cardPlayed) {
        this.hand.remove(cardPlayed);
    }


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

    public Card drawCard(Deck deck){
        Card card = null;
        if (deck.numberOfCards() > 0) {
            card = deck.getCard();
        }
        return card;
    }
}
