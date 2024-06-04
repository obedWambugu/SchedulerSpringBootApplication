package com.wambuguobed.ScheduleDemo.Controller;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherRestController {
    private final Logger logger = LoggerFactory.getLogger(TeacherRestController.class);

    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("")
    public List<Teacher> fetchAllTeachers(){
        return (List<Teacher>)teacherService.fetchAllTeachers();
    }
    @GetMapping("/{id}")
    public Optional<Teacher> findOne(@PathVariable Integer id){
        return teacherService.findById(id);
    }

    @PostMapping("")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @PutMapping("{id}")
    public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable Integer id) {
        return teacherService.update(teacher,id);
    }


}
