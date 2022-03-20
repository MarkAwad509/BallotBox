package DAL;

import java.util.List;
import java.util.Optional;

public interface InMemDAO<T> {
    void create(T data);
    List<T> getAll();
    Optional<T> getOne(int id);
    boolean update(int id, T data);
    boolean delete(int id);
}
