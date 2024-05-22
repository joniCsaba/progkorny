package progkor.movie_final.data.repository.impl;

import progkor.movie_final.data.model.Movie;
import progkor.movie_final.data.repository.Repository;
import java.util.concurrent.atomic.AtomicLong;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@org.springframework.stereotype.Repository
public class InMemorryMovieRepository implements Repository<Movie, Long> {

    private static final Map<Long, Movie> STORAGE = new HashMap<>();
    private static final AtomicLong ID_GENERATOR = new AtomicLong(1);

    @Override
    public Movie save(Movie movie) {
        Long id = ID_GENERATOR.getAndIncrement();
        movie.setId(id);
        STORAGE.put(id, movie);
        return STORAGE.get(id);
    }

    @Override
    public Movie getById(Long id) {
        return STORAGE.get(id);
    }

    @Override
    public List<Movie> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Movie update(Movie movie) {
        Long id = movie.getId();
        STORAGE.put(id,movie);
        return STORAGE.get(id);
    }

    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}
