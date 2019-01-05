package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DifficultyTest {
    private Difficulty difficulty;
    private Difficulty testDifficulty;
    private Player player;

    @Before
    public void setUp() {
        difficulty = new Difficulty("easy");
        player = new Player("test");
    }

    // test type of difficulty not in the Map coinConfigurator
    @Test
    public void SetDIfficultyNameException() {
        boolean thrown = false;

        try {
            testDifficulty = new Difficulty("test");
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue("Exception not raised", thrown);
    }

    // raise exception when not enough money
    @Test
    public void CoinsGameException() {
        int start = 0;
        int end = start - 10;

        player.SetCoins(start);
        difficulty = new Difficulty("easy");
        boolean thrown = false;

        try {
            difficulty.RetryCoins(player);
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue(thrown);
    }

    @Test
    public void CoinsGameGet() {
        int start = 0;
        int end = start + 10:

        player.SetCoins(start);
        difficulty = new Difficulty("easy");

        difficulty.AddCoins(player);

        assertEquals(end, player.GetCoins());
    }

    // ERROR
    /*
    // test input with different type from wanted
    @Test
    public void SetNameException() {
        int name = -1;
        boolean thrown = false;

        try {
            // error but don't throw exception ?
            difficulty.SetName(name);
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue("Exception not raised", thrown);
    }
    */
}
