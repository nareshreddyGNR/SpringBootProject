package com.springBootDemo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Address {

    private int flatNumber;

    private String streetName;
    private String city;
    private int pinCode;
}
