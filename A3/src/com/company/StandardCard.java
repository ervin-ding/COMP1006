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

    //Converts given suit into it's int value in order to compare them.
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
        // returns the value of the index when it finds a matching value.
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

    // compares current card and card o to determine which is greater. Suit first then rank.
    @Override
    public int compareTo(Card o) {
        int rankofFirstCard = this.getRank();
        int rankofSecondCard = o.getRank();
        int suitofFirstCard = getSuitInt(this.getSuit());
        int suitofSecondCard = getSuitInt(o.getSuit());
        int value = 0;

        if (suitofFirstCard > suitofSecondCard){
            value = 1;
        }
        else if (suitofFirstCard < suitofSecondCard){
            value = -1;
        }
        else if (suitofFirstCard == suitofSecondCard) {
            if (rankofFirstCard > rankofSecondCard) {
                value = 1;
            } else if (rankofFirstCard < rankofSecondCard) {
                value = -1;
            } else {
                value = 0;
            }
        }
        return value;
    }
}
