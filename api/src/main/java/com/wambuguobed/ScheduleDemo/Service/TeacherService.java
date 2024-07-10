package com.wambuguobed.ScheduleDemo.Service;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TeacherService {
    //save operation
    Teacher save(Teacher teacher);

    //find operation
    Teacher findById(int id);

    // Update operation
    Teacher updatePassword(Integer id, String newPassword);

    // Read operation
    List<Teacher> fetchAllTeachers();

    // Delete operation
    void deleteById(Integer id);

    Teacher findByFirstName(String firstName);
}
