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

        assertTrue("Exception not raised login empty", thrown);
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
    @Test
    public void CheckLoginNull() {
        boolean thrown = false;

        try {
            game.Login("Alberto", "Alvarez");
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue("Exception not raised check login null", thrown);
    }

    // test empty imputand in db
    @Test
    public void LoginAllEmpty(){
        boolean thrown = false;

        try {
            game.Login("", "");
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue("Exception not raised login all empty", thrown);
    }

    // test db with minus coins
    @Test
    public void LoginAllEmpty(){
        boolean thrown = false;

        try {
            game.Login("test-minus", "test");
        } catch (Exception e) {
            thrown = true;
        }

        assertTrue("Exception not raised login all empty", thrown);
    }


}
