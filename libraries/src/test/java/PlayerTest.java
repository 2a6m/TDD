package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
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

    @Test
    public void MoneyBelowZero() {
        int coin = -1;
        player.setCoins(coin);

        assertEquals(0, player.GetCoins());
    }
}
