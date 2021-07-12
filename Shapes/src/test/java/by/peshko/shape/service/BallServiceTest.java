package by.peshko.shape.service;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.Point;
import by.peshko.shape.service.impl.BallServiceImpl;
import by.peshko.shape.util.ShapeIdGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallServiceTest {

    @Test
    void calculateBallVolume() {
        BallService ballService = new BallServiceImpl();
        ShapeIdGenerator shapeIdGenerator = new ShapeIdGenerator();
        Ball ball = new Ball(shapeIdGenerator.generateId(), new Point(1.2, 15.1, -5.2), new Point(-5.1, 4.2, 0));
        double actual = ballService.calculateBallVolume(ball);
        double expected = 7939.738539675474;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateBallSurfaceArea() {
        BallService ballService = new BallServiceImpl();
        ShapeIdGenerator shapeIdGenerator = new ShapeIdGenerator();
        Ball ball = new Ball(shapeIdGenerator.generateId(), new Point(1.2, 15.1, -5.2), new Point(-5.1, 4.2, 0));
        double actual = ballService.calculateBallSurfaceArea(ball);
        double expected = 2331.5644037882003;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void touchCoordinatePlaneEqualTrue() {
        BallService ballService = new BallServiceImpl();
        ShapeIdGenerator shapeIdGenerator = new ShapeIdGenerator();
        Ball ball = new Ball(shapeIdGenerator.generateId(), new Point(1.5, 1.5, 0.5), new Point(3, 1.5, 0.5));
        boolean actual = ballService.touchCoordinatePlane(ball);
        Assertions.assertTrue(actual);
    }

    @Test
    void calculateRadius() {
        BallService ballService = new BallServiceImpl();
        ShapeIdGenerator shapeIdGenerator = new ShapeIdGenerator();
        Ball ball = new Ball(shapeIdGenerator.generateId(), new Point(1.2, 15.1, -5.2), new Point(-5.1, 4.2, 0));
        double actual = ballService.calculateRadius(ball);
        double expected = 13.621306838919677;
        Assertions.assertEquals(expected, actual);
    }
}
