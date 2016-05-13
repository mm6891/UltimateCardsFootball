package gssports.ultimatecardsfootball.database.model;
package gssports.ultimatecardsfootball.database.model.Card;

/**
 * Created by manuel.molero on 13/05/2016.
 */
public class Player {

    int _id;
	String nickPlayer;
	Card[] cards;
	
	 public String getNickPlayer() {
        return nickPlayer;
    }

    public void setNickPlayer(String nickPlayer) {
        this.nickPlayer = nickPlayer;
    }

	public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }				

	public Player(){
	}	
	
}
