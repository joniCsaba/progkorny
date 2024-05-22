package progkor.moviefinal.data.repository;

import java.util.List;

/**
 * A generic interface representing a repository for managing data entities.
 *
 * @param <T>  The type of entity managed by the repository.
 * @param <IdT> The type of the unique identifier for the entity,
 *             it should end with "T" because of checkstyle.
 */
public interface Repository<T, IdT> {
    /**
     * Saves an entity.
     *
     * @param item The entity to be saved.
     * @return The saved entity.
     */
    T save(T item);

    /**
     * Retrieves an entity by its unique identifier.
     *
     * @param id The unique identifier of the entity to retrieve.
     * @return The entity with the specified identifier, or null if not found.
     */
    T getById(IdT id);

    /**
     * Retrieves all entities managed by the repository.
     *
     * @return A list of all entities managed by the repository.
     */
    List<T> getAll();

    /**
     * Updates an existing entity.
     *
     * @param item The entity to be updated.
     * @return The updated entity.
     */
    T update(T item);

    /**
     * Deletes an entity by its unique identifier.
     *
     * @param id The unique identifier of the entity to delete.
     */
    void deleteById(IdT id);
}
