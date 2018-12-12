package backend;

import java.util.ArrayList;
import java.util.Random;

/**
* Class to implement the bonus to remove a letter.
*/
public class RemoveLetter extends TypeBonus {

    /**
    * RemoveLetter constructor.
    */
    public RemoveLetter() { }
    
    /**
    * Apply a Bonus.
    *
    * @param game ?
    */
    @Override
    public void ApplyBonus(Game game) {
        if (Utils.CheckCoins(game.GetPlayer(), game.GetDifficulty())) {
            game.GetDifficulty().RetryCoins(game.GetPlayer());
            Random random = new Random();

            String word = game.GetMystery().getKey();
            ArrayList<Character> displayLetters = game.GetLetterDisplay();

            int i = 0;
            while (i < 3) {
                int randInt = random.nextInt(displayLetters.size());
                char randLetter = displayLetters.get(randInt);

                if (randLetter != ' ' && word.indexOf(randLetter) == -1) {
                    displayLetters.remove(randInt);
                    displayLetters.add(' ');

                    i++;
                }
            }

            used = false;
            game.SetLetterDisplay(Utils.MixArray(displayLetters));
        } else {
            System.out.println("Pas assez de pieces");
        }
    }
}
