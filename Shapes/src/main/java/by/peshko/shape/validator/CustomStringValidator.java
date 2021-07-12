package by.peshko.shape.validator;

public class CustomStringValidator {

    public static boolean isCorrectLine(String line, String doubleRegex) {
        return line.matches(doubleRegex);
    }
}
