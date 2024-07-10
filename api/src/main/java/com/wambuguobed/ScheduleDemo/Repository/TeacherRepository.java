package com.wambuguobed.ScheduleDemo.Repository;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Teacher findByFirstName(String firstName);
}
