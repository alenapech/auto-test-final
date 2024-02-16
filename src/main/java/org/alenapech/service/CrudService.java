package org.alenapech.service;

import org.alenapech.model.Author;
import org.alenapech.model.Entity;
import org.alenapech.model.LibraryEntity;

import java.util.List;

public interface CrudService {

    //there is no any sense search by id AND author since id should be unique for the whole collection (you can search by id only in this case)
    //so, 2 methods are enough to have ability to search by id OR author

    Entity getById(long id);

    List<LibraryEntity> getByAuthor(Author author);

}
