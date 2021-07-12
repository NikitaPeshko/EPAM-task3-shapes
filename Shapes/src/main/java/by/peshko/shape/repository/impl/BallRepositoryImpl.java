package by.peshko.shape.repository.impl;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.repository.BallRepository;
import by.peshko.shape.repository.BallSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BallRepositoryImpl implements BallRepository {
    private final List<Ball> balls = new ArrayList<>();
    private static final BallRepository BALL_REPOSITORY = new BallRepositoryImpl();

    private BallRepositoryImpl() {
    }

    public static BallRepository getInstance() {
        return BALL_REPOSITORY;
    }

    @Override
    public boolean addBall(Ball ball) {
        return balls.add(new Ball(ball.getId(), ball.getCenter(), ball.getAtCircle()));
    }

    @Override
    public boolean removeBall(Ball ball) {
        return balls.remove(ball);
    }

    @Override
    public Ball getBall(int index) {
        return balls.get(index);
    }

    @Override
    public Ball setBall(int index, Ball ball) {
        return balls.set(index, ball);
    }

    @Override
    public int size() {
        return balls.size();
    }

    public boolean addAll(List<Ball> balls) {
        return this.balls.addAll(List.copyOf(balls));
    }

    public List<Ball> getAll() {
        return List.copyOf(this.balls);
    }

    @Override
    public List<Ball> query(BallSpecification specification) {
        return balls.stream().filter(specification::specify).collect(Collectors.toList());
    }

    @Override
    public void sort(Comparator<? super Ball> comparator) {
        balls.sort(comparator);
    }

}
