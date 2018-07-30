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

          // testing
          for (int i=0; i<deck.size();i+=1)
          {
              System.out.println("Cards in deck " + deck.get(i) + " " + i);
          }

      }
      public List<Card> getCards(int num_cards){
          List <Card> removedCards = new ArrayList<Card>(num_cards);
          for (int i=0; i<num_cards;i+=1) {
              removedCards.add(deck.get(i));
              System.out.println("Cards added to removedCards " + deck.get(i) + " " + i);
          }
          int counter = num_cards;
          while (counter != 0) {
              deck.remove(0);
              counter-=1;
          }

          // testing
          for (int i=0; i<deck.size();i+=1) {
              System.out.println("Cards removed " + deck.get(i) + " " + i);
          }
          // testing
          for (int i=0; i<removedCards.size();i+=1)
          {
              System.out.println("Cards removed that are in removedCards " + removedCards.get(i) + " " + i);
          }
          System.out.println("Number cards left in the deck " + deck.size());
          System.out.println("Number cards in hand " + removedCards.size());
          return removedCards;
      }

      public Card getCard(){
        Card removedCard=deck.get(0);
        deck.remove(0 );
        System.out.println(removedCard.getRank() + removedCard.getSuit());
//          for (int i=0; i<deck.size();i+=1) {
//              System.out.println("Cards left " + deck.get(i) + " " + i);
//          }
        return removedCard;
      }

      public void addCard(Card c){
        deck.add((StandardCard) c);
//          for (int i=0; i<deck.size();i+=1) {
//              System.out.println("Cards left " + deck.get(i) + " " + i);
//          }
      }

      public int numberOfCards(){
        if( this.deck == null ){
            return -1;
        }else{
            return this.deck.size();
        }
    }

}