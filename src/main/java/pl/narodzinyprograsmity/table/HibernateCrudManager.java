package pl.narodzinyprograsmity.table;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.narodzinyprograsmity.model.BaseModel;
import pl.narodzinyprograsmity.service.HibernateService;

import java.util.List;

public abstract class HibernateCrudManager<T extends BaseModel> implements CrudManager<T> {
    private HibernateService service;

    public HibernateCrudManager(HibernateService service) {
        this.service = service;
    }

    public abstract String getTableName();

    public abstract T getObject(Session session, String id);

    @Override
    public String create(T t) {
        service.openSession();
        Session session = service.getSession();
        Transaction tx = null;
        String id = null;
        try {
            tx = session.beginTransaction();
            id = (String) session.save(t);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public void update(T newT) {
        service.openSession();
        Session session = service.getSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(newT);
            tx.commit();
        }catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void delete(String id) {
        service.openSession();
        Session session = service.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.delete(getObject(session, id));
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

    @Override
    public List<T> read() {
        service.openSession();
        Session session = service.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List list = session.createQuery("FROM " + getTableName()).list();


            tx.commit();
            return list;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }


}
