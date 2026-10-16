package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class InMemoryRepository<T, ID> implements CrudRepository<T, ID> {
    private final List<T> entities = new ArrayList<>();
    private final Function<T, ID> idExtractor;

    public InMemoryRepository(Function<T, ID> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public void save(T entity) {
        ID id = idExtractor.apply(entity);

        for (int i = 0; i < entities.size(); i++) {
            if (idExtractor.apply(entities.get(i)).equals(id)) {
                entities.set(i, entity);
                return;
            }
        }
        entities.add(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        for (T entity : entities) {
            if (idExtractor.apply(entity).equals(id)) {
                return Optional.of(entity);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public boolean deleteById(ID id) {
        return entities.removeIf(
            entity -> idExtractor.apply(entity).equals(id)
        );
    }
}