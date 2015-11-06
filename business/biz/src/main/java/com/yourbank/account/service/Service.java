package com.yourbank.account.service;

import com.sun.istack.internal.NotNull;
import com.yourbank.account.User;

/**
 * Created by admin on 11/6/2015.
 */
public interface Service<T> {
    T add(@NotNull T entity);

    void delete(@NotNull T entity);

    T get(long ID);

    T update(T entity);
}
