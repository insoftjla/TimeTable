package ru.sd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sd.models.LessonType;
import ru.sd.models.TimeTable;
import ru.sd.repos.LessonTypesRepo;
import ru.sd.repos.TimeTableRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TimeTableController {

    @Autowired
    private TimeTableRepo timeTableRepo;
    @Autowired
    private LessonTypesRepo lessonTypesRepo;

    @GetMapping("/")
    public ModelAndView allLessonView(Model model) {
        List<TimeTable> timeTables = (List<TimeTable>) timeTableRepo.findAll();
        List<LessonType> lessonTypes = (List<LessonType>) lessonTypesRepo.findAll();
        Map<Integer, List<TimeTable>> timetableMap = new HashMap<>();

        int i = 0;
        List<TimeTable> tmpTables = new ArrayList<>();
        for (int k = 0; k < 6; k++) {
            for (int l = 0; l < 5; l++) {
                tmpTables.add(timeTables.get(i));
                i++;
            }
            timetableMap.put(k, new ArrayList<TimeTable>(tmpTables));
            tmpTables.clear();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("timetableMap", timetableMap);
        modelAndView.addObject("lessontypelist", lessonTypes);
        model.addAttribute("title", "Расписание занятий");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView allLessonEdit(Model model) {
        List<TimeTable> timeTables = (List<TimeTable>) timeTableRepo.findAll();
        Map<Integer, List<TimeTable>> timetableMap = new HashMap<>();

        int i = 0;
        List<TimeTable> tmpTables = new ArrayList<>();
        for (int k = 0; k < 6; k++) {
            for (int l = 0; l < 5; l++) {
                tmpTables.add(timeTables.get(i));
                i++;
            }
            timetableMap.put(k, new ArrayList<TimeTable>(tmpTables));
            tmpTables.clear();
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("timetable");
        modelAndView.addObject("timetableMap", timetableMap);
        model.addAttribute("title", "Расписание занятий редактирование");
        return modelAndView;
    }

}
