package com.wambuguobed.ScheduleDemo.Controller;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Domain.TimeTable;
import com.wambuguobed.ScheduleDemo.Service.TeacherService;
import com.wambuguobed.ScheduleDemo.Service.TimeTableService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final TimeTableService timeTableService;
    private String name;
    public TeacherController(TeacherService teacherService, TimeTableService timeTableService) {
        this.teacherService = teacherService;
        this.timeTableService = timeTableService;
    }
    @GetMapping("")
    public String getTeachers(Model model){
        List<Teacher>  teachers =teacherService.fetchAllTeachers();
        model.addAttribute("teachers",teachers);
        model.addAttribute("teacher",new Teacher());
        return"teachers";
    }
//    @PostMapping("")
//    public String createTeacher(@ModelAttribute Teacher teacher){
//        teacherService.save(teacher);
//        return"redirect:/home";
//    }
    @PostMapping("")
    public RedirectView createTeacher(RedirectAttributes redirectAttributes, @ModelAttribute Teacher teacher){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(teacher.getPassword());
        teacher.setPassword(encodedPassword);
        teacherService.save(teacher);
        Teacher newTeacher = new Teacher();
        newTeacher.setFirstName(teacher.getFirstName());
        name = newTeacher.getFirstName();
        System.out.println(" "+ name);
        String message="Created user <b>"+teacher.getFirstName()+" "+teacher.getLastName()+"</b> ✨.";
        RedirectView redirectView = new RedirectView("/teacher/register_success",true);
        redirectAttributes.addFlashAttribute("userMessage",message);
        return redirectView;
    }
    @GetMapping("/{id}")
    public String getUser(Model model,@PathVariable("id") Integer id){
        Optional<Teacher> teacher=teacherService.findById(id);
        model.addAttribute("teacher",teacher);
        return "timeTables";
    }

    /*@PostMapping("/{id}")
    public RedirectView updateUser(RedirectAttributes redirectAttributes, @ModelAttribute Teacher teacher,@PathVariable("id") Integer id) {
        teacherService.update(teacher, id);
        String message = (teacher.isActive()? "Updated " : "Deleted ") + " user <b>" + teacher.getFirstName() + " " + teacher.getLastName() + "</b> ✨.";
        RedirectView redirectView = new RedirectView("/teacher", true);
        redirectAttributes.addFlashAttribute("userMessage", message);
        return redirectView;
    }*/
    @GetMapping("/timeTable")
    public String getTimeTables(Model model){
        List<TimeTable> timeTables = timeTableService.findByTeacher(name);
        System.out.println("This is the name "+ name);
        model.addAttribute("timeTables",timeTables);
        model.addAttribute("timeTable",new TimeTable());
        return"timeTables";
    }

    @GetMapping("/register_success")
    public String processRegister() {
        return "register_success";
    }

    @GetMapping("/check_schedule")
    public String schedule() {
        return "check_schedule";
    }
}
