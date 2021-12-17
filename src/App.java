import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        if (args.length > 0) {
            for (String input: args) {
                System.out.println("You have entered: " + input);
                System.out.println("The corresponding console representation is: ");
                displayConsoleRepresentation(ConsoleRepresentation.getConsoleRepresentation(Integer.parseInt(input)));
                System.out.println();
            }
        } else {
            final Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a number: ");

                final int number = sc.nextInt();
                System.out.println("You have entered: ");
                displayConsoleRepresentation(ConsoleRepresentation.getConsoleRepresentation(number));
                System.out.println();
            }
        }
    }

    private static void displayConsoleRepresentation(final String[] representation) {
        System.out.println(representation[0]);
        System.out.println(representation[1]);
        System.out.println(representation[2]);
    }
}
