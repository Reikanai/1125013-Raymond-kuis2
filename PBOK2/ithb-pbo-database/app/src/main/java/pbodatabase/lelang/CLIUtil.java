package pbodatabase.lelang;

import java.util.Scanner;

public class CLIUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) throws EmptyInputException {
        System.out.print(prompt);
        String input = scanner.nextLine();
        if (input.trim().isEmpty()) {
            throw new EmptyInputException("Input ga boleh kosong.");
        }
        return input;
    }

    public static int getInt(String prompt) throws EmptyInputException, InvalidNumberException {
        String input = getString(prompt);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("tolong input angka bulat.");
        }
    }

    public static double getDouble(String prompt) throws EmptyInputException, InvalidNumberException {
        String input = getString(prompt);
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException("input harus angka / desimal.");
        }
    }
}