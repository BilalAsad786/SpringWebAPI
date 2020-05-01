package com.restfulspring.apiexample.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(value = "ID")
    private int id;
    @JsonProperty(value = "Name")
    @NotNull(message = "Name cann't be null")
    @Size(min = 2, max = 100, message = "Name must be minimum 2 characters and maximum 100 characters long")
    private String name;
    @Email
    private String email;
    @JsonProperty(value = "Age")
    @Min(8)
    @Max(110)
    private int age;
    @JsonProperty(value = "Height")
    private double height;
    @JsonProperty(value = "CNIC")
    @Pattern(regexp = "^\\(?(\\d{5})\\)?[-]?(\\d{7})[-]?(\\d{1})$", message = "CNIC sholud be in format xxxxx-xxxxxxx-x")
    private String cnic;
    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate doB;
}
