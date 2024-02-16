package org.alenapech.model;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString(callSuper = true)
public class Magazine extends Book {

    @NonNull
    private int magazineIssue;

}
