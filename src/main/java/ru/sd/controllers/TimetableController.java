package ru.sd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sd.models.Subject;
import ru.sd.models.Timetable;
import ru.sd.services.TimetableService;

import java.util.List;

@Controller
public class TimetableController {

    @Autowired
    private TimetableService timetableService;

    @GetMapping("/")
    public ModelAndView allLessonView(Model model) {
        List<Timetable> timeTables = timetableService.findAll();
        List<Subject> subjects = timetableService.findAllSubjects();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("timetable");
        modelAndView.addObject("timeTables", timeTables);
        modelAndView.addObject("subjects", subjects);
        model.addAttribute("title", "Расписание занятий");
        return modelAndView;
    }

    @PostMapping("/addLesson")
    public String addLessonInTimetable(@ModelAttribute Timetable lesson){
        timetableService.addLesson(lesson);
        return "redirect:/";
    }


}
