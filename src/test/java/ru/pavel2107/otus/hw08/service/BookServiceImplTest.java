package ru.pavel2107.otus.hw08.service;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import ru.pavel2107.otus.hw08.domain.*;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Import({ BookServiceImpl.class})
@DisplayName( "MongoDB. Сервис книг")
@DataMongoTest
public class BookServiceImplTest {

    @Autowired BookService service;


    private Book createTestBook(){
        Book book = new Book();
        book.setName( "test");
        book.setIsbn( "123");
        book.setPublicationPlace( "place");
        book.setPublishingHouse( "hos");
        book.setPublicationYear(1200);
        return book;
    }

    @Test
    public void getByISBN() {


    }

    @Test
    public void save() {
        Genre  genre  = new Genre();
        genre.setId( "1");

        Author author = new Author();
        author.setId( "1");

        Book book = createTestBook();

        book.setGenre( genre);
        book.setAuthor( author);
        book = service.save( book);
        assertEquals( "test", book.getName());

    }

    @Test
    public void delete() {

        Book book = createTestBook();
        book = service.save( book);
        service.delete( book.getId());
        book = service.find( book.getId());
        assertEquals( null, book);
    }

    @Test
    public void find() {
        Book book = createTestBook();
        book = service.save( book);
        book = service.find( book.getId());
        assertNotEquals( null, book);
    }

    @Test
    public void findByName() {
        Book book = createTestBook();
        book = service.save( book);
        List<Book> list = service.findByName( book.getName());
        assertNotEquals( 0, list.size());

    }

    @Test
    public void findBookByAuthorId() {
        Book book = createTestBook();

        Author author = new Author();
        author.setId( "1");

        book.setAuthor( author);
        book = service.save( book);
        List<Book> list = service.findBookByAuthorId( author.getId());
        assertNotEquals( 0, list.size());
    }

    @Test
    public void findAll() {
        Book book = createTestBook();
        service.save( book);
        List<Book>list = service.findAll();
        assertNotEquals( 0, list.size());
    }


}