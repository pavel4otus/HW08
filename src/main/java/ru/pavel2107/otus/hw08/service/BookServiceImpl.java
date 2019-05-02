package ru.pavel2107.otus.hw08.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pavel2107.otus.hw08.domain.Book;
import ru.pavel2107.otus.hw08.domain.Comment;
import ru.pavel2107.otus.hw08.repository.mongoDB.BookRepository;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;


    @Autowired
    public BookServiceImpl( BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public Book getByISBN(String ISBN) {
        return bookRepository.findByIsbn( ISBN);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save( book);
    }

    @Override
    public void delete(String ID) {
        Book book = find( ID);
        if( book != null) {
            bookRepository.delete(book);
        }
    }

    @Override
    public Book find(String ID) {
        return bookRepository.findById( ID).orElse( null);
    }

    @Override
    public List<Book> findByName(String name) {
        return bookRepository.findByName( name);
    }

    @Override
    public List<Book> findBookByAuthorId(String authorID) {
        return bookRepository.findBookByAuthorId( authorID);
    }

    @Override
    public List<Book> findAll() {
        return (List<Book> ) bookRepository.findAll();
    }
}
