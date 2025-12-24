import java.util.*;

public class validatenumber {
    public static int validate(Scanner input, String prompt) {
        int number = -1;
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                number = input.nextInt();
                input.nextLine(); // consume newline
                break;
            } else {
                System.out.println("Invalid input, please enter a number.");
                input.nextLine(); // clear input
            }
        }
        return number;
    }
}
