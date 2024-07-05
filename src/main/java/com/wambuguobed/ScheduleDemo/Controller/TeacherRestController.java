package com.wambuguobed.ScheduleDemo.Controller;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherRestController {
    //private final Logger logger = LoggerFactory.getLogger(TeacherRestController.class);

    private final TeacherService teacherService;

    public TeacherRestController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //Add Teacher REST API
    @PostMapping("")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(teacher.getPassword());
        teacher.setPassword(encodedPassword);
        return new ResponseEntity<>(teacherService.save(teacher), HttpStatus.CREATED);
    }
    //Get Teacher REST API
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> fetchTeacher(@PathVariable int id){
        Teacher teacher = teacherService.findById(id);
        return ResponseEntity.ok(teacher);
    }
    //Get Teacher by firstName REST API
    @GetMapping("/name/{name}")
    public ResponseEntity<Teacher> fetchTeacher(@PathVariable String name){
        Teacher teacher = teacherService.findByFirstName(name);
        return ResponseEntity.ok(teacher);
    }
    //Update password REST API
    @PutMapping("/{id}/updatePassword")
    public ResponseEntity<Teacher> updatePassword(@PathVariable int id,
                                                  @RequestBody Map<String,String> request){
        Teacher teacher = teacherService.updatePassword(id, request.get("password"));
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(teacher.getPassword());
        teacher.setPassword(encodedPassword);
        return ResponseEntity.ok(teacher);
    }

    //Get All Teachers REST API
    @GetMapping("")
    public ResponseEntity<List<Teacher>> fetchAllTeachers(){
        List<Teacher> teachers = teacherService.fetchAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    //Delete Teacher Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Integer id){
        teacherService.deleteById(id);
        return ResponseEntity.ok("Teacher deleted successfully");
    }

}
