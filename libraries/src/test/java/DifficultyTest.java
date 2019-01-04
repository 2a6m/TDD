package backend;

import org.junit.Before;
import org.junit.Test;

public class DifficultyTest {
    private Difficulty difficulty;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        difficulty = new Difficulty("easy");
    }

    @Test
    public void SetNameException() throws Exception {
        int name = -1;

        thrown.expect(Exception.class);
        difficulty.SetName(name);
    }
}
