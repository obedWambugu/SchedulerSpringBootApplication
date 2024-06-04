package com.wambuguobed.ScheduleDemo.Service;

import com.wambuguobed.ScheduleDemo.Domain.TimeTable;
import com.wambuguobed.ScheduleDemo.Repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    private  TimeTableRepository timeTableRepository;

    /*public TimeTableServiceImpl(TimeTableRepository timeTableRepository) {
        this.timeTableRepository = timeTableRepository;
    }

    @Override
    public TimeTable update(TimeTable timeTable, Integer id) {
        return timeTableRepository.save(timeTable);
    }
    @Override
    public List<TimeTable> findAllTimeTables() {
        return timeTableRepository.findAll();
    }
    @Override
    public Optional<TimeTable> findById(int id) {
        return timeTableRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        timeTableRepository.deleteById(id);
    }*/

    public Iterable<TimeTable> list() {
        return timeTableRepository.findAll();
    }

    /*
    public List<TimeTable> listByName(String name) {
        return timeTableRepository.listByName(name);
    }*/

    public TimeTable save(TimeTable timeTable) {
        return timeTableRepository.save(timeTable);
    }

    public void save(List<TimeTable> timeTables) {
        timeTableRepository.saveAll(timeTables);
    }

    public List<TimeTable> findByTeacher(String name) {
        return timeTableRepository.findByTeacher(name);
    }

}
