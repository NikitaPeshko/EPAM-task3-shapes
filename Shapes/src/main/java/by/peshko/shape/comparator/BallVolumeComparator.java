package by.peshko.shape.comparator;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.BallParameter;
import by.peshko.shape.entity.Warehouse;
import by.peshko.shape.exception.BallException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public class BallVolumeComparator implements Comparator<Ball> {
    private static final String NO_ID = "Can't get BallParameter with such id";
    Logger logger = LogManager.getLogger();

    @Override
    public int compare(Ball ball1, Ball ball2) {
        Warehouse warehouse = Warehouse.getInstance();
        try {
            BallParameter ballParameter1 = warehouse.get(ball1.getId());
            BallParameter ballParameter2 = warehouse.get(ball2.getId());
            double volumeBall1 = ballParameter1.getVolume();
            double volumeBall2 = ballParameter2.getVolume();
            return Double.compare(volumeBall1, volumeBall2);
        } catch (BallException e) {
            logger.error(NO_ID, e);
        }
        return -1;
    }
}
