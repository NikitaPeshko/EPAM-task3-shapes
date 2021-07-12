package by.peshko.shape.parser.impl;

import by.peshko.shape.parser.BallParser;
import by.peshko.shape.validator.BallValidator;
import by.peshko.shape.validator.CustomStringValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallParserImpl implements BallParser {
    private static final String INPUT_STRING_SPLIT_REGEX = "\\s";
    private static final String NUMBER_VALIDATE_REGEX = "^(-?\\d{1,4}\\.?\\d{0,4}\\s){5}-?\\d{1,4}\\.?\\d{0,4}$";

    @Override
    public List<double[]> parseStringList(List<String> lines) {
        List<double[]> figure = new ArrayList<>();
        double[] array;
        for (String line : lines) {
            if (CustomStringValidator.isCorrectLine(line, NUMBER_VALIDATE_REGEX)) {
                array = Arrays.stream(line.split(INPUT_STRING_SPLIT_REGEX)).mapToDouble(Double::parseDouble).toArray();
                if (BallValidator.isBall(array)) {
                    figure.add(array);
                }
            }
        }
        return figure;
    }
}
