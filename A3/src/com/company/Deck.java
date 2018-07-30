package com.company;

import java.util.ArrayList;
import java.util.List;

/* finish all of the constructors and methods given here */
/* do NOT add any public attributes or methods          */
/* add any protected/private attributes you need         */
public class Deck{
    protected List <StandardCard> deck;
    public Deck(){
        this(0);
    }

    // creates an array of size 52 + num_joker and creates card objects to fill the array.
    public Deck(int num_jokers){
        deck = new ArrayList<StandardCard>(52 + num_jokers);
        for (int i = 2; i<Card.RANKS.length; i+=1 ) {
              for (int e = 0; e<Card.SUITS.length-1; e+=1){
                  StandardCard card = new StandardCard(i, Card.SUITS[e]);
                  deck.add(card);
              }
          }
          for (int i = 0; i<num_jokers; i+=1){
              StandardCard card = new StandardCard(1, "Joker");
              deck.add(card);
          }
      }

      //returns a list of cards from the deck.
      public List<Card> getCards(int num_cards){
          List <Card> removedCards = new ArrayList<Card>(num_cards);
          for (int i=0; i<num_cards;i+=1) {
              removedCards.add(deck.get(i));
          }
          int counter = num_cards; // uses a counter to keep track of how many cards to remove.
          while (counter != 0) {
              deck.remove(0);
              counter-=1;
          }
          return removedCards;
      }

      // returns a single card object from the deck. (First card)
      public Card getCard(){
        Card removedCard=deck.get(0);
        deck.remove(0 );
        return removedCard;
      }

      // adds a card object to the end of the list
      public void addCard(Card c){
        deck.add((StandardCard) c);
      }

      // returns the number of cards in the deck
      public int numberOfCards(){
        if( this.deck == null ){
            return -1;
        }else{
            return this.deck.size();
        }
    }

}