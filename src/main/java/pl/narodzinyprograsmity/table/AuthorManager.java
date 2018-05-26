package pl.narodzinyprograsmity.table;

import org.hibernate.Session;
import pl.narodzinyprograsmity.model.Author;
import pl.narodzinyprograsmity.service.HibernateService;

public class AuthorManager extends HibernateCrudManager<Author> {

    public AuthorManager(HibernateService service) {
        super(service);
    }

    @Override
    public String getTableName() {
        return Author.TABLE_NAME;
    }

    @Override
    public Author getObject(Session session, String id) {
        return session.get(Author.class, id);
    }
}
