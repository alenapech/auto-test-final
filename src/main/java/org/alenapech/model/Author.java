package org.alenapech.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class Author implements Entity {

    @NonNull
    private long id;

    @NonNull
    private String name;

    private String firstName;

}
