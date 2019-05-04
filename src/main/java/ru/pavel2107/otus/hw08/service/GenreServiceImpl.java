package ru.pavel2107.otus.hw08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.otus.hw08.domain.Book;
import ru.pavel2107.otus.hw08.domain.Genre;
import ru.pavel2107.otus.hw08.repository.mongoDB.BookRepository;
import ru.pavel2107.otus.hw08.repository.mongoDB.GenreRepository;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {


    private GenreRepository repository;
    private BookRepository  bookRepository;


    @Autowired
    public GenreServiceImpl(GenreRepository repository, BookRepository bookRepository){

        this.repository = repository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Genre save(Genre genre) {
        return repository.save( genre);
    }

    @Override
    public void delete(String id) {
        Genre g = find( id);
        if( g != null) {
            List<Book> bookList = bookRepository.findBookByGenreId( id);
            if( bookList.size() == 0) {
                repository.delete(g);
            }
        }
    }

    @Override
    public Genre find(String id) {
        return repository.findById( id).orElse( null);
    }

    @Override
    public List<Genre> findAll() {
        return (List<Genre>)repository.findAll();
    }
}
