package backend;

import org.json.JSONObject;
import javafx.util.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/** Class Game.
 *
 * class representing the carcteristics of the game.
 */
public class Game {
    /** Player informations.
     *
     * @param player represent the informations of the player.
     */
    private Player player;

    /** difficulty.
     *
     * @param difficulty object of type Difficulty representing the difficulty of the game.
     */
    private Difficulty difficulty;

    /** typeMystery represent the type of game.
     *
     * @param typeMystery object of type TypeMystery representing the type of game.
     */
    private TypeMystery typeMystery;

    /** mystery.
     *
     * @param mystery object of type Pair representing the object to find.
     */
    private Pair<String, List<String>> mystery;

    /** letterDisplay.
     *
     * @param letterDisplay object of type ArrayList representing letters to display.
     */
    private ArrayList<Character> letterDisplay;

    /** bonusList.
     *
     * @param bonusList object of type ArrayList representing all the bonus the user can use.
     */
    private ArrayList<TypeBonus> bonusList = new ArrayList<TypeBonus>();

    /** Constructor.
     *
     * @param difficulty set the doffoculty of the game.
     */
    public Game(Difficulty difficulty) { //Ajouter Player
        this.difficulty = difficulty;

        this.bonusList.add(new RemoveLetter());
    }

    /** To play an other gameMystery.
     */
    public void NextMystery() { typeMystery.NextMystery(this); }

    /** Modifies the letters to display through the interface.
     *
     * @param  letterDisplay   the new letters to display.
     */
    public void SetLetterDisplay(ArrayList<Character> letterDisplay) { this.letterDisplay = letterDisplay; }

    /** Get the letters to display through the interface.
     *
     * @return an ArrayList with the letters to display.
     */
    public ArrayList<Character> GetLetterDisplay() { return this.letterDisplay; }

    /** Modifies the type of mystery.
     *
     * @param  typeMystery   the new type of mystery.
     */
    public void SetTypeMystery(TypeMystery typeMystery) { this.typeMystery = typeMystery; }

    /** Modifies the Difficulty of the game.
     *
     * @param  difficulty      the new difficulty that the user has chosen.
     */
    public void SetDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }

    /** Gives the Difficulty of the game.
     *
     * @return an object Difficulty representing the difficulty of the current game.
     */
    public Difficulty GetDifficulty() { return this.difficulty; }

    /** Changes the mystery to display through the interface.
     *
     * @param  mystery      the new mystery to display (a map where the key is the response of the mystery and the value is the mystery).
     */
    public void SetMystery(Pair<String, List<String>> mystery) { this.mystery = mystery; }

    /** Gives the current mystery of the game.
     *
     * @return      a Pair  representing the mystery
     */
    public Pair<String, List<String>> GetMystery() { return mystery; }

    /** Gives the available bonuses.
     *
     * @return       a ArrayList of TypeBonus representing the available bonuses.
     */
    public ArrayList<TypeBonus> GetBonusList() { return bonusList; }

    /** Gives the current player who is playing.
     *
     * @return a Player object representing the current player.
     */
    public Player GetPlayer() { return player; }

    /** Connect and initialize a player.
     *
     * @param  pseudo   the pseudo of the player.
     * @param  password the password of the player.
     */
    public void Login(String pseudo, String password) {
        JSONObject playerData = CheckLogin(pseudo,password);

        if (playerData != null) {
            if (playerData.length() != 0) {
                Player player = new Player(pseudo);
                this.player = player;
                System.out.println(player);

                try {
                    int playerCoins = (int) playerData.get("coins");
                    System.out.println(playerCoins);
                    player.SetCoins(playerCoins);

                    System.out.print("Connection réussie");

                } catch (Exception e) {
                    System.out.print("set player failed");

                }
            } else {
                System.out.print("Connection échouée");
                throw new ArithmeticException("No input, pseudo not valable");
            }
        } else {
            throw new ArithmeticException("player data is null");
        }
    }


    /** Check the pseudo and the password of a player.
     *
     * @param  pseudo   the pseudo of the player.
     * @param  password the password of the player.
     * @return          a JSONObject representing the player's data.
     */
    private JSONObject CheckLogin(String pseudo, String password) {
        JSONObject objectNull = new JSONObject();

        if (pseudo.length() != 0 || password.length() != 0) {
            try {
                JSONObject db = Utils.ReadDatabase(Utils.url + "/../libraries/src/main/resources/playerDatabase.json");

                JSONObject playerData = db.getJSONObject(pseudo);
                String pass = (String) playerData.get("password");

                if (pass.equals(password)) {
                    return playerData;
                } else {
                    return objectNull;           //invalid password
                }

            } catch (Exception e) {
                return objectNull;               //invalid pseudo
            }
        } else {
            return objectNull;
        }
    }


    /** Update the json which represent the player's data.
     */
    public void Save() {
        try {
            JSONObject db = Utils.ReadDatabase(Utils.url + "/../libraries/src/main/resources/playerDatabase.json");
            JSONObject playerData = db.getJSONObject(player.GetPseudo());
            playerData.put("coins",player.GetCoins());

            try (FileWriter files = new FileWriter(Utils.url + "/../libraries/src/main/resources/playerDatabase.json"))
            {
                files.write(db.toString());
                System.out.println("\nSuccessfully updated json object to file !");
            }
        } catch (Exception e) {
            System.out.print(e);
        }

    }
}
