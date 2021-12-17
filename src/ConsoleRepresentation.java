import java.util.LinkedList;
import java.util.List;

public enum ConsoleRepresentation {
    ZERO(" _ ", "| |", "|_|"),
    ONE("   ", "  |", "  |"),
    TWO(" _ ", " _|", "|_ "),
    THREE(" _ ", " _|", " _|"),
    FOUR("   ", "|_|", "  |"),
    FIVE(" _ ", "|_ ", " _|"),
    SIX(" _ ", "|_ ", "|_|"),
    SEVEN(" _ ", "  |", "  |"),
    EIGHT(" _ ", "|_|", "|_|"),
    NINE(" _ ", "|_|", " _|"),
    MINUS("  ", "_ ", "  ");

    private final String topLine, middleLine, bottomLine;

    ConsoleRepresentation(String topLine, String middleLine, String bottomLine) {
        this.topLine = topLine;
        this.middleLine = middleLine;
        this.bottomLine = bottomLine;
    }

    public static String[] getConsoleRepresentation(final int number) {
        final List<Integer> digits = new LinkedList<>();
        int remaining = number;

        if (remaining == 0) digits.add(0);
        else while (remaining != 0) {
            digits.add(0, Math.abs(remaining % 10));
            remaining = remaining / 10;
        }

        final StringBuilder topBuilder = new StringBuilder(), middleBuilder = new StringBuilder(), bottomBuilder = new StringBuilder();

        // Handle the sign for negative numbers.
        if (number < 0) {
            topBuilder.append(MINUS.topLine);
            middleBuilder.append(MINUS.middleLine);
            bottomBuilder.append(MINUS.bottomLine);
        }

        for (Integer digit: digits) {
            final ConsoleRepresentation representation = ConsoleRepresentation.values()[digit];
            topBuilder.append(representation.topLine);
            middleBuilder.append(representation.middleLine);
            bottomBuilder.append(representation.bottomLine);
        }

        return new String[]{topBuilder.toString(), middleBuilder.toString(), bottomBuilder.toString()};
    }
}
