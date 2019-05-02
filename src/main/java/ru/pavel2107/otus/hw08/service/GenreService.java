package ru.pavel2107.otus.hw08.service;

import ru.pavel2107.otus.hw08.domain.Genre;

import java.util.List;

public interface GenreService {

    Genre save( Genre genre);
    void delete( String ID);
    Genre find(String ID);
    List<Genre> findAll();

}
