package progkor.movie_final.data.repository;

import java.util.List;

/*
* TODO.
* */
public interface Repository<T, ID> {

    // CRUD -- create read update delete

    T save(T item); //create

    T getById(ID id); //read
    List<T> getAll(); // read

    T update(T item); // update

    void deleteById(ID id); // delete
}
