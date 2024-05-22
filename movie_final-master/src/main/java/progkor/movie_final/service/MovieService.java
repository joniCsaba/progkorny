package progkor.movie_final.service;

import progkor.movie_final.data.model.Movie;

import java.util.List;


//ez a service koti ossze a controller osztalyt az alatta levo repository resszel
public interface MovieService {

    /*
     * TODO.
     *@param movies TODO.
     *@return TODO.
     * */
    Movie createMovie(Movie movie);

    Movie retrieveByMovieId(Long id);
    List<Movie> retrieveAllMovie();

    Movie update(Movie movie);

    void deleteMovieById(Long id);
}
