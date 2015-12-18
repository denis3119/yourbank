package com.yourbank.service.common;


import java.util.List;

/**
 * Created by admin on 11/6/2015.
 */
public interface Service<T> {
    T add(T entity);

    void delete(T entity);

    T get(long ID);

    T update(T entity);

    List<T> update(List<T> entities);

    List<T> getAll();

}
