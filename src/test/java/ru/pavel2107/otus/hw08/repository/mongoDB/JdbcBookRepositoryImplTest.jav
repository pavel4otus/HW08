package ru.pavel2107.otus.hw08.repository.mongoDB;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.pavel2107.otus.hw08.domain.Author;
import ru.pavel2107.otus.hw08.domain.Book;
import ru.pavel2107.otus.hw08.domain.Genre;
import ru.pavel2107.otus.hw08.repository.mongoDB.BookRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@Import({ BookRepository.class, GenreRepository.class, AuthorRepository.class})
@DisplayName( "MongoDB. Репозиторий книг")
class JdbcBookRepositoryImplTest {

    @Autowired BookRepository repository;

    @Test
    void save() {

        Genre  genre  = new Genre();
        genre.setId( "1");

        Author author = new Author();
        author.setId( "1");

        Book book = new Book();
        book.setName( "test");
        book.setIsbn( "123");
        book.setPublicationPlace( "place");
        book.setPublishingHouse( "hos");
        book.setPublicationYear(1200);
        book.setGenre( genre);
        book.setAuthor( author);
        book = repository.save( book);
        assertEquals( "test", book.getName());
    }

    @Test
    void delete() {
        int oldSize = ( (List<Book>)repository.findAll()).size();
        Genre  genre  = new Genre();
        genre.setId( "1");

        Author author = new Author();
        author.setId( "1");

        Book book = new Book();
        book.setName( "test");
        book.setIsbn( "123");
        book.setPublicationPlace( "place");
        book.setPublishingHouse( "hos");
        book.setPublicationYear(1200);
        book.setGenre( genre);
        book.setAuthor( author);
        book = repository.save( book);

        repository.delete( book);

        int newSize = ( (List<Book>)repository.findAll()).size();
        assertEquals( oldSize, newSize);

    }

    @Test
    void getByISBN() {
        String isbn = "1111111";
        Book book = repository.findByIsbn( isbn);
        assertEquals( isbn, book.getIsbn());
    }

    @Test
    void getByName() {
        String name = "book 1";
        List<Book> books = repository.findByName( name);
        Book book = books.get(0);
        assertEquals( name, book.getName());
    }

    @Test
    void getByAuthorID() {
        List<Book> books = repository.findBookByAuthorId( "1");
        for( Book b: books){
            assertEquals( "1", b.getAuthor().getId());
        }
    }

    @Test
    void getAll() {
        List<Book> list = (List<Book> )repository.findAll();
        assertNotEquals( 0, list.size());
    }
}