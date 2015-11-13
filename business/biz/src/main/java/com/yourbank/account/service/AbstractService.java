package com.yourbank.account.service;

import org.springframework.stereotype.Service;

/**
 * Created by admin on 11/6/2015.
 */
@Service
public interface AbstractService<T> {
    T add(T entity);

    void delete(T entity);

    T get(long ID);

    T update(T entity);
}
