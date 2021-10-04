package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 


@RestController
@RequestMapping("/api/")
@CrossOrigin(origins ="*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/allstudent")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @PostMapping("/addstudent")
    public Student createStudent(@RequestBody Student student) {
    	return studentRepository.save(student);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Optional<Student>> getstudentbyid(@PathVariable Long id){
        Optional<Student> student = studentRepository.findById(id);
        return ResponseEntity.ok(student);
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updatesutdent(@PathVariable Long id,@RequestBody Student studentdetails){
        Student student = studentRepository.findById(id).orElse(null);
        student.setFirstname(studentdetails.getFirstname());
        student.setLastname(studentdetails.getLastname());
        student.setEmailid(studentdetails.getEmailid());
        
        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);

    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Map<String, Boolean>> deletestudent(@PathVariable  Long id){
        Student student = studentRepository.findById(id).orElse(null);

        studentRepository.delete(student);
        Map<String,Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }


}
