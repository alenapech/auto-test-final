package org.alenapech.model;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString(callSuper = true)
public class Book extends AbstractLibraryEntity {

    @NonNull
    private int pages;

}
