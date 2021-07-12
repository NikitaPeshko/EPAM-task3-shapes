package by.peshko.shape.comparator;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.BallParameter;
import by.peshko.shape.entity.Point;
import by.peshko.shape.entity.Warehouse;
import by.peshko.shape.repository.BallRepository;
import by.peshko.shape.repository.impl.BallRepositoryImpl;
import by.peshko.shape.service.BallService;
import by.peshko.shape.service.impl.BallServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class BallComparatorTest {

    @BeforeAll
    public static void init(){
        Warehouse warehouse = Warehouse.getInstance();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        BallService ballService = new BallServiceImpl();
        Ball ball1 = new Ball(1,new Point(5,4,2), new Point(4, 3, 5));
        Ball ball2 = new Ball(2,new Point(5,4,2), new Point(4, 3, 5));
        Ball ball3 = new Ball(3,new Point(2,4,5), new Point(4, 3, 5));

        ballRepository.addBall(ball1);
        ballRepository.addBall(ball2);
        ballRepository.addBall(ball3);

        double volume = ballService.calculateBallVolume(ball1);
        double surfaceArea = ballService.calculateBallSurfaceArea(ball1);
        double radius = ballService.calculateRadius(ball1);
        warehouse.set(ball1.getId(), new BallParameter(volume, surfaceArea, radius));

        volume = ballService.calculateBallVolume(ball2);
        surfaceArea = ballService.calculateBallSurfaceArea(ball2);
        radius = ballService.calculateRadius(ball2);
        warehouse.set(ball2.getId(), new BallParameter(volume, surfaceArea, radius));

        volume = ballService.calculateBallVolume(ball3);
        surfaceArea = ballService.calculateBallSurfaceArea(ball3);
        radius = ballService.calculateRadius(ball3);
        warehouse.set(ball3.getId(), new BallParameter(volume, surfaceArea, radius));
    }

    @Test
    void ballCenterComparatorCompareEqualZero(){
        BallCenterComparator ballCenterComparator = new BallCenterComparator();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        Ball ball1 = ballRepository.getBall(0);
        Ball ball2 = ballRepository.getBall(1);
        int expected = 0;
        Assertions.assertEquals(expected, ballCenterComparator.compare(ball1, ball2));
    }

    @Test
    void ballCenterComparatorCompareEqualMinus1(){
        BallCenterComparator ballCenterComparator = new BallCenterComparator();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        Ball ball1 = ballRepository.getBall(0);
        Ball ball3 = ballRepository.getBall(2);
        int expected = -1;
        Assertions.assertEquals(expected, ballCenterComparator.compare(ball1, ball3));
    }
    @Test
    void ballRadiusComparatorCompareEqualZero(){
        BallRadiusComparator ballRadiusComparator = new BallRadiusComparator();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        Ball ball1 = ballRepository.getBall(0);
        Ball ball2 = ballRepository.getBall(1);
        int expected = 0;
        Assertions.assertEquals(expected, ballRadiusComparator.compare(ball1, ball2));
    }

    @Test
    void ballRadiusComparatorCompareEqual1(){
        BallRadiusComparator ballRadiusComparator = new BallRadiusComparator();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        Ball ball2 = ballRepository.getBall(1);
        Ball ball3 = ballRepository.getBall(2);
        int expected = 1;
        Assertions.assertEquals(expected, ballRadiusComparator.compare(ball2, ball3));
    }

    @Test
    void ballSurfaceComparatorCompareEqualZero(){
        BallSurfaceAreaComparator ballSurfaceAreaComparator = new BallSurfaceAreaComparator();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        Ball ball1 = ballRepository.getBall(0);
        Ball ball2 = ballRepository.getBall(1);
        int expected = 0;
        Assertions.assertEquals(expected, ballSurfaceAreaComparator.compare(ball1, ball2));
    }

    @Test
    void ballSurfaceComparatorCompareEqualMinus1(){
        BallSurfaceAreaComparator ballSurfaceAreaComparator = new BallSurfaceAreaComparator();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        Ball ball1 = ballRepository.getBall(0);
        Ball ball3 = ballRepository.getBall(2);
        int expected = -1;
        Assertions.assertEquals(expected, ballSurfaceAreaComparator.compare(ball3, ball1));
    }

    @Test
    void ballVolumeComparatorCompareEqualZero(){
        BallVolumeComparator ballVolumeComparator = new BallVolumeComparator();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        Ball ball1 = ballRepository.getBall(0);
        Ball ball2 = ballRepository.getBall(1);
        int expected = 0;
        Assertions.assertEquals(expected, ballVolumeComparator.compare(ball1, ball2));
    }
}
