package pl.narodzinyprograsmity;

import pl.narodzinyprograsmity.model.Author;
import pl.narodzinyprograsmity.model.Book;
import pl.narodzinyprograsmity.model.BookType;
import pl.narodzinyprograsmity.model.Human;
import pl.narodzinyprograsmity.service.HibernateService;
import pl.narodzinyprograsmity.service.MySQLService;
import pl.narodzinyprograsmity.table.AuthorManager;
import pl.narodzinyprograsmity.table.BookManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static HibernateService hibernateService;

    public static void main(String[] args) {
        hibernateService = new MySQLService();
        hibernateService.connect("hibernate.cfg.xml");

        List<Book> books = new ArrayList<>();
        books.add(new Book("Batman", BookType.COMICS));
        books.add(new Book("Spiderman", BookType.COMICS));
        books.add(new Book("Superman", BookType.COMICS));

        AuthorManager authorManager = new AuthorManager(hibernateService);
        Author author = new Author(new Human("Andrzej", "Gołota"), 1967, books);
        String authorId = authorManager.create(author);


        BookManager bookManager = new BookManager(hibernateService);
//        Book book = new Book("Spiderman", BookType.COMICS, author,author2);
//        String bookId = bookManager.create(book);



//        bookManager.read().forEach(System.out::println);
//
//        System.out.println("Zmiana kżyżaków na ogniem i mieczem");
//        bookManager.update(new Book("2c90c6b0635426420163542644420001","Ogniem i mieczem",BookType.FANTASY));
//        bookManager.read().forEach(System.out::println);


//        List<Book> books = bookManager.read();
//        books.forEach(System.out::println);
//
//        bookManager.delete(books.get(0).getId());
//        bookManager.read().forEach(System.out::println);

//
//
//        System.out.println();
//




        hibernateService.disconnect();
    }
}
