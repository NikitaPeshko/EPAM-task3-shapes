package by.peshko.shape.comparator;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.BallParameter;
import by.peshko.shape.entity.Warehouse;
import by.peshko.shape.exception.BallException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class BallSurfaceAreaComparator implements Comparator<Ball> {
    private static final Logger logger = LogManager.getLogger();
    private static final String NO_ID = "Can't get BallParameter with such id";

    @Override
    public int compare(Ball ball1, Ball ball2) {
        Warehouse warehouse = Warehouse.getInstance();
        try {
            BallParameter ballParameter1 = warehouse.get(ball1.getId());
            BallParameter ballParameter2 = warehouse.get(ball2.getId());
            double surfaceAreaBall1 = ballParameter1.getSurfaceArea();
            double surfaceAreaBall2 = ballParameter2.getSurfaceArea();
            return Double.compare(surfaceAreaBall1, surfaceAreaBall2);
        } catch (BallException e) {
            logger.error(NO_ID, e);
        }
        return -1;
    }
}
