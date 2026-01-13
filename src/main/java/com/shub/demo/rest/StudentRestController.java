package com.shub.demo.rest;

import com.shub.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student>res;
    //add @PostController such that this load only once
    @PostConstruct
    public void stud(){
        res=new ArrayList<>();
        res.add(new Student("Shubham","Kadbhane"));
        res.add(new Student("Aditya","Del"));
        res.add((new Student("Abbil","Day")));
    }


    @GetMapping("/student")
    public List<Student> getStudent(){
        return res;
    }
    //define endpoint or "/student/{studentId}"- return student at index

    @GetMapping("/student/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        //check student id against the list size
        if(studentId> res.size()||studentId<0){
            throw new StudentNotFoundException("Student id not found : "+studentId);
        }

        return res.get(studentId);
    }


}
