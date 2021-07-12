package by.peshko.shape.main;

import by.peshko.shape.comparator.BallVolumeComparator;
import by.peshko.shape.entity.Ball;
import by.peshko.shape.entity.BallParameter;
import by.peshko.shape.entity.Point;
import by.peshko.shape.entity.Warehouse;
import by.peshko.shape.exception.BallException;
import by.peshko.shape.factory.BallFactory;
import by.peshko.shape.factory.PointFactory;
import by.peshko.shape.observer.BallObserver;
import by.peshko.shape.observer.impl.BallObserverImpl;
import by.peshko.shape.parser.BallParser;
import by.peshko.shape.parser.impl.BallParserImpl;
import by.peshko.shape.reader.CustomFileReader;
import by.peshko.shape.reader.impl.CustomFileReaderImpl;
import by.peshko.shape.repository.BallRepository;
import by.peshko.shape.repository.BallSpecification;
import by.peshko.shape.repository.impl.BallIdSpecificationImpl;
import by.peshko.shape.repository.impl.BallRepositoryImpl;
import by.peshko.shape.service.BallService;
import by.peshko.shape.service.impl.BallServiceImpl;
import by.peshko.shape.util.ShapeIdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws BallException {
        Logger logger = LogManager.getLogger();
        String filePath = "";
        CustomFileReader customFileReader = new CustomFileReaderImpl();
        BallParser ballParser = new BallParserImpl();
        BallRepository ballRepository = BallRepositoryImpl.getInstance();
        Warehouse warehouse = Warehouse.getInstance();
        BallObserver observer = new BallObserverImpl();
        BallService ballService = new BallServiceImpl();
        BallFactory ballFactory = new BallFactory();
        PointFactory pointFactory = new PointFactory();
        ShapeIdGenerator shapeIdGenerator = new ShapeIdGenerator();

        List<String> lines = customFileReader.readFile(filePath);
        List<double[]> ballPoints = ballParser.parseStringList(lines);
        List<Ball> balls = new ArrayList<>();
        for (double[] points : ballPoints) {
            int id = shapeIdGenerator.generateId();
            Point[] pointsList = pointFactory.createTwoPoints(points);
            balls.add(ballFactory.create(id, pointsList));
        }

        for (Ball value : balls) {
            double volume = ballService.calculateBallVolume(value);
            double radius = ballService.calculateRadius(value);
            double surfaceArea = ballService.calculateBallSurfaceArea(value);
            warehouse.set(value.getId(), new BallParameter(volume, surfaceArea, radius));
        }

        ballRepository.addAll(balls);
        logger.info("initial parameters");
        for (int i = 1; i <= ballRepository.size(); i++) {
            logger.info("Id: " + i + " " + warehouse.get(i).toString());
        }

        ballRepository.getAll().forEach(ball -> ball.attach(observer));

        for (int i = 0; i < ballRepository.size(); i++) {
            ballRepository.getBall(i).setAtCircle(new Point(i - 1.5, i, i + 2.5));
        }

        logger.info("recalculated parameters");
        for (int i = 1; i <= ballRepository.size(); i++) {
            logger.info("Id: " + i + " " + warehouse.get(i).toString());
        }
        int id = 1;
        BallSpecification ballSpecification = new BallIdSpecificationImpl(id);
        List<Ball> result = ballRepository.query(ballSpecification);
        logger.info("balls where id = " + id);
        result.forEach(logger::info);
        ballRepository.sort(new BallVolumeComparator());
        logger.info("balls sorted by volume");
        ballRepository.getAll().forEach(logger::info);

    }
}
