import java.util.Scanner;

/**
 * This class lets the program read different data types from user input.
 * It ensures that all input is taken as a line and then parsed.
 */
public class InputScanner {
    private final Scanner input;

    /**
     * Contructor for the InputScanner class.
     *
     * @param input user input
     */
    public InputScanner(Scanner input) {
        this.input = input;
    }

    /**
     * Reads the next line of input.
     *
     * @return String representation of the next line of input
     */
    public String nextLine() {
        return input.nextLine();
    }

    /**
     * Reads the next line of input and parses it as an int.
     *
     * @return the next line of input parsed as an int.
     */
    public int nextIntLine() {
        return Integer.parseInt(input.nextLine());
    }

}
