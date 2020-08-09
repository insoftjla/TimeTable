package ru.sd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.sd.models.Role;
import ru.sd.models.UserLogin;
import ru.sd.repositories.UserRepository;

import java.util.Collections;

@Controller
public class AuthenticationController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(UserLogin user, Model model){
        UserLogin userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null){
            model.addAttribute("userExists","Пользователь уже существует!");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
