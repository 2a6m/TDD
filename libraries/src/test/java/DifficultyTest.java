package backend;

import org.junit.Before;
import org.junit.Test;

public class DifficultyTest {
    private Difficulty difficulty;

    @Before
    public void setUp() {
        difficulty = new Difficulty("easy");
    }

    @Test(expected = Exception.class)
    public void SetNameException() {
        int name = -1;

        difficulty.SetName(name);
    }
}
