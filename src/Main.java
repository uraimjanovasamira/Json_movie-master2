import dao.impl.MovieDaoImpl;
import model.Movie;
import model.enums.Genre;
import service.impl.MovieServiceImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO: 14.09.2023 для началы работы необходимо положить 5 фильмов в JSON файл
        //  (для этого используйте метод writeToFile(String path, Movie movie); из класса MovieDao

        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie(1, "Mark", Genre.DETECTIVE, LocalDate.of(2020, 10, 1), 1),
                new Movie(2, "Демон", Genre.ACTION, LocalDate.of(2019, 12, 6), 2),
                new Movie(3, "Маска", Genre.BIOGRAPHICAL, LocalDate.of(2000, 9, 1), 3)

        ));

        MovieDaoImpl movieDao = new MovieDaoImpl();
        MovieServiceImpl movieService = new MovieServiceImpl(movieDao);


        movieDao.writeToFile("movie.json", movies);
        movieService.updateById(2, new Movie(2, "Me", Genre.ANIME, LocalDate.of(1212, 7, 5), 2));
    }


}