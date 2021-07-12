package by.peshko.shape.repository.impl;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.BallParameter;
import by.peshko.shape.entity.Warehouse;
import by.peshko.shape.exception.BallException;
import by.peshko.shape.repository.BallSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BallSurfaceAreaSpecificationImpl implements BallSpecification {
    private static final String NO_ID = "Can't get BallParameter with such id";
    private final double fromArea;
    private final double toArea;
    Logger logger = LogManager.getLogger();

    public BallSurfaceAreaSpecificationImpl(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specify(Ball ball) {
        Warehouse warehouse = Warehouse.getInstance();
        try {
            BallParameter ballParameter = warehouse.get(ball.getId());
            double surfaceArea = ballParameter.getSurfaceArea();
            return (fromArea <= surfaceArea) && (surfaceArea >= toArea);
        } catch (BallException e) {
            logger.error(NO_ID, e);
        }
        return false;
    }
}
