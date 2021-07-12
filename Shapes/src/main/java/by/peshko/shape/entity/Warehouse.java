package by.peshko.shape.entity;

import by.peshko.shape.exception.BallException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {
    private final Map<Integer, BallParameter> parameters = new HashMap<>();
    private static final Warehouse WAREHOUSE = new Warehouse();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return WAREHOUSE;
    }

    public BallParameter set(int id, BallParameter ballParameter) {
        return parameters.put(id, ballParameter);
    }

    public BallParameter get(int id) throws BallException {
        Optional<BallParameter> ballParameter = Optional.ofNullable(parameters.get(id));
        if (ballParameter.isEmpty()) {
            throw new BallException();
        }
        return ballParameter.get();
    }

    public boolean remove(int id) {
        Optional<BallParameter> ballParameter = Optional.ofNullable(parameters.remove(id));
        return ballParameter.isPresent();
    }


}
