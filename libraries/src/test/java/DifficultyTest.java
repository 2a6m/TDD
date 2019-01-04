package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DifficultyTest {
    private Difficulty difficulty;
    Difficulty testDifficulty;

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

    // ERROR
    /*
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
