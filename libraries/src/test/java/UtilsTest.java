package backend;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {
    Player low;
    Player full;
    Difficulty difficulty;
    ArrayList<Character> array;

    @Before
    public void SetUp() {
        low = new Player("testlow");
        low.SetCoins(5);
        full = new Player("testfull");
        full.SetCoins(666);
        difficulty = new Difficulty("easy");
        array = new ArrayList<Character>();

    }

    // test array empty
    @Test
    public void MixArrayEmpty() {
        thrown = true;

        try {
            MixArrayEmpty(array);
        } catch (Exception e) {
            thrown = false;
        }

        assertTrue("Exception has raised array empty", thrown);
    }

    // test check Coins
    @Test
    public void CheckCoinsTest() {
        assertFalse(CheckCoins(low, difficulty));
        assertTrue(CheckCoins(full, difficulty));
    }
}
