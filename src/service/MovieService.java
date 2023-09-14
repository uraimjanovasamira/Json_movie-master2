package service;

import model.Movie;
import model.enums.Genre;

import java.io.IOException;
import java.util.List;

public interface MovieService {
    Movie findById(int movieId) throws IOException;

    Movie findByName(String name) throws IOException;

    List<Movie> sortByDate() throws IOException;

    List<Movie> filterByGenre(Genre genre) throws IOException;

    void updateById(int movieId, Movie movie) throws IOException;
}
