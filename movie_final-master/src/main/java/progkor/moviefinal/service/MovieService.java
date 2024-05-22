package progkor.moviefinal.service;

import java.util.List;
import progkor.moviefinal.data.model.Movie;

/**
 * This interface defines the operations available for managing Movie entities.
 */
public interface MovieService {

    /**
     * Creates a new movie entity.
     *
     * @param movie The movie entity to create.
     * @return The created movie entity.
     */
    Movie createMovie(Movie movie);

    /**
     * Retrieves a movie by its unique identifier.
     *
     * @param id The unique identifier of the movie to retrieve.
     * @return The movie with the specified identifier, or null if not found.
     */
    Movie retrieveByMovieId(Long id);

    /**
     * Retrieves all movies.
     *
     * @return A list of all movies.
     */
    List<Movie> retrieveAllMovie();

    /**
     * Updates an existing movie entity.
     *
     * @param movie The movie entity to update.
     * @return The updated movie entity.
     */
    Movie update(Movie movie);

    /**
     * Deletes a movie entity by its unique identifier.
     *
     * @param id The unique identifier of the movie to delete.
     */
    void deleteMovieById(Long id);
}
