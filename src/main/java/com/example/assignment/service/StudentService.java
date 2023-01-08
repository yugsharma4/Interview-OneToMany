package com.example.assignment.service;

import com.example.assignment.Laptop;
import com.example.assignment.Student;
import com.example.assignment.repository.LaptopRepository;
import com.example.assignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    LaptopRepository laptopRepository;

    //create new student
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    //get student
    public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }

    //add laptop to student
    public void addLaptopToStdId(int stud_id, int lap_id){
        Student student = studentRepository.findById(stud_id).get();
        Laptop laptop = laptopRepository.findById(lap_id).get();

        List<Laptop> previousLaptopList = student.getLaptops();

        //list is null then create new one
        if(previousLaptopList == null){
            previousLaptopList = new ArrayList<>();
        }else{
           previousLaptopList.add(laptop);
        }

        laptop.setStudent(student);
        student.setLaptops(previousLaptopList);
        studentRepository.save(student);
        laptopRepository.save(laptop);
    }

    //Get laptops list by student id
    public List<Laptop> getLaptopListByStudentId(int stud_id){
        return studentRepository.findById(stud_id).get().getLaptops();
    }
}
