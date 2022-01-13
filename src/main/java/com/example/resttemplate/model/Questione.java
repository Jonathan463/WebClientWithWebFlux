package com.example.resttemplate.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
//@Entity
public class Questione extends AuditModel{

//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
    private Long id;
    private String title;
    private String description;
}
