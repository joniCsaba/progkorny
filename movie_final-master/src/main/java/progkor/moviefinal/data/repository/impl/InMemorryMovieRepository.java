package progkor.moviefinal.data.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import progkor.moviefinal.data.model.Movie;
import progkor.moviefinal.data.repository.Repository;

/**
 * An in-memory implementation of the Movie repository.
 */
@org.springframework.stereotype.Repository
public class InMemorryMovieRepository implements Repository<Movie, Long> {

    private static final Map<Long, Movie> STORAGE = new HashMap<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);

    /**
     * Saves a movie in the repository.
     *
     * @param movie The movie to save.
     * @return The saved movie.
     */
    @Override
    public Movie save(Movie movie) {
        Long id = ID_GENERATOR.getAndIncrement();
        movie.setId(id);
        STORAGE.put(id, movie);
        return STORAGE.get(id);
    }

    /**
     * Retrieves a movie by its ID from the repository.
     *
     * @param id The ID of the movie to retrieve.
     * @return The movie with the given ID, or null if not found.
     */
    @Override
    public Movie getById(Long id) {
        return STORAGE.get(id);
    }

    /**
     * Retrieves all movies from the repository.
     *
     * @return A list of all movies in the repository.
     */
    @Override
    public List<Movie> getAll() {
        return List.copyOf(STORAGE.values());
    }

    /**
     * Updates a movie in the repository.
     *
     * @param movie The movie to update.
     * @return The updated movie.
     */
    @Override
    public Movie update(Movie movie) {
        Long id = movie.getId();
        STORAGE.put(id, movie);
        return STORAGE.get(id);
    }

    /**
     * Deletes a movie from the repository by its ID.
     *
     * @param id The ID of the movie to delete.
     */
    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}
