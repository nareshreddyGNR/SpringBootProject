package com.springBootDemo.Service;

import com.springBootDemo.Exceptions.ResourceNotFoundException;
import com.springBootDemo.Model.StudentDetails;
import com.springBootDemo.Repository.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    public MongoRepository studentRepo;



public StudentDetails SaveStudent(StudentDetails studentDetails){
   return studentRepo.save(studentDetails);
}
public StudentDetails getByName(String name) {
    return studentRepo.getByname(name);
}
    public StudentDetails getByNumber(String number) {
        return studentRepo.getStudentByNumber(number);
    }
    public List<StudentDetails> getAllStudents() {
    return studentRepo.getAllStudentsrecords();
    }

    public String deleteByNumber(String studentNumber) throws ResourceNotFoundException {
    return studentRepo.deleteByName(studentNumber);
    }

    public String updateStudentDetails(String studentNumber, String studentName) {
       Object data= studentRepo.updateStudentData(studentNumber,studentName);
    return data.toString();
    }
}
