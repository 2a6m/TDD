/**
 * Package for the backend of th eapplication.
 */
package backend;

/**
* This class is used to set player characteristics.
*/
public class Player {

    /**
    * Pseudo of the player.
    */
    private String pseudo;

    /**
    * Amount of coins of the player.
    */
    private int coins;

    /**
    * Player constructor.
    *
    * @param pseudo peudo of the player.
    */
    public Player(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
    * Getter : pseudo of the player.
    *
    * @return the pseudo of the player
    */
    public String GetPseudo() {
        return pseudo;
    }

    /**
    * Setter : pseudo of the player.
    *
    * @param pseudo new pseudo for the player
    */
    public void SetPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
    * Getter : amount of coins of the player.
    *
    * @return the amount of coins of the player
    */
    public int GetCoins() {
        return coins;
    }

    /**
    * Setter : amount of coins of the player.
    *
    * @param coins the amount of coins of the player
    */
    public void SetCoins(int coins) {
        this.coins = coins;
    }
}
