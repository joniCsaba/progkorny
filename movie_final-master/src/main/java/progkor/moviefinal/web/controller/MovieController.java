package progkor.moviefinal.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;
import progkor.moviefinal.data.model.Movie;
import progkor.moviefinal.service.MovieService;

/**
 * Controller for managing movie-related views and operations.
 */
@Controller
@RequestMapping("/movie_final")
public class MovieController {

    private final MovieService movieService;

    /**
     * Constructs a MovieController with the provided MovieService.
     *
     * @param movieService The MovieService used by the controller.
     */
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Retrieves a movie by its identifier and displays it in an edit form.
     *
     * @param model The model to add attributes to.
     * @param id The identifier of the movie to retrieve.
     * @return The name of the edit template.
     */
    @GetMapping("/{id}")
    public String getMovieById(Model model, @PathVariable Long id) {
        Movie movie = movieService.retrieveByMovieId(id);
        model.addAttribute("movie", movie);
        model.addAttribute("genres", getGenres());
        return "edit";  // Ensure this matches your edit template name
    }

    /**
     * Retrieves all movies and displays them in a list view.
     *
     * @param model The model to add attributes to.
     * @return The name of the list template.
     */
    @GetMapping
    public String getAllMovies(Model model) {
        List<Movie> allMovies = movieService.retrieveAllMovie();
        model.addAttribute("movies", allMovies);
        return "list";  // Ensure this matches your list template name
    }

    /**
     * Displays a form for creating a new movie.
     *
     * @param model The model to add attributes to.
     * @return The name of the create form template.
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("genres", getGenres());
        return "create";  // Ensure this matches your create template name
    }

    /**
     * Creates a new movie.
     *
     * @param movie The movie to create.
     * @return Redirects to the list view after creating.
     */
    @PostMapping("/create")
    public String createMovie(@ModelAttribute Movie movie) {
        movieService.createMovie(movie);
        return "redirect:/movie_final";  // Redirect to avoid form resubmission
    }

    /**
     * Updates an existing movie.
     *
     * @param movie The movie to update.
     * @return Redirects to the list view after updating.
     */
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateMovie(@ModelAttribute Movie movie) {
        movieService.update(movie);
        return "redirect:/movie_final";  // Redirect to the list view after updating
    }

    /**
     * Deletes a movie by its identifier.
     *
     * @param id The identifier of the movie to delete.
     * @param model The model to add attributes to.
     * @return Redirects to the list view after deleting.
     */
    @GetMapping("/{id}/delete")
    public String deleteMovieById(@PathVariable Long id, Model model) {
        movieService.deleteMovieById(id);
        return "redirect:/movie_final";  // Redirect to the list view after deleting
    }

    /**
     * Helper method to get a list of movie genres.
     *
     * @return A list of movie genres.
     */
    private List<String> getGenres() {
        return Arrays.asList("Action", "Comedy", "Drama",
                "Horror", "Romance", "Sci-Fi", "Thriller");
    }
}
