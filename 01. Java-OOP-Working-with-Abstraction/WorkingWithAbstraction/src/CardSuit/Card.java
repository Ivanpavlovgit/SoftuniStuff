package CardSuit;

public class Card {
    private String rank;
    private String suit;
    private int power;

    public Card (String rank,String suit) {
        this.rank = rank;
        this.suit = suit;
        this.power = CardRank.valueOf (rank).getPower () + CardSuits.valueOf (suit).getPower ();
    }

    @Override
    public String toString () {
        return String.format ("Card name: %s of %s; Card power: %d",this.rank,this.suit,this.power);
    }
}
