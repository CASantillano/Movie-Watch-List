package com.example.moviewatchlist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieDTO {
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Genre is required")
    private String genre;
    private Integer releaseYear;
    @NotNull(message = "isWatched is required")
    private Boolean isWatched;
    private Double rating;
}
