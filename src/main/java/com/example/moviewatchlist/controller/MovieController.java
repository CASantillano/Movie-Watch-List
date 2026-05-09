package com.example.moviewatchlist.controller;

import com.example.moviewatchlist.dto.MovieDTO;
import com.example.moviewatchlist.entity.Movie;
import com.example.moviewatchlist.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> create(@RequestBody MovieDTO req, Authentication auth) {
        String userId = (String) auth.getPrincipal();
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(req, userId));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllByUser(Authentication auth) {
        String userId = (String) auth.getPrincipal();
        return ResponseEntity.ok(movieService.getAllByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable String id, Authentication auth) {
        String userId = (String) auth.getPrincipal();
        return ResponseEntity.ok(movieService.getById(id, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable String id, @RequestBody MovieDTO req, Authentication auth) {
        String userId = (String) auth.getPrincipal();
        return ResponseEntity.ok(movieService.update(id, req, userId));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id, Authentication auth) {
        String userId = (String) auth.getPrincipal();
        movieService.delete(id, userId);
    }
}
