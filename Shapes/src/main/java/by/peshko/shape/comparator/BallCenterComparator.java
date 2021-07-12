package by.peshko.shape.comparator;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.Point;
import by.peshko.shape.service.BallService;
import by.peshko.shape.service.impl.BallServiceImpl;

import java.util.Comparator;

public class BallCenterComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball ball1, Ball ball2) {
        Point centerBall1 = ball1.getCenter();
        Point centerBall2 = ball2.getCenter();
        Point zero = new Point(0, 0, 0);
        BallService ballService = new BallServiceImpl();
        double vector1 = ballService.calculateDistance(centerBall1, zero);
        double vector2 = ballService.calculateDistance(centerBall2, zero);
        return Double.compare(vector1, vector2);
    }
}
