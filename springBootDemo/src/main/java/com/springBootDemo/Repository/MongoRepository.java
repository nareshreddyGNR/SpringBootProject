package com.springBootDemo.Repository;

import com.springBootDemo.Exceptions.ResourceNotFoundException;
import com.springBootDemo.Model.StudentDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class MongoRepository {
    private final MongoTemplate mongoTemplate;

    public MongoRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public StudentDetails save(StudentDetails details) {
        log.info("saved the student record into dB with the name : "+details.getStudentName());
        return mongoTemplate.save(details);

    }

    public StudentDetails getByname(String name) {
        Query query= new Query();
        query.addCriteria(Criteria.where("studentName").is(name));
return mongoTemplate.findOne(query,StudentDetails.class);
    }

    public StudentDetails getStudentByNumber(String number) {
        Query query= new Query();
        query.addCriteria(Criteria.where("studentNumber").is(number));
        return mongoTemplate.findOne(query,StudentDetails.class);
    }

    public List<StudentDetails> getAllStudentsrecords() {

        return mongoTemplate.findAll(StudentDetails.class);
    }

    public String deleteByName(String studentNumber) throws ResourceNotFoundException {
        Query query= new Query();
        query.addCriteria(Criteria.where("studentNumber").is(studentNumber));
        mongoTemplate.remove(query,StudentDetails.class);
        return "removed the record studentNumber : "+studentNumber;
    }

    public StudentDetails updateStudentData(String studentNumber, String studentName) {

        StudentDetails student=getByname(studentName);
    student.setStudentNumber(studentNumber);


        return mongoTemplate.save(student);

    }
}