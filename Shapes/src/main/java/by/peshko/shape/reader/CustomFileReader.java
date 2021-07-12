package by.peshko.shape.reader;

import by.peshko.shape.exception.BallException;

import java.util.List;

public interface CustomFileReader {

    List<String> readFile(String file) throws BallException;
}
