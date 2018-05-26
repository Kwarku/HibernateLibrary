package pl.narodzinyprograsmity.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySQLService implements HibernateService {
    private Session session;
    private SessionFactory sessionFactory;


    @Override
    public boolean connect(String configFile) {
        try {
            sessionFactory = new Configuration().configure(configFile).buildSessionFactory();
            return true;
        } catch (Throwable ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public void disconnect() {
        sessionFactory.close();
        sessionFactory = null;
    }

    @Override
    public SessionFactory getConnection() {
        return sessionFactory;
    }

    @Override
    public void openSession() {
        session = sessionFactory.openSession();
    }

    @Override
    public void closeSession() {
        session.close();
        session = null;
    }

    @Override
    public Session getSession() {
        return session;
    }

}
