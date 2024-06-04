package com.wambuguobed.ScheduleDemo.Service;

import com.wambuguobed.ScheduleDemo.Domain.Teacher;
import com.wambuguobed.ScheduleDemo.Repository.TeacherRepository;
import org.hibernate.validator.internal.constraintvalidators.bv.NullValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    /*public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }*/
    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> fetchAllTeachers(){
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public Teacher update(Teacher teacher, Integer id) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteById(Integer id) {
      teacherRepository.deleteById(id);
    }

    @Override
    public String findByTeacherName(String teacherName) {
        return teacherName;
    }

    @Override
    public Optional<Teacher> findById(int id) {
        return teacherRepository.findById(id);
    }

}
