package com.wambuguobed.ScheduleDemo.Controller;


import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Domain.TimeTable;
import com.wambuguobed.ScheduleDemo.Service.TimeTableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/timetables")
public class TimeTableRestController {
    private final TimeTableService timeTableService;

    public TimeTableRestController(TimeTableService timeTableService) {
        this.timeTableService = timeTableService;
    }

    //Add Timetable REST API
    @PostMapping("")
    public ResponseEntity<TimeTable> createTimeTable(@RequestBody TimeTable timeTable){
        return new ResponseEntity<>(timeTableService.save(timeTable), HttpStatus.CREATED);
    }
    //Get Timetable REST API
    @GetMapping("/{id}")
    public ResponseEntity<TimeTable> fetchTimeTable(@PathVariable int id){
        TimeTable timeTable = timeTableService.findById(id);
        return ResponseEntity.ok(timeTable);
    }
    //Update teacher REST API
    @PutMapping("/{id}/updateTeacher")
    public ResponseEntity<TimeTable> updateTeacher(@PathVariable int id,
                                                  @RequestBody Map<String,String> request){
        TimeTable timeTable = timeTableService.updateTeacher(id, request.get("teacher"));
        return ResponseEntity.ok(timeTable);
    }

    //Get All Timetables REST API
    @GetMapping("")
    public ResponseEntity<List<TimeTable>> fetchAllTimeTables(){
        List<TimeTable> timeTables = timeTableService.fetchAllTimeTables();
        return ResponseEntity.ok(timeTables);
    }

    //Delete Timetable Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Integer id){
        timeTableService.deleteById(id);
        return ResponseEntity.ok("Timetable deleted successfully");
    }
}
