package com.springBootDemo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Address {

    private int flatNumber;

    private String streetName;
    private String city;


    @Size(min = 6, max = 6, message
            = "About Me must be 6 numbers")

    private int pinCode;
}
