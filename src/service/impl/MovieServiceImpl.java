package service.impl;

import dao.MovieDao;
import model.Movie;
import model.enums.Genre;
import service.MovieService;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImpl implements MovieService {
    private static final String PATH = "movie.json";
    private final MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }


    @Override
    // TODO: 14.09.2023 вернуть фильм по ID

    public Movie findById(int movieId) throws IOException {
        List<Movie> list = movieDao.readFromFile(PATH);

        for (Movie movie : list) {
            if (movie.getId() == movieId) {
                return movie;
            }
        }
        return null;
    }

    @Override
    // TODO: 14.09.2023 вернуть фильм по названию
    public Movie findByName(String name) throws IOException {
        List<Movie> list = movieDao.readFromFile(PATH);
        for (Movie movie : list) {
            if (name.equals(movie.getName())) {
                return movie;
            }
        }
        return null;
    }

    @Override
// TODO: 14.09.2023 вернуть отсортированный лист по дате создание
    public List<Movie> sortByDate() throws IOException {
        List<Movie> list = movieDao.readFromFile(PATH);
        list.sort(new Comparator<Movie>() {

            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getCreateDate().compareTo(o2.getCreateDate());
            }
        });
        return list;
    }

    @Override
// TODO: 14.09.2023 отфилтрововать все фильмы по жанру
    public List<Movie> filterByGenre(Genre genre) throws IOException {
        List<Movie> list = movieDao.readFromFile(PATH);
        return list.stream()
                .filter(movie -> movie.getGenre() == genre)
                .collect(Collectors.toList());
    }

    @Override
// TODO: 14.09.2023 найти обьект по ID и изменит его состояние
    public void updateById(int movieId, Movie movie) throws IOException {
        List<Movie> list = movieDao.readFromFile(PATH);
        for (Movie movie1 : list) {
            if (movie1.getId() == movieId) {
                movie1.setName(movie.getName());
                movie1.setGenre(movie.getGenre());
                movie1.setCreateDate(movie.getCreateDate());
                movie1.setCashBox(movie.getCashBox());
            }
        }
        for (Movie movie1 : list) {
            System.out.println(movie1);
        }

    }
}
