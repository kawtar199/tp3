package com.example.demo.dao;

import com.example.demo.HibernateUtil;
import com.example.demo.entities.Product;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO implements ActionDAO<Product> {

    @Override
    public boolean create(Product o) {
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
    public Product update(Product o) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Product cartModified = session.merge(o);
            transaction.commit();
            return cartModified;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null)
                transaction.rollback();
            return null;
        }
    }

    @Override
    public boolean deleteById(String id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Product product = session.find(Product.class, Integer.parseInt(id));
            session.remove(product);
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
    public Product retrieveById(String id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Product product = session.find(Product.class, Integer.parseInt(id));
            transaction.commit();
            return product;
        } catch (Exception e){
            e.printStackTrace();
            if(transaction!=null)
                transaction.rollback();
            return null;
        }
    }
}

