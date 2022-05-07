package com.learnzilla.backend.signup.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;
    public String firstName;
    public String secondName;
    public String Email;
    public String password;
}
