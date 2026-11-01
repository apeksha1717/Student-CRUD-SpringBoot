package com.example.crudSpringBoot.service;

import com.example.crudSpringBoot.entity.Student;
import com.example.crudSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.management.openmbean.CompositeDataSupport;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq) {
        studentReq.setDeleted(false);
        Student studentResp = studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);

        if (studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {

        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if (!existingStudent.isPresent()) {
            return null;
        }

        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollno(studentReq.getRollno());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setEmail(studentReq.getEmail());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setDeleted(false);

        return studentRepository.save(studentToSave);
    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent)return false;

        studentRepository.deleteById(id);

        return true;
    }

    public Boolean deleteStudentSoftly(Long id){
       Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()) {
            return false;
        }
        Student studentToSave = existingStudent.get();

        studentToSave.setDeleted(true);

        studentRepository.save(studentToSave);

        return true;
    }
}