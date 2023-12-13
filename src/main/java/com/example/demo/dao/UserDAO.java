package com.example.demo.dao;



import com.example.demo.HibernateUtil;
import com.example.demo.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO implements ActionDAO<User> {

    @Override
    public boolean create(User o) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();

            session.persist(o);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction!=null)
                transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public User update(User o) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User userModified = session.merge(o);
            transaction.commit();
            return userModified;
        } catch (Exception e){
            e.printStackTrace();
            if(transaction!=null)
                transaction.rollback();
            return null;
        }
    }

    @Override
    public boolean deleteById(String id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User user = session.find(User.class, Integer.parseInt(id));
            session.remove(user);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            if(transaction!=null)
                transaction.rollback();
            return false;
        }
        return true;
    }

    @Override
    public User retrieveById(String id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            User user = session.find(User.class, Integer.parseInt(id));
            transaction.commit();
            return user;
        } catch (Exception e){
            e.printStackTrace();
            if(transaction!=null)
                transaction.rollback();
            return null;
        }
    }

}
