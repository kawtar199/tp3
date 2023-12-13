package com.example.demo.dao;


import java.util.List;

public interface ActionDAO <T>{
    public  boolean create(T o);
    public T update(T o);
    public boolean deleteById(String id);
    public T retrieveById(String id);

}
