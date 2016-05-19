package gssports.ultimatecardsfootball.activity.stadium;

import gssports.ultimatecardsfootball.database.model.Card;

/**
 * Created by manuel.molero on 19/05/2016.
 */
public class StadiumUtil {

    public static boolean llevaBalon(Card c){
        return c.isTieneBalon();
    }

    public static boolean hayCartaEnPosicion(Card local, Card[] cardsEspejo){
        boolean hayCarta = false;
        String posLocal = String.valueOf(local.getPosicionActual());
        int rowLocal = Integer.valueOf(posLocal.substring(0, 1)).intValue();
        int colLocal = Integer.valueOf(posLocal.substring(1, 2)).intValue();

        for (Card card : cardsEspejo) {
            String posEspejo = String.valueOf(card.getPosicionActual());
            int rowEspejo = Integer.valueOf(posEspejo.substring(0, 1)).intValue();
            int colEspejo = Integer.valueOf(posEspejo.substring(1, 2)).intValue();

            if (rowLocal == rowEspejo && colLocal == colEspejo) {
                hayCarta = true;
                break;
            }
        }
        return hayCarta;
    }
}
