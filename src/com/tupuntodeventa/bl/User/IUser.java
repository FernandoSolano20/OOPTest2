package com.tupuntodeventa.bl.User;

import java.util.List;

public interface IUser {
    List<User> getAll() throws Exception;

    String save(User user) throws Exception;

    boolean isAdminOnDB() throws Exception;

    User login(String email, String pass) throws Exception;

    User getById(User user) throws Exception;
}
