import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private void displayConsoleRepresentation(final String[] representation) {
        System.out.println(representation[0]);
        System.out.println(representation[1]);
        System.out.print(representation[2]);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void test_123456789() {
        displayConsoleRepresentation(ConsoleRepresentation.getConsoleRepresentation(123_456_789));
        final String expectedResult =
                "    _  _     _  _  _  _  _ \r\n" +
                "  | _| _||_||_ |_   ||_||_|\r\n" +
                "  ||_  _|  | _||_|  ||_| _|";
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void test_1234567890() {
        displayConsoleRepresentation(ConsoleRepresentation.getConsoleRepresentation(123_456_789_0));
        final String expectedResult =
                "    _  _     _  _  _  _  _  _ \r\n" +
                "  | _| _||_||_ |_   ||_||_|| |\r\n" +
                "  ||_  _|  | _||_|  ||_| _||_|";
        assertEquals(expectedResult, outContent.toString());
    }

    @Test
    public void test_negative_12() {
        displayConsoleRepresentation(ConsoleRepresentation.getConsoleRepresentation(-12));
        final String expectedResult =
                "      _ \r\n" +
                "_   | _|\r\n" +
                "    ||_ ";
        assertEquals(expectedResult, outContent.toString());
    }
}
