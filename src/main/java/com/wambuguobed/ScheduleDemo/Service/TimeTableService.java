package com.wambuguobed.ScheduleDemo.Service;

import com.wambuguobed.ScheduleDemo.Domain.TimeTable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TimeTableService {

    /*TimeTable save(TimeTable timeTable);

    // Read operation
    List<TimeTable> findAllTimeTables();

    // Update operation
    TimeTable update(TimeTable timeTable, Integer id);

    Optional<TimeTable> findById(int id);

    // Delete operation
    void deleteById(Integer id);*/

    Iterable<TimeTable> list();

    //List<TimeTable> listByName(String name);

    TimeTable save(TimeTable timeTable);

    void save(List<TimeTable> timeTables);

    List<TimeTable> findByTeacher(String teacherName);

}
