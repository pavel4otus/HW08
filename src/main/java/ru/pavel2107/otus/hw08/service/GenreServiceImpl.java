package ru.pavel2107.otus.hw08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.otus.hw08.domain.Genre;
import ru.pavel2107.otus.hw08.repository.mongoDB.GenreRepository;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {


    private GenreRepository repository;

    @Autowired
    public GenreServiceImpl(GenreRepository repository){
        this.repository = repository;
    }

    @Override
    public Genre save(Genre genre) {
        return repository.save( genre);
    }

    @Override
    public void delete(String ID) {
        Genre g = find( ID);
        if( g != null) {
            repository.delete( g);
        }
    }

    @Override
    public Genre find(String ID) {
        return repository.findById( ID).orElse( null);
    }

    @Override
    public List<Genre> findAll() {
        return (List<Genre>)repository.findAll();
    }
}
