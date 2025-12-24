import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class hangman {
    public static void main(String args[]) {
        try {
            Map<Integer, List<String>> words = new HashMap<>();
            File file = new File("dictionary.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    int len = line.length();
                    //adding length wise words to map
                    List<String> linkage = words.getOrDefault(len, new ArrayList<>());
                    linkage.add(line.toLowerCase());
                    words.put(len, linkage);
                }
            }
            sc.close();

            Scanner input = new Scanner(System.in);
            boolean playAgain = true;
            //while loop to play till user says not to
            while (playAgain) {
                //validatng number input
                int num = validatenumber.validate(input, "Enter your word length: ");
                //looping till there is a word of that length in dictionary file
                while (!words.containsKey(num)) {
                    System.out.println("No words of that length. Try again.");
                    num = validatenumber.validate(input, "Enter your word length: ");
                }
                //validating guess count
                int guesscount = validatenumber.validate(input, "Enter your number of wrong guesses: ");
                List<String> result = new ArrayList<>(words.get(num));

                StringBuilder currentPattern = new StringBuilder("_".repeat(num));
                Set<Character> guessedLetters = new HashSet<>();

                while (guesscount > 0) {
                    //spaced pattern just prints a space between the currentword pattern for user readability
                    System.out.println("\nCurrent word: " + spacedPattern(currentPattern.toString()));
                    System.out.println("Guesses left: " + guesscount);
                    System.out.println("Guessed letters: " + guessedLetters);

                    String userguessString = validatestring.validates(input, "Enter your letter guess: ");
                    char userguess = Character.toLowerCase(userguessString.charAt(0));
                    //checks if already in set
                    if (guessedLetters.contains(userguess)) {
                        System.out.println("You already guessed that letter. Try again.");
                        continue;
                    }
                    //if not adds it in set
                    guessedLetters.add(userguess);

                    //  Generate word families
                    Map<String, List<String>> families = maphelper.mapHelperFamilies(userguess, result);
                    List<String> largestFamily = maphelper.chooseLargestFamily(families);
                    String newPattern = maphelper.getPattern(largestFamily.get(0), userguess);

                    boolean revealed = patternrevealhelper.patternReveals(currentPattern.toString(), newPattern);
                    result = largestFamily;
                    // checks if already in the pattern
                    if (revealed) {
                        currentPattern = mergepatternhelper.mergePatterns(currentPattern.toString(), newPattern);
                        System.out.println("Good guess!");
                    } else {
                        guesscount--;
                        System.out.println("Sorry, that letter is not in the word.");
                    }

                    if (currentPattern.indexOf("_") == -1) {
                        System.out.println("\n You win! The word was: " + currentPattern);
                        break;
                    }
                }

                if (guesscount == 0) {
                    String hidden = result.get(new Random().nextInt(result.size()));
                    System.out.println("\n You lose! The word was: " + hidden);
                }

                System.out.print("\nPlay again? (y/n): ");
                String ans = input.nextLine().trim().toLowerCase();
                playAgain = ans.equals("y");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Dictionary file not found.");
        }
    }

    private static String spacedPattern(String s) {
        return s.replaceAll("", " ").trim();
    }
}
