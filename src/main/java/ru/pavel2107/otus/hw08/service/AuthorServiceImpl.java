package ru.pavel2107.otus.hw08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.otus.hw08.domain.Author;
import ru.pavel2107.otus.hw08.domain.Book;
import ru.pavel2107.otus.hw08.repository.mongoDB.AuthorRepository;
import ru.pavel2107.otus.hw08.repository.mongoDB.BookRepository;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository repository;

    private BookRepository bookRepository;

    @Autowired
    public AuthorServiceImpl( AuthorRepository repository, BookRepository bookRepository){

        this.repository  = repository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Author save(Author author) {
        return repository.save( author);
    }

    @Override
    public void delete(String id) {
        Author author = find( id);
        if( author != null) {
            List<Book> bookList = bookRepository.findBookByAuthorId( id);
            if( bookList.size() == 0) {
                repository.delete(author);
            }
        }
    }

    @Override
    public Author find(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Author> findByName(String name) {
        return repository.findByName( name);
    }

    @Override
    public List<Author> findAll() {
        return (List<Author>)repository.findAll();
    }
}
