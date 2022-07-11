package com.springBootDemo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.Valid;
import javax.validation.constraints.*;


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

    @Pattern(regexp="^[0-9]{5}")
    @Valid
    private long age;
   @Size(min = 2,max =8 ,message = "enter valid input between 2 to 8")
    @NotEmpty
    private int standard;
    private Address studentAddress;

}
