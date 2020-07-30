// This is an independent project of an individual developer. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++ and C#: http://www.viva64.com

package ru.sd.dao;

import ru.sd.models.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void addUser(User user);
    void editUser(User user);
    User getUserById(int id);
    void deleteUser(User user);
}
