package by.peshko.shape.factory;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.Point;
import by.peshko.shape.exception.BallException;

public class BallFactory extends ShapeFactory {
    @Override
    public Ball create(int id, Point[] points) throws BallException {
        if (points.length != 2) {
            throw new BallException();
        }
        Point center = points[0];
        Point atCircle = points[1];
        return new Ball(id, center, atCircle);
    }
}
