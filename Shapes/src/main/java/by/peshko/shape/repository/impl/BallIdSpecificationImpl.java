package by.peshko.shape.repository.impl;

import by.peshko.shape.entity.Ball;
import by.peshko.shape.repository.BallSpecification;

public class BallIdSpecificationImpl implements BallSpecification {
    private final int id;

    public BallIdSpecificationImpl(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(Ball ball) {
        return ball.getId() == id;
    }
}
