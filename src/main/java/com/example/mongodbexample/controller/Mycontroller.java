//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.mongodbexample.controller;

import com.example.mongodbexample.model.Student;
import com.example.mongodbexample.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/student"})
public class Mycontroller {
    @Autowired
    private StudentRepository studentRepository;

    public Mycontroller() {
    }

    @PostMapping({"/"})
    public String addStudent(@RequestBody Student student) {
        Student save = (Student)this.studentRepository.save(student);
        return "data entered";
    }

    @GetMapping({"/"})
    public ResponseEntity<?> getStudents() {
        return ResponseEntity.ok(this.studentRepository.findAll());
    }

    @DeleteMapping({"{id}"})
    public String deleteById(@PathVariable("id") Student id) {
        this.studentRepository.delete(id);
        return "Deleted";
        
    }

    @DeleteMapping({"/"})
    public String delete(@RequestBody Student student) {
        this.studentRepository.deleteAll();
        return "Deleted";
    }
    @PutMapping({"/"})
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        return ResponseEntity.ok((Student)this.studentRepository.save(student));
    }
}
