package by.peshko.shape.reader.impl;

import by.peshko.shape.exception.BallException;
import by.peshko.shape.reader.CustomFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final String BALL_FILE_PATH = "./files/Balls.txt";
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readFile(String filePath) throws BallException {
        logger.info(filePath.isEmpty() ?
                filePath = BALL_FILE_PATH :
                "Using new file " + filePath);
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            logger.error(new StringBuilder().append("File ").
                    append(filePath).append(" not found!"));
            throw new BallException();
        }
    }
}
