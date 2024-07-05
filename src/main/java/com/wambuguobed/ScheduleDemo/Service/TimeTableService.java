package com.wambuguobed.ScheduleDemo.Service;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Domain.TimeTable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TimeTableService {

    TimeTable save(TimeTable timeTable);

    //find operation
    TimeTable findById(int id);

    // Update operation
    TimeTable updateTeacher(Integer id, String newTeacher);

    // Read operation
    List<TimeTable> fetchAllTimeTables();

    // Delete operation
    void deleteById(Integer id);
}
