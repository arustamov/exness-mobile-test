package arustamov.entities;

import arustamov.entity.Entity;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Entities<E extends Entity, P extends List<?>> {

    E get(P params, Boolean cached);

    List<E> getAll(P params, Boolean cached);

    default Logger getLogger() {
        return LoggerFactory.getLogger(
            getClass()
        );
    }

    default E get(P params) {
        return get(params, false);
    }

    default List<E> getAll() {
        return getAll(null, false);
    }

    default List<E> getAll(P params) {
        return getAll(params, false);
    }

    default E byId(Integer id) {
        return single(
            getAll().stream().filter(
                entity -> id.equals(
                    entity.getId()
                )
            )
        );
    }

    default List<E> all(Stream<E> entities) {
        return entities.collect(
            Collectors.toList()
        );
    }

    default <R> R random(List<R> entities) {
        return random(entities, 1).get(0);
    }

    default <R> List<R> random(List<R> entities, Integer count) {
        if (entities.size() < count)
            throw new RuntimeException(
                String.format("Entities list size is %d, expected at least %d!",
                    entities.size(),
                    count)
            );
        Collections.shuffle(entities);
        return entities.subList(0, count);
    }

    default E any(Stream<E> entities) {
        return entities.findAny().orElseThrow(
            () -> new RuntimeException("Entities list is empty!")
        );
    }

    default E first(Stream<E> entities) {
        return entities.findFirst().orElseThrow(
            () -> new RuntimeException("Entities list is empty!")
        );
    }

    default E single(Stream<E> entities) {
        List<E> entitiesList = all(entities);
        if (entitiesList.isEmpty()) {
            throw new RuntimeException("Entities list is empty!");
        } else if (entitiesList.size() > 1) {
            throw new RuntimeException("Entities is not single!");
        }
        return entitiesList.get(0);
    }
}
