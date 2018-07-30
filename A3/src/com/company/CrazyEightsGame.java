package com.company;

import java.util.List;

public class CrazyEightsGame {
    public CrazyEightsGame(Player player){
    }
    public static void main (String[] args) {
        Card j = new StandardCard(3, "Spades");
        Card c = new StandardCard("Queen", "Diamonds");
        Card d = new StandardCard("4", "Hearts");
        Card two = new StandardCard("2", "Clubs");
        Card eight = new StandardCard("8", "Spades");

        Deck deck = new Deck(10);
//        deck.getCards(10);
//        deck.getCards(10);
//        deck.getCards(10);
        deck.getCard();
        deck.addCard(j);
        Hand hand = new Hand(deck.getCards(3));
//        System.out.println(hand.getCards());
//        System.out.println("remove" + hand.remove(two));
//        hand.numberOfCards();
//        System.out.println("should remove 2C "+hand.getCards());

        Player player = new CrazyEightsPlayer(hand);
        System.out.println("hand before play1: " + player.hand.getCards());
        List<Card> cardsinHand = player.hand.getCards();
        player.hand.remove(cardsinHand.get(0));
        System.out.println("hand before play2: " + player.hand.getCards());

        System.out.println("return from play: " + player.play(d,deck));
        System.out.println("hand after play: " + player.hand.getCards());



    }
}
