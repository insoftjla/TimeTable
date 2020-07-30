// This is an independent project of an individual developer. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++ and C#: http://www.viva64.com

package ru.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sd.dao.UserDAO;
import ru.sd.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }

    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    public void editUser(User user) {
        userDAO.editUser(user);
    }

    @Transactional
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }
}
