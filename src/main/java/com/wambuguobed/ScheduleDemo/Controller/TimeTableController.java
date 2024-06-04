package com.wambuguobed.ScheduleDemo.Controller;


import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Domain.TimeTable;
import com.wambuguobed.ScheduleDemo.Service.TimeTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TimeTableController {
    private final Logger logger = LoggerFactory.getLogger(TimeTableController.class);

    private final TimeTableService timeTableService;

    public TimeTableController(TimeTableService timeTableService) {
        this.timeTableService = timeTableService;
    }

    @PostMapping("/timetable")
    public TimeTable createTeacher(@RequestBody TimeTable timeTable) {
        return timeTableService.save(timeTable);
    }

    @PutMapping("/timetable/{id}")
    public TimeTable updateTeacher(@RequestBody TimeTable timeTable,@PathVariable Integer id) {
        return timeTableService.save(timeTable);
    }

    /*@GetMapping("")
    public Iterable<TimeTable> list() {
        return timeTableService.list();
    }*/
    @GetMapping("")
    public List<TimeTable> findbyname(String name) {
        return timeTableService.findByTeacher("Obed");
    }
}
