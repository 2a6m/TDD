package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DifficultyTest {
    private Difficulty difficulty;

    @Before
    public void setUp() {
        difficulty = new Difficulty("easy");
    }
    /*
    @Test(expected = Exception.class)
    public void SetNameException() throws Exception {
        int name = -1;

        difficulty.SetName(name);
    }
    */

    @Test
    public void SetNameException() {
        int name = -1;

        try {
            difficulty.SetName(name);
            boolean thrown = false;
        } catch(Exception e) {
            boolean thrown = true;
        }

        assert(thrown);
    }
}
