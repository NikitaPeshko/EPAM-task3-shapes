package by.peshko.shape.parser;

import by.peshko.shape.parser.impl.BallParserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BallParserTest {

    @Test
    void parseStringListEqualArray(){
        BallParser parser = new BallParserImpl();
        List<String> lines = new ArrayList<>();
        lines.add("5.1 25 12.1 -5 5 -19");
        lines.add("7.1 24.5 125.1 10 -12 1.2");
        List<double[]> points = parser.parseStringList(lines);
        List<double[]> expected = new ArrayList<>();
        expected.add(new double[]{5.1, 25, 12.1, -5, 5, -19});
        expected.add(new double[]{7.1, 24.5, 125.1, 10, -12, 1.2});
        Assertions.assertAll("points",
                () -> Assertions.assertArrayEquals(points.get(0), expected.get(0)),
                () -> Assertions.assertArrayEquals(points.get(1), expected.get(1))
        );
    }
}
