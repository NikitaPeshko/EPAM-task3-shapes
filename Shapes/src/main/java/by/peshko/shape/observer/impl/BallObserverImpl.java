package by.peshko.shape.observer.impl;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.BallParameter;
import by.peshko.shape.entity.Warehouse;
import by.peshko.shape.observer.BallEvent;
import by.peshko.shape.observer.BallObserver;
import by.peshko.shape.service.BallService;
import by.peshko.shape.service.impl.BallServiceImpl;

public class BallObserverImpl implements BallObserver {

    @Override
    public void updateParameters(BallEvent ballEvent) {
        Warehouse warehouse = Warehouse.getInstance();
        BallService ballService = new BallServiceImpl();
        Ball ball = ballEvent.getSource();
        double volume = ballService.calculateBallVolume(ball);
        double surfaceArea = ballService.calculateBallSurfaceArea(ball);
        double radius = ballService.calculateRadius(ball);
        BallParameter ballParameter = new BallParameter(volume, surfaceArea, radius);
        warehouse.set(ball.getId(), ballParameter);
    }
}
