package ru.sd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sd.models.*;
import ru.sd.services.SubjectService;
import ru.sd.services.TimetableService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TimetableController {

    private final TimetableService timetableService;
    private final SubjectService subjectService;

    public TimetableController(TimetableService timetableService, SubjectService subjectService) {
        this.timetableService = timetableService;
        this.subjectService = subjectService;
    }

    @GetMapping("/")
    public ModelAndView allLessonView(@RequestParam(required = false) Integer selectGroupId, Model model) {
        selectGroupId = selectGroupId != null ? selectGroupId : 1;
        List<List<Timetable>> lists = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lists.add(timetableService.findByWeekDay(i, selectGroupId));
        }
        List<Subject> subjects = subjectService.findAll();
        List<LectureHall> lectureHalls = timetableService.findAllLectureHalls();
        List<Teacher> teachers = timetableService.findAllTeacher();
        List<Pgroup> pgroups = timetableService.findAllPgroup();
        Pgroup selectGroup = timetableService.findPgroupById(selectGroupId);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("lists", lists);
        modelAndView.addObject("subjects", subjects);
        modelAndView.addObject("lectureHalls", lectureHalls);
        modelAndView.addObject("teachers", teachers);
        modelAndView.addObject("pgroups", pgroups);
        modelAndView.addObject("selectGroup", selectGroup);

        model.addAttribute("title", "Расписание занятий");

        modelAndView.setViewName("timetable");
        return modelAndView;
    }

    @PostMapping("/addLesson")
    public String addLessonInTimetable(@ModelAttribute Timetable lesson){
        timetableService.addLesson(lesson);
        return "redirect:/?selectGroupId=" + lesson.getPgroup().getId() ;
    }

    @GetMapping("/deleteLesson")
    public String deleteLesson(@RequestParam Integer lessonId, @RequestParam Integer selectGroupId){
        timetableService.deleteLessonById(lessonId);
        return "redirect:/?selectGroupId=" + selectGroupId;
    }


}
