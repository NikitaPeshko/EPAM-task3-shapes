package by.peshko.shape.repository;

import by.peshko.shape.entity.Ball;

import java.util.Comparator;
import java.util.List;

public interface BallRepository {

    boolean addBall(Ball ball);

    boolean removeBall(Ball ball);


    Ball getBall(int index);

    Ball setBall(int index, Ball ball);

    int size();

    List<Ball> getAll();

    List<Ball> query(BallSpecification specification);

    void sort(Comparator<? super Ball> comparator);

    boolean addAll(List<Ball> list);
}
