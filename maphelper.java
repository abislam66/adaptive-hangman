import java.util.*;

public class maphelper {

    //  1. Build families of words based on guessed letter patterns
    public static Map<String, List<String>> mapHelperFamilies(char guessedLetter, List<String> resultOfGuessedWord) {
        Map<String, List<String>> words = new HashMap<>();

        for (String word : resultOfGuessedWord) {
            // Sends each word and the guessed letter by the user to getpattern method
            String patternofpossibleword = getPattern(word, guessedLetter);
            //pattern of possible words contains each pattern of each word each is then used to create map of that certain pattern
            List<String> wordList = words.getOrDefault(patternofpossibleword, new ArrayList<>());
            wordList.add(word);
            words.put(patternofpossibleword, wordList);
        }

        return words;
    }

    // 2. Choose the largest family (pattern with most words)
    public static List<String> chooseLargestFamily(Map<String, List<String>> families) {
        int highest = -1;
        List<String> highestwords = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : families.entrySet()) {
            if (entry.getValue().size() > highest) {
                highest = entry.getValue().size();
                highestwords = entry.getValue();
            }
        }

        return highestwords;
    }

    //  3. Get the pattern string for one word based on guessed letter
    public static String getPattern(String word, char guessedLetter) {
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(guessedLetter)) {
                pattern.append(guessedLetter);
            } else {
                pattern.append('_');
            }
        }
        return pattern.toString();
    }
}
