package by.peshko.shape.service;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.Point;
import by.peshko.shape.exception.BallException;

public interface BallService {

    Double calculateBallVolume(Ball ball);

    Double calculateBallSurfaceArea(Ball ball);

    boolean touchCoordinatePlane(Ball ball);

    double calculateVolumeRatio(Ball ball, Point[] points) throws BallException;

    double calculateRadius(Ball ball);

    public double calculateDistance(Point center, Point second);
}
