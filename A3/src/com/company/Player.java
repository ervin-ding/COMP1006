package com.company;

public abstract class Player{
 protected Hand hand;
 
 public Player(Hand hand){ this.hand = hand; }
 
 /* play a card from the player's hand */
 /* returns null if they cannot play a card and the deck becomes empty */
 /* do NOT return null unless you cannot play a card and the deck is empty */
 public abstract Card play(Card top_of_discard_pile, Deck deck);
 
 public final int cardsLeft(){ return this.hand.numberOfCards(); }
 
}