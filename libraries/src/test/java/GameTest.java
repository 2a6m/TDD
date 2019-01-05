package backend;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Difficulty difficulty;
    private Player player;
    private Game game;

    @Before
    public void setUp() {
        difficulty = new Difficulty("easy");
        player = new Player("test");
        game = new Game(difficulty);
    }

    // test pseudo empty
    @Test
    public void LoginEmpty() {
        boolean thrown = false;

        try {
            game.Login("", "pwd_test");
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue("Exception not raised", thrown);
    }

    // test save
    @Test
    public void Savetest() {
        boolean thrown = true;

        try {
            game.Save();
        } catch (Exception e) {
            thrown = false;
        }

        assertTrue(thrown);
    }

    // test Login player not in db
    public void CheckLoginNull() {
        boolean thrown = false;

        try {
            game.Login("Alberto", "Alvarez");
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue("Exception not raised", thrown);
    }

}
