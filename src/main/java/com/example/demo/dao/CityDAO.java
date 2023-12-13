package com.example.demo.dao;

import com.example.demo.HibernateUtil;
import com.example.demo.entities.City;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CityDAO implements ActionDAO<City>{
    @Override
    public boolean create(City o) {
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
    public City update(City o) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            City city = session.merge(o);
            transaction.commit();
            return city;
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
            City city = session.find(City.class, Integer.parseInt(id));
            session.remove(city);
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
    public City retrieveById(String id) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            City city = session.find(City.class, Integer.parseInt(id));
            transaction.commit();
            return city;
        } catch (Exception e){
            e.printStackTrace();
            if(transaction!=null)
                transaction.rollback();
            return null;
        }
    }
}

