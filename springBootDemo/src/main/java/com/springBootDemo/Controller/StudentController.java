package com.springBootDemo.Controller;

import  com.springBootDemo.Exceptions.InputsDataErrors;
import com.springBootDemo.Exceptions.ResourceNotFoundException;
import com.springBootDemo.Model.StudentDetails;
import com.springBootDemo.Service.StudentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@SecurityRequirement(name = "javainuseapi")

@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/saveStudent")
    public StudentDetails SaveStudentData(@Valid @RequestBody StudentDetails studentDetails) throws InputsDataErrors {


        if (null!=studentDetails){
      return studentService.SaveStudent(studentDetails);
        } else {
            throw new InputsDataErrors("please enter valid in");
        }



    }

    @GetMapping("/byname/{name}")
    public StudentDetails getStudentDataByName(@PathVariable("name" ) String name) throws ResourceNotFoundException {
       return studentService.getByName(name);
    }

    @GetMapping("/{number}")
    public StudentDetails getStudentDataByNumber(@PathVariable("number" ) String number) throws ResourceNotFoundException {
        return studentService.getByNumber(number);


    }

    @DeleteMapping("deleteByNumber/{studentNumber}")
    public String getAllStudents(@PathVariable("studentNumber") String studentNumber ) throws ResourceNotFoundException {
        return studentService.deleteByNumber(studentNumber);
    }
    @GetMapping("/getAllStudentsData")
    public List<StudentDetails> getAllStudentsRecords(){
        return studentService.getAllStudents();
    }

    @GetMapping("/byCity/{cityName}")
    public List<StudentDetails> getAllStudentsRecordsByLocation(@PathVariable("cityName") String cityName) throws InputsDataErrors {
if (null!=cityName){

    return studentService.getAllREcordsWithLoction(cityName);
    }
    else{
        throw new InputsDataErrors("please enter sufficient input required data");
    }
}
    @PutMapping("/updateStudent/{studentNumber}/{studentName}")
    public String updateStudentRecord(@PathVariable("studentNumber") String studentNumber, @PathVariable("studentName") String studentName){
       Object data= studentService.updateStudentDetails(studentNumber,studentName);
        return data.toString();
    }}

