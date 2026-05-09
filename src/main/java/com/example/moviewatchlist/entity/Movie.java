package com.example.moviewatchlist.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
@Data
public class Movie {
    @Id
    private String id;

    private String userId;

    private String title;
    private String genre;
    private Integer releaseYear;
    private Boolean isWatched;
    private Double rating;
}
