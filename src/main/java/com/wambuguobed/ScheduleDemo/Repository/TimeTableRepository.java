package com.wambuguobed.ScheduleDemo.Repository;

import com.wambuguobed.ScheduleDemo.Domain.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimeTableRepository extends JpaRepository<TimeTable, Integer> {
//    @Query("select m from TimeTable m where m.teacher = ?1")
    List<TimeTable> findByTeacher(String teacherName);
}
