package com.wambuguobed.ScheduleDemo.Service;

import com.wambuguobed.ScheduleDemo.Controller.TimeTableRestController;
import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Repository.TeacherRepository;
import org.apache.coyote.BadRequestException;
import org.hibernate.validator.internal.constraintvalidators.bv.NullValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TeacherServiceImpl implements TeacherService {
    private final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    private TeacherRepository teacherRepository;
    /*public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }*/
    @Override
    public Teacher save(Teacher teacher) {
        logger.info("Saving teacher " + teacher.getFirstName() + " " + teacher.getLastName());
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher findById(int id){
        logger.info("Finding teacher with id " + id);
        Teacher teacher = teacherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        return teacher;
    }

    @Override
    public Teacher updatePassword(Integer id, String newPassword) {
        logger.info("Updating password for teacher with id " + id);
        Teacher teacher = teacherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacher.setPassword(newPassword);
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> fetchAllTeachers(){
        logger.info("Fetching all teachers");
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("Deleting teacher with id " + id);
        Teacher teacher = teacherRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        teacherRepository.deleteById(id);
    }

    @Override
    public Teacher findByFirstName(String firstName){
        Teacher teacherName = teacherRepository
                .findByFirstName(firstName);
        if (teacherName == null) {
            // handle exception
        }
        return teacherName;
    }

}
