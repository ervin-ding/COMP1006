package com.company;

public class StandardCard extends Card implements Comparable<Card>{
    /**  purpose: creates a card with given rank and suit
     * preconditions: suit must be a string found in Card.SUITS
     * rank must be a string found in Card.RANKS
     * Note: If the rank is Card.RANKS[15] then any
     * valid suit from Card.SUITS can be given
     * but the card's suit will be set to Card.SUITS[4] */
    public StandardCard(String rank, String suit) {
        super(suit,rank);
        for (int i = 0; i<RANKS.length; i+=1) {
            if (rank == RANKS[i]){
                this.rank = RANKS[i];
                break;
            }
        }
        if (this.rank != "Joker"){
            for (int i = 0; i<SUITS.length; i+=1) {
                if (suit == SUITS[i]) {
                    this.suit = SUITS[i];
                    break;
                }
            }
        }
        else{
        this.suit = SUITS[4];
        }
    }
    /**  purpose: creates a card with the given rank and suit
     * preconditions: suit must be a string found in Card.SUITS
     * rank is an integer satisfying 1 <= rank <= 14, where
     * 1 for joker, 2 for 2, 3 for 3, .., 10 for 10
     * 11 for jack, 12 for queen, 13 for king, 14 for ace
     * Note: as with the other constructor, if a joker is created, any valid suit can be passed
     * but the card's suit will be set to Card.SUITS[4] */
    public StandardCard(int rank, String suit) {
        super(suit,rank);
        if (rank != 1) {
            for (int i = 0; i < SUITS.length; i += 1) {
                if (suit == SUITS[i]) {
                    this.suit = SUITS[i];
                    break;
                }
            }
        }
        else{
            this.suit = SUITS[4];
        }
        this.rank = RANKS[rank];
    }

    public int getSuitInt(String suit) {
        int suitInt = 0;
        for (int i = 0; i<SUITS.length; i+=1) {
            if (suit == SUITS[i]) {
                suitInt = i;
                break;
            }
        }
        return suitInt;
    }
    @Override
    public int getRank() {
        int rankInt = 0;
        for (int i = 0; i<RANKS.length; i+=1) {
            if (this.rank == RANKS[i]) {
                rankInt = i;
                break;
            }
        }
        return rankInt;
    }

    @Override
    public String getRankString() {
        return this.rank;
    }

    @Override
    public String getSuit() {
        return this.suit;
    }

    @Override
    public int compareTo(Card o) {
//        int suitofFirstCard = 0;
//        int suitofSecondCard = 0;
        int rankofFirstCard = this.getRank();
        int rankofSecondCard = o.getRank();
        int value = 0;
        int suitofFirstCard = getSuitInt(this.getSuit());
        int suitofSecondCard = getSuitInt(o.getSuit());

//        for (int i = 0; i<SUITS.length; i+=1) {
//            if (this.suit == SUITS[i]) {
//                suitofFirstCard = i;
//                break;
//            }
//        }
//        for (int i = 0; i<SUITS.length; i+=1) {
//            if (o.getSuit() == SUITS[i]) {
//                suitofSecondCard = i;
//                break;
//            }
//        }
        System.out.println("no method first card " + suitofFirstCard);
        System.out.println("no method second card " + suitofSecondCard);

        if (suitofFirstCard > suitofSecondCard){
            value = 1;
        }
        else if (suitofFirstCard < suitofSecondCard){
            value = -1;
        }
        else if (suitofFirstCard == suitofSecondCard){
            if (rankofFirstCard > rankofSecondCard){
                value = 1;
            }
            else {
                value = -1;
            }
        }
        return value;
    }

    public static void main (String[] args) {
//      int counter = 0;
//      for (int i = 1; i<RANKS.length; i+=1 ) {
//          for (int e = 0; e<SUITS.length-1; e+=1){
//              StandardCard card = new StandardCard(i, SUITS[e]);
//              System.out.println("RANKSTRING: " + card.getRankString() + ", RANKINT: " + card.getRank() + ", SUIT: " + card.getSuit() + ", " + card.toString());
//              counter++
        Card j = new StandardCard(3, "Spades");
        Card c = new StandardCard("Queen", "Diamonds");
        c.getRank();
        c.getRankString();
        c.getSuit();
        System.out.println(c);
        Card d = new StandardCard("4", "Spades");
        System.out.println(c.compareTo(d));
        System.out.println(j.compareTo(d));
        Deck deck = new Deck(10);
//        deck.getCards(10);
//        deck.getCards(10);
//        deck.getCards(10);
        deck.getCard();
        deck.addCard(j);
        Hand hand = new Hand(deck.getCards(10));
        hand.remove(j);
        System.out.println(hand.getCards());
        hand.remove(j);
        System.out.println(hand.getCards());

        hand.add(c);
        System.out.println(hand.getCards());
        hand.remove(c);
        System.out.println(hand.getCards());
    }

}
