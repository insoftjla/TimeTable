package ru.sd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sd.models.Subject;
import ru.sd.services.SubjectService;

import java.util.List;

@Controller
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public ModelAndView allSubjects(Model model){
        List<Subject> subjects = subjectService.findAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("subjects", subjects);

        model.addAttribute("title", "Дисциплины");

        modelAndView.setViewName("subjects");
        return modelAndView;
    }

    @PostMapping("/addSubject")
    public String addSubject(@ModelAttribute Subject subject){
        subjectService.add(subject);
        return "redirect:/subjects";
    }

    @GetMapping("/deleteSubject")
    public String deleteSubjectById(@RequestParam Integer id){
        subjectService.deleteById(id);
        return "redirect:/subjects";
    }
}
