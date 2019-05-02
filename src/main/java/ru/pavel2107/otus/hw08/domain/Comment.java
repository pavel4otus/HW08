package ru.pavel2107.otus.hw08.domain;


import java.time.LocalDateTime;


//
// id - id комментария
// dateTime - время когда оставили
// name - имя пользователя
// comment - сам сомментарий
//

public class Comment {

    private String name;
    private LocalDateTime dateTime;
    private String comment;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                ", name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", comment='" + comment + '\'' +
                '}';
    }
}
