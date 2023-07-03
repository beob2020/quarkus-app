package com.app.books;

import lombok.*;

import java.time.Year;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private Year yearOfPublication;
}
