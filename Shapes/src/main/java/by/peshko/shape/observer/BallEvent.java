package by.peshko.shape.observer;

import by.peshko.shape.entity.Ball;

import java.util.EventObject;

public class BallEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public BallEvent(Ball source) {
        super(source);
    }

    @Override
    public Ball getSource() {
        return (Ball) super.getSource();
    }
}