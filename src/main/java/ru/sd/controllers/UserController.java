// This is an independent project of an individual developer. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++ and C#: http://www.viva64.com

package ru.sd.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.sd.models.User;
import ru.sd.service.UserService;
import ru.sd.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ModelAndView allUsers(){
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("allusers");
        modelAndView.addObject("userlist", users);
        return modelAndView;
    }

    @GetMapping("/edituser")
    public ModelAndView editUserPage(@RequestParam(value = "id") int id){
        User user = userService.getUserById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edituser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/edituser")
    public ModelAndView editUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.editUser(user);
        return modelAndView;
    }

    @GetMapping("/adduser")
    public ModelAndView addUserPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edituser");
        return modelAndView;
    }

    @PostMapping("/adduser")
    public ModelAndView addUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        userService.addUser(user);
        return modelAndView;
    }

    @GetMapping("/deleteuser")
    public ModelAndView deleteUser(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        User user = userService.getUserById(id);
        userService.deleteUser(user);
        return modelAndView;
    }
}
