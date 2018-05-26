package pl.narodzinyprograsmity.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "authors")
@AttributeOverrides({@AttributeOverride(name = "id", column = @Column(name = "author_id"))})
public class Author extends BaseModel{

    public static final String TABLE_NAME = "Author";

    @Embedded
    private Human human;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @ManyToMany
    private Collection<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(Human human, int yearOfBirth, Collection books) {
        this.human = human;
        this.yearOfBirth = yearOfBirth;
        this.books = books;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Author{" +
                "human=" + human +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
