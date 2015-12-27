package com.yourbank.service.user;


import com.yourbank.data.model.user.User;

import java.util.List;

/**
 * @author admin.
 */
public interface UserService {
    User register(User user);

    User getByName(String name);

    void delete(User user);

    User update(User user);

    List<User> getAll();
}
