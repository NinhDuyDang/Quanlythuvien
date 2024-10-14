package com.example.managerlibrary.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.Date;

@Entity
@Table(name = "employess")
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer employeeId;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private String  age;
    @Column(name = "startedDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
    private Date startedDate;
    @Column(name = "type")
    private String type;

    public Employee(Integer employeeId, String name, String age, Date startedDate, String type) {
        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.startedDate = startedDate;
        this.type = type;
    }
    public Employee() {

    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate() {
        this.startedDate = startedDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
