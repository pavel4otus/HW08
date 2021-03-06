package ru.pavel2107.otus.hw08.repository.mongoDB;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pavel2107.otus.hw08.domain.Genre;


@Repository
public interface GenreRepository extends CrudRepository<Genre, String> {
}
