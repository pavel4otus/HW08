package ru.pavel2107.otus.hw08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.otus.hw08.domain.Author;
import ru.pavel2107.otus.hw08.repository.mongoDB.AuthorRepository;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository repository;


    @Autowired
    public AuthorServiceImpl( AuthorRepository repository){
        this.repository = repository;
    }

    @Override
    public Author save(Author author) {
        return repository.save( author);
    }

    @Override
    public void delete(String ID) {
        Author author = find( ID);
        if( author != null) {
            repository.delete(author);
        }
    }

    @Override
    public Author find(String ID) {
        return repository.findById(ID).orElse(null);
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
