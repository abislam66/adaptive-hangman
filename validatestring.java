import java.util.*;
//checks  validity of string
public class validatestring {
    public static String validates(Scanner input, String prompt) {
        String value = "";
        while (true) {
            System.out.print(prompt);
            value = input.nextLine().trim();
            if (value.length() == 1 && Character.isLetter(value.charAt(0))) {
                break;
            } else {
                System.out.println("Please enter a single letter only.");
            }
        }
        return value;
    }
}
