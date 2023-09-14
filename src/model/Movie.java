package model;

// TODO: 13.09.2023 у вас есть класс Movie у него должен быть следующие поля
//  id,name,genre(enum),createDate(LocalDate),касса

import model.enums.Genre;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Movie {
    private int id;
    private String name;
    private Genre genre;
    private LocalDate createDate;
    private int cashBox;

    public Movie() {
    }

    public Movie(int id, String name, Genre genre, LocalDate createDate, int cashBox) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.createDate = createDate;
        this.cashBox = cashBox;
    }

    public Movie(String id, String name, Genre genre, LocalDate createDate, String cashBox) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }


    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public int getCashBox() {
        return cashBox;
    }

    public void setCashBox(int cashBox) {
        this.cashBox = cashBox;
    }

    @Override
    public String toString() {
        return "\nMovie:" +
                "id:" + id +"\n"+
                "name:" + name + "\n" +
                "genre:" + genre +"\n"+
                "createDate:" + createDate +"\n"+
                "cashBox:" + cashBox +"\n";
    }
}