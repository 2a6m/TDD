package backend;

import java.util.*;
/** Class Difficulty.
 *
 * Class to represent the difficulty of the game.
 */
public class Difficulty {

    /** name of te difficulty.
     *
     * @param name it represent the name of the difficulty.
     */
    private String name;

    /** levelcoin.
     *
     * @param levelcoin it represent the level of earning coin.
     */
    private int levelCoin;

    /** map listing the possibilities.
     *
     * @param coinConfiguration it link the name and the levelcoin.
     */
    private Map<String, Integer> coinConfiguration = new HashMap<String, Integer>() {
        {
            put("easy", 10);
            put("intermediate", 20);
            put("advanced", 30);
        }
    };

    /** Constructor.
     *
     * @param name      the name ofthe difficulty.
     */
    public Difficulty(String name) {
        this.name = name;
        this.levelCoin = coinConfiguration.get(name);
    }

    /** Gives the name of the difficulty.
     *
     * @return string the name of the difficulty.
     */
    public String GetName() {
        return this.name;
    }

    /** Gives coins corresponding to the difficulty chosen that can be added or removed from the player.
     *
     * @return int levelcoin.
     */
    public int GetLevelCoin() { return this.levelCoin; }

    /** Changes the name of the difficulty.
     *
     * @param  name      the new name of the difficulty.
     */
    public void SetName(String name) { this.name = name; }

    /** Removes coins of a player.
     *
     * @param  player   the player who spent his coins.
     */
    public void RetryCoins(Player player) {
        int currentCoins = player.GetCoins();
        int newCoins = currentCoins - levelCoin;
        player.SetCoins(newCoins);

    }

    /** Adds coins of a player.
     *
     * @param  player   the player who won his coins.
     */
    public void AddCoins(Player player) {
        int currentCoins = player.GetCoins();
        int newCoins = currentCoins + levelCoin;
        player.SetCoins(newCoins);
    }


}
