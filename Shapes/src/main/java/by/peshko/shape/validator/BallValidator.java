package by.peshko.shape.validator;


import by.peshko.shape.entity.Ball;

public class BallValidator {

    public static boolean isBall(Object o) {
        Ball ball = (Ball) o;
        return !ball.getCenter().equals(ball.getAtCircle());
    }

    public static boolean isBall(double[] params) {
        if (params.length != 6) {
            return false;
        }
        return params[0] != params[3] ||
                params[1] != params[4] ||
                params[2] != params[5];
    }
}
