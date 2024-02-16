package org.alenapech;

import org.alenapech.model.*;

public class Utils {

    public static Author getAuthor(long id, String name, String firstName) {
        return Author.builder()
                .id(id)
                .name(name)
                .firstName(firstName)
                .build();
    }

    public static Book getBook(long id, String title, Author author, int pages) {
        return Book.builder()
                .id(id)
                .title(title)
                .author(author)
                .pages(pages)
                .build();
    }

    public static Film getFilm(long id, String title, Author author, int length) {
        return Film.builder()
                .id(id)
                .title(title)
                .author(author)
                .length(length)
                .build();
    }

    public static Letter getLetter(long id, String title, Author author, int pages, String to) {
        return Letter.builder()
                .id(id)
                .title(title)
                .author(author)
                .pages(pages)
                .to(to)
                .build();
    }

    public static Magazine getMagazine(long id, String title, Author author, int pages, int magazineIssue) {
        return Magazine.builder()
                .id(id)
                .title(title)
                .author(author)
                .pages(pages)
                .magazineIssue(magazineIssue)
                .build();
    }

}
