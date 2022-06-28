package com.springBootDemo.Controller;

import com.springBootDemo.Exceptions.ResourceNotFoundException;
import com.springBootDemo.Model.StudentDetails;
import com.springBootDemo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/saveStudent")
    public StudentDetails SaveStudentData(@RequestBody StudentDetails studentDetails){
        return   studentService.SaveStudent(studentDetails) ;
    }

    @GetMapping("/{name}")
    public StudentDetails getStudentDataByName(@PathVariable("name" ) String name) throws ResourceNotFoundException {
       return studentService.getByName(name);
    }

    @GetMapping("/{number}")
    public StudentDetails getStudentDataByNumber(@PathVariable("number" ) String number) throws ResourceNotFoundException {
        return studentService.getByNumber(number);
    }

    @DeleteMapping("/{studentNumber}")
    public String getAllStudents(@PathVariable("studentNumber") String studentNumber ) throws ResourceNotFoundException {
        return studentService.deleteByNumber(studentNumber);
    }
    @GetMapping("/getAllStudentsData")
    public List<StudentDetails> getAllStudentsRecords(){
        return studentService.getAllStudents();
    }
    @PutMapping("/updateStudent/{studentNumber}/{studentName}")
    public String updateStudentRecord(@PathVariable("studentNumber") String studentNumber, @PathVariable("studentName") String studentName){
       Object data= studentService.updateStudentDetails(studentNumber,studentName);
        return data.toString();
    }}

