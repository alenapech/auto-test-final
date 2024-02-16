package org.alenapech;

import org.alenapech.model.Author;
import org.alenapech.model.Entity;
import org.alenapech.model.LibraryEntity;
import org.alenapech.service.CrudService;
import org.alenapech.service.InMemoryCrudService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Entity> getTestLibrary() {
        Author author1 = Utils.getAuthor(1, "Last Name 1", "First Name 1");
        Author author2 = Utils.getAuthor(2, "Last Name 2", "First Name 2");
        Author publisher1 = Utils.getAuthor(3, "Publisher 1", null);
        Author publisher2 = Utils.getAuthor(4, "Publisher 1", null);

        List<Entity> library = new ArrayList<>();

        library.add(author1);
        library.add(author2);
        library.add(publisher1);
        library.add(publisher2);

        library.add(Utils.getBook(5, "Book Title 1", author1, 10));
        library.add(Utils.getBook(6, "Book Title 2", author1, 100));
        library.add(Utils.getBook(7, "Book Title 3", author1, 143));
        library.add(Utils.getBook(8, "Book Title 4", author1, 500));

        library.add(Utils.getFilm(9, "Film Title 1", author2, 90));
        library.add(Utils.getFilm(10, "Film Title 2", author2, 120));

        library.add(Utils.getLetter(11, "Letter Title 1", author1, 1, "Santa"));
        library.add(Utils.getLetter(12, "Letter Title 2", author1, 2, "Barbara"));

        library.add(Utils.getMagazine(13, "Magazine Title 1", publisher1, 10, 12));
        library.add(Utils.getMagazine(14, "Magazine Title 2", publisher2, 90, 12));
        library.add(Utils.getMagazine(15, "Magazine Title 3", publisher2, 90, 13));
        library.add(Utils.getMagazine(16, "Magazine Title 4", publisher2, 90, 14));

        return library;
    }

    public static void main(String[] args) {
        CrudService service = new InMemoryCrudService(getTestLibrary());
        printEntityById(service, 1);
        printEntityById(service, 3);
        printEntityById(service, 11);
        printEntityById(service, 7);
        printEntityById(service, 10);
        printEntityById(service, 15);
        printEntityById(service, 70);

        printLibraryEntityByAuthor(service, (Author) service.getById(1));
        printLibraryEntityByAuthor(service, (Author) service.getById(2));
        printLibraryEntityByAuthor(service, (Author) service.getById(3));
    }

    private static void printEntityById(CrudService service, long id) {
        System.out.println(String.format("Get Entity By ID=%d (it can be Author also): %s", id, service.getById(id)));
    }

    private static void printLibraryEntityByAuthor(CrudService service, Author author) {
        System.out.println(String.format("Get Library Entity By Author=%s: %s", author, service.getByAuthor(author)));
    }

}