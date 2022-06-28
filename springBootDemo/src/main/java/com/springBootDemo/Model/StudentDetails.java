package com.springBootDemo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@NotNull

@Document(collection ="StudentData")
public class StudentDetails extends VersionedBaseEntity {
    @NotNull
    @NotEmpty
    private String studentName;
    private String studentNumber;
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;
    @Min(value = 0, message = "standard should not be less than 0")
    @Max(value = 12, message = "standard should not be greater than 12")
    private int standard;
    private Address studentAddress;

}
