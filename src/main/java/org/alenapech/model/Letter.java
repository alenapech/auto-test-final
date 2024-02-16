package org.alenapech.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@ToString(callSuper = true)
public class Letter extends Book {

    private String to;

}
