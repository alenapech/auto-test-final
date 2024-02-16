package org.alenapech.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class AbstractLibraryEntity implements LibraryEntity {

    @NonNull
    private long id;

    @NonNull
    private String title;

    @NonNull
    private Author author;

}
