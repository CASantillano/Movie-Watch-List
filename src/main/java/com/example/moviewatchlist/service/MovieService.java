package com.example.moviewatchlist.service;

import com.example.moviewatchlist.dto.MovieDTO;
import com.example.moviewatchlist.entity.Movie;
import com.example.moviewatchlist.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie create(MovieDTO req, String userId) {
        Movie movie = new Movie();
        movie.setUserId(userId);
        movie.setTitle(req.getTitle());
        movie.setGenre(req.getGenre());
        movie.setReleaseYear(req.getReleaseYear());
        movie.setIsWatched(req.getIsWatched());
        movie.setRating(req.getRating());
        return movieRepository.save(movie);
    }

    public List<Movie> getAllByUser(String userId) {
        return movieRepository.findByUserId(userId);
    }

    public Movie getById(String id, String userId) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        if (!movie.getUserId().equals(userId)) {
            throw new RuntimeException("You don't have this movie");
        }
        return movie;
    }

    public Movie update(String id, MovieDTO req, String userId) {
        Movie movie = getById(id, userId);
        movie.setTitle(req.getTitle());
        movie.setGenre(req.getGenre());
        movie.setReleaseYear(req.getReleaseYear());
        movie.setIsWatched(req.getIsWatched());
        movie.setRating(req.getRating());
        return movieRepository.save(movie);
    }

    public void delete(String id, String userId) {
        Movie movie = getById(id, userId);
        movieRepository.delete(movie);
    }
}
