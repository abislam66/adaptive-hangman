import java.util.*;

public class findword {
    public static wordinfo findword(int guesscount, char userguess, List<String> result) {
        List<String> newresult = new ArrayList<>();

        // Keep words that contain the guessed letter
        for (String word : result) {
            if (word.toLowerCase().indexOf(Character.toLowerCase(userguess)) != -1) {
                newresult.add(word);
            }
        }

        // If no matches, guess was wrong
        if (newresult.isEmpty()) {
            guesscount--;
            newresult = result;
        }

        wordinfo roundresult = new wordinfo(newresult, guesscount);
        return roundresult;
    }
}
