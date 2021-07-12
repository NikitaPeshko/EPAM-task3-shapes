package by.peshko.shape.repository.impl;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.BallParameter;
import by.peshko.shape.entity.Warehouse;
import by.peshko.shape.exception.BallException;
import by.peshko.shape.repository.BallSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallVolumeSpecificationImpl implements BallSpecification {
    private static final String NO_ID = "Can't get BallParameter with such id";
    private final double fromVolume;
    private final double toVolume;
    Logger logger = LogManager.getLogger();

    public BallVolumeSpecificationImpl(double fromVolume, double toVolume) {
        this.fromVolume = fromVolume;
        this.toVolume = toVolume;
    }

    @Override
    public boolean specify(Ball ball) {
        Warehouse warehouse = Warehouse.getInstance();
        try {
            BallParameter ballParameter = warehouse.get(ball.getId());
            double area = ballParameter.getVolume();
            return (area >= fromVolume) && (area <= toVolume);
        } catch (BallException e) {
            logger.error(NO_ID, e);
        }
        return false;
    }
}
