package by.peshko.shape.factory;

import by.peshko.shape.entity.Point;
import by.peshko.shape.entity.Shape;
import by.peshko.shape.exception.BallException;

public abstract class ShapeFactory {

    public abstract Shape create(int id, Point... points) throws BallException;
}
