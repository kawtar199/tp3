package com.example.demo.dao;


import com.example.demo.HibernateUtil;
import com.example.demo.entities.Cart;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class CartDAO implements ActionDAO<Cart> {


    @Override
    public boolean create(Cart o) {
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
    public Cart update(Cart o) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Cart cartModified = session.merge(o);
            transaction.commit();
            return cartModified;
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
            Cart cart = session.find(Cart.class, Integer.parseInt(id));
            session.remove(cart);
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
    public Cart retrieveById(String id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Cart cart = session.find(Cart.class, Integer.parseInt(id));
            transaction.commit();
            return cart;
        } catch (Exception e){
            e.printStackTrace();
            if(transaction!=null)
                transaction.rollback();
            return null;
        }
    }}
