package com.example.moviewatchlist.dto;

import lombok.Data;

@Data
public class MovieDTO {
    private String title;
    private String genre;
    private Integer releaseYear;
    private Boolean isWatched;
    private Double rating;
}
