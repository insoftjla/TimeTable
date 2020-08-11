package ru.sd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sd.models.Teacher;
import ru.sd.services.TeacherService;

import java.util.List;

@Controller
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public ModelAndView allTeachers(Model model){
        List<Teacher> teachers = teacherService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("teachers", teachers);

        model.addAttribute("title", "Преподаватели");

        modelAndView.setViewName("teachers");
        return modelAndView;
    }

    @PostMapping("/addTeacher")
    public String addTeacher(@ModelAttribute Teacher teacher){
        teacherService.add(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/deleteTeacher")
    public String deleteTeacher(@RequestParam Integer id){
        teacherService.deleteById(id);
        return "redirect:/teachers";
    }
}
