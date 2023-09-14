package dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.MovieDao;
import model.Movie;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MovieDaoImpl implements MovieDao {
    // TODO: 14.09.2023 положить фильм в указанной JSON файл
    @Override
    public void writeToFile(String path, List<Movie> movies) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule()); //регистрирует модуль JSON что бы он автоматически обрабатывал LocalDate

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); //выведет каждый обьект на новую строку

        try {
            objectMapper.writeValue(new File("movie.json"), movies);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // TODO: 14.09.2023 вернуть список фильмов из JSON файла (путь указан в параметре метода)
    @Override
    public List<Movie> readFromFile(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        List<Movie> movies = objectMapper.readValue(new File(path),
                new com.fasterxml.jackson.core.type.TypeReference<List<Movie>>() {
                });

        return movies;
    }
}
