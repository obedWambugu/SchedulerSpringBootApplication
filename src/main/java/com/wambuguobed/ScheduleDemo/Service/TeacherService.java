package com.wambuguobed.ScheduleDemo.Service;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TeacherService {
    Teacher save(Teacher teacher);

    // Read operation
    List<Teacher> fetchAllTeachers();

    // Update operation
    Teacher update(Teacher teacher, Integer id);

    Optional<Teacher> findById(int id);

    // Delete operation
    void deleteById(Integer id);

    String findByTeacherName(String teacherName);
}
