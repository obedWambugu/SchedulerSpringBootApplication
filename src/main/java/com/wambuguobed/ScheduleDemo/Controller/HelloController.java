package com.wambuguobed.ScheduleDemo.Controller;

import com.wambuguobed.ScheduleDemo.Service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class HelloController {
    @RequestMapping("/hello")
    public String home(){
        return "hello";
    }
}
