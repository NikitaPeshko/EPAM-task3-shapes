package by.peshko.shape.service.impl;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.Point;
import by.peshko.shape.exception.BallException;
import by.peshko.shape.service.BallService;


public class BallServiceImpl implements BallService {

    @Override
    public Double calculateBallVolume(Ball ball) {
        return 4 / 3 * Math.PI * Math.pow(calculateDistance(ball.getCenter(), ball.getAtCircle()), 3);
    }

    @Override
    public Double calculateBallSurfaceArea(Ball ball) {
        return 4 * Math.PI * Math.pow(calculateDistance(ball.getCenter(), ball.getAtCircle()), 2);
    }

    @Override
    public boolean touchCoordinatePlane(Ball ball) {
        double radius = calculateDistance(ball.getCenter(), ball.getAtCircle());
        Point center = ball.getCenter();
        return Math.abs(center.getX()) - radius == 0 ||
                Math.abs(center.getY()) - radius == 0 ||
                Math.abs(center.getZ()) - radius == 0;
    }

    @Override
    public double calculateVolumeRatio(Ball ball, Point[] planePoints) throws BallException {
        if (planePoints.length != 2) {
            throw new BallException();
        }
        double radius = calculateDistance(ball.getCenter(), ball.getAtCircle());
        double radiusPoint1 = calculateDistance(ball.getCenter(), planePoints[0]);
        double radiusPoint2 = calculateDistance(ball.getCenter(), planePoints[1]);
        Point centerPlane;
        double chord;
        double height1;
        double height2;
        if (radiusPoint1 != radiusPoint2 || radiusPoint2 != radius) {
            throw new BallException();
        } else {
            centerPlane = new Point((planePoints[0].getX() + planePoints[1].getX()) / 2,
                    (planePoints[0].getY() - planePoints[1].getY()) / 2,
                    (planePoints[0].getZ() - planePoints[1].getZ()) / 2);
            chord = calculateDistance(ball.getCenter(), centerPlane);
            height1 = radius - chord;
            height2 = radius * 2 - height1;
        }
        return calculateBallSegmentVolume(height1, radius) / calculateBallSegmentVolume(height2, radius);
    }


    public double calculateRadius(Ball ball) {
        Point center = ball.getCenter();
        Point atCircle = ball.getAtCircle();
        return calculateDistance(center, atCircle);
    }

    public double calculateDistance(Point center, Point second) {
        return Math.abs(Math.sqrt(Math.pow(second.getX() - center.getX(), 2)
                + Math.pow(second.getY() - center.getY(), 2)
                + Math.pow(second.getZ() - center.getZ(), 2)));
    }

    private double calculateBallSegmentVolume(double height, double radius) {
        return height * height * (radius - (double) 1 / 3 * height);
    }


}
