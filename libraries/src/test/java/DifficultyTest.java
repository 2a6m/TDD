package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DifficultyTest {
    private Difficulty difficulty;

    @Before
    public void setUp() {
        difficulty = new Difficulty("easy");
        player = new Player("test");
    }
    /*
    @Test(expected = Exception.class)
    public void SetNameException() throws Exception {
        int name = -1;

        difficulty.SetName(name);
    }
    */

    // test type of difficulty not in the Map coinConfigurator
    @test
    public void SetDIfficultyNameException() {
        private Difficulty testDifficulty;
        boolean thrown = false;

        try {
            testDifficulty = new Difficulty("test");
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue("Exception not raised", thrown);
    }

    // ERROR
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
}
