package progkor.moviefinal.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import progkor.moviefinal.data.model.Movie;
import progkor.moviefinal.service.MovieService;

/**
 * REST controller for handling movie-related operations.
 */
@RestController
@RequestMapping("/api/v1/movie") // Specifies the base URL for movie-related endpoints
public class MovieRestController {
    private final MovieService movieService;

    /**
     * Constructs a MovieRestController with the provided MovieService.
     *
     * @param movieService The MovieService to be used by the controller.
     */
    @Autowired
    public MovieRestController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Retrieves a movie by its identifier.
     *
     * @param id The identifier of the movie to retrieve.
     * @return The movie with the specified identifier.
     */
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.retrieveByMovieId(id);
    }

    /**
     * Creates a new movie.
     *
     * @param movie The movie to be created.
     * @return The created movie.
     */
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    /**
     * Retrieves all movies.
     *
     * @return A list of all movies.
     */
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.retrieveAllMovie();
    }

    /**
     * Updates an existing movie.
     *
     * @param movie The movie to be updated.
     * @return The updated movie.
     */
    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.update(movie);
    }

    /**
     * Deletes a movie by its identifier.
     *
     * @param id The identifier of the movie to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
    }
}
