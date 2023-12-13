package com.example.demo.dao;

import com.example.demo.HibernateUtil;
import com.example.demo.entities.Country;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CountryDAO implements ActionDAO<Country>{
    @Override
    public boolean create(Country o) {
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
    public Country update(Country o) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Country cartModified = session.merge(o);
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
            Country country = session.find(Country.class, Integer.parseInt(id));
            session.remove(country);
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
    public Country retrieveById(String id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Country country = session.find(Country.class, Integer.parseInt(id));
            transaction.commit();
            return country;
        } catch (Exception e){
            e.printStackTrace();
            if(transaction!=null)
                transaction.rollback();
            return null;
        }
    }
}
