package pl.narodzinyprograsmity.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "books")
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "book_id")) })
public class Book extends BaseModel{

    public static final String TABLE_NAME = "Book";

    @Column(name = "book_name")
    private String name;
    @Column(name = "book_type")
    private BookType bookType;

/*    @ManyToMany(mappedBy = "books")
    private Collection<Author> authors = new ArrayList<>();*/


    public Book() {
    }

    public Book(String name, BookType bookType) {
        this.name = name;
        this.bookType = bookType;
    }

/*    public Book(String name, BookType bookType) {
        this.name = name;
        this.bookType = bookType;
    }*/

    public Book(String id, String name, BookType bookType) {
        this.name = name;
        this.bookType = bookType;
        this.setId(id);
    }


    @Enumerated(EnumType.STRING)
    public BookType getBookType() {
        return bookType;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", bookType=" + bookType +
                '}';
    }
}