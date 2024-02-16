package org.alenapech.service;

import lombok.NonNull;
import org.alenapech.model.Author;
import org.alenapech.model.Entity;
import org.alenapech.model.LibraryEntity;

import java.util.List;
import java.util.stream.Collectors;

public class InMemoryCrudService implements CrudService {

    List<Entity> entities;

    public InMemoryCrudService(List<Entity> entities) {
        this.entities = entities;
    }

    @Override
    public Entity getById(@NonNull long id) {
        return entities.stream()
                .filter(v -> id == v.getId())
                .findFirst().orElse(null);
    }

    @Override
    public List<LibraryEntity> getByAuthor(@NonNull Author author) {
        return entities.stream()
                .filter(v -> v instanceof LibraryEntity)
                .map(v -> (LibraryEntity) v)
                .filter(v -> author.equals(v.getAuthor()))
                .collect(Collectors.toList());
    }
}
