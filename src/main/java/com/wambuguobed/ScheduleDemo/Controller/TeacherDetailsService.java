package com.wambuguobed.ScheduleDemo.Controller;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Repository.TeacherRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class TeacherDetailsService implements UserDetailsService {
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        Teacher teacher = teacherRepository.findByFirstName(firstName);
        if (teacher == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new TeacherUserDetails(teacher);
    }

}
