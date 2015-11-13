package com.yourbank.account.service;


/**
 * Created by admin on 11/6/2015.
 */
public interface Service<T> {
    T add(T entity);

    void delete(T entity);

    T get(long ID);

    T update(T entity);
}
