package com.wambuguobed.ScheduleDemo.Service;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Domain.TimeTable;
import com.wambuguobed.ScheduleDemo.Repository.TimeTableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    private final Logger logger = LoggerFactory.getLogger(TimeTableServiceImpl.class);
    @Autowired
    private  TimeTableRepository timeTableRepository;

    @Override
    public TimeTable save(TimeTable timeTable) {
        logger.info("Saving TimeTable");
        return timeTableRepository.save(timeTable);
    }

    @Override
    public TimeTable findById(int id){
        logger.info("Finding TimeTable by ID");
        TimeTable timeTable = timeTableRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("TimeTable not found"));
        return timeTable;
    }

    @Override
    public TimeTable updateTeacher(Integer id, String newTeacher) {
        logger.info("Updating teacher with ID");
        TimeTable timeTable = timeTableRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("TimeTable not found"));
        timeTable.setTeacher(newTeacher);
        return timeTableRepository.save(timeTable);
    }

    @Override
    public List<TimeTable> fetchAllTimeTables(){
        logger.info("Fetching all TimeTables");
        List<TimeTable> timetables = timeTableRepository.findAll();
        return timetables;
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("Deleting TimeTable with ID");
        TimeTable timeTable = timeTableRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("TimeTable not found"));
        timeTableRepository.deleteById(id);
    }
}
