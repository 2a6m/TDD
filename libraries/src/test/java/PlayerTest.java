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

    // test coins below zero
    @Test
    public void MoneyBelowZero() {
        int coin = -1;
        player.SetCoins(coin);

        assertEquals(0, player.GetCoins());
    }
}
