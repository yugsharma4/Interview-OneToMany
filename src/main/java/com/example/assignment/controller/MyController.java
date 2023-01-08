package com.example.assignment.controller;

import com.example.assignment.Laptop;
import com.example.assignment.Student;
import com.example.assignment.service.LaptopService;
import com.example.assignment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//One student has many laptops

@RestController
public class MyController {

    @Autowired
    StudentService studentService;

    @Autowired
    LaptopService laptopService;

    //Add Student
    @PostMapping("/student/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity("Added Student!!!", HttpStatus.CREATED);
    }

    //Get Student
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.ACCEPTED);
    }

    //Add laptop
    @PostMapping("/laptop/add-laptop")
    public ResponseEntity<String> addLaptop(@RequestBody Laptop laptop){
        laptopService.addLaptop(laptop);
        return new ResponseEntity("Added Laptop!!!", HttpStatus.CREATED);
    }

    //Get Laptop
    @GetMapping("/laptop/{id}")
    public ResponseEntity<Laptop> getLaptop(@PathVariable("id") int id){
        return new ResponseEntity<>(laptopService.getLaptop(id),HttpStatus.ACCEPTED);
    }

    //Add laptop to student
    @PostMapping("/add-laptops-student")
    public ResponseEntity<String> addLaptopToStdId(@RequestParam("stud_id")int stud_id,@RequestParam("lap_id")int lap_id){
        studentService.addLaptopToStdId(stud_id,lap_id);
        return new ResponseEntity<>("Laptop has been added to student id: " + stud_id, HttpStatus.OK);
    }

    @GetMapping("/get-laptops-by-student-id")
    public ResponseEntity<List<Laptop>> getLaptopListByStudentId(@RequestParam int id){
        return new ResponseEntity<>(studentService.getLaptopListByStudentId(id),HttpStatus.ACCEPTED);
    }
}
