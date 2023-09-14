package dao;

import model.Movie;

import java.io.IOException;
import java.util.List;

public interface MovieDao {
    void writeToFile(String path, List<Movie> movies) throws IOException;

    List<Movie> readFromFile(String path) throws IOException;
}
