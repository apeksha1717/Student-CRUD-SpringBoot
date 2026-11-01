package com.example.crudSpringBoot.controller;

import java.lang.Boolean;
import com.example.crudSpringBoot.entity.Student;
import com.example.crudSpringBoot.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        Student createdStudent = studentService.createStudent(student);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student studentResp = studentService.getStudent(id);

        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();

        if (studentList == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studentList);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student student) {
        Student studentResp = studentService.updateStudent(id, student);

        if (studentResp == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentResp);


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {

        Boolean isDeleted = studentService.deleteStudent(id);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record deleted successfully");
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable long id) {

        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if (!isDeleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Record deleted successfully");
    }

}
