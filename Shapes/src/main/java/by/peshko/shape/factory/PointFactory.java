package by.peshko.shape.factory;

import by.peshko.shape.entity.Point;
import by.peshko.shape.exception.BallException;

public class PointFactory {

    public Point create(double... params) throws BallException {
        if (params.length != 3) {
            throw new BallException();
        }
        return new Point(params[0], params[1], params[2]);
    }

    public Point[] createTwoPoints(double[] params) throws BallException {
        if (params.length != 6) {
            throw new BallException();
        }
        Point point1 = new Point(params[0], params[1], params[2]);
        Point point2 = new Point(params[3], params[4], params[5]);
        return new Point[]{point1, point2};
    }
}
