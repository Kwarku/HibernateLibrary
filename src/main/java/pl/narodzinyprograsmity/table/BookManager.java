package pl.narodzinyprograsmity.table;

import org.hibernate.Session;
import pl.narodzinyprograsmity.model.Book;
import pl.narodzinyprograsmity.service.HibernateService;

public class BookManager extends HibernateCrudManager<Book> {

    public BookManager(HibernateService service) {
        super(service);
    }

    @Override
    public String getTableName() {
        return Book.TABLE_NAME;
    }

    @Override
    public Book getObject(Session session, String id) {
        return session.get(Book.class, id);
    }


}
