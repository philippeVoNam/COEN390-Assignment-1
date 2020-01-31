package com.example.assignment_1;

public class Profile {

    // Variables
    String name;
    int age;
    int studentID;

    // Constructor
    public Profile(String name, int age, int studentID) {

        // init variables
        this.name = name;
        this.age = age;
        this.studentID = studentID;
    }

    // Get Methods
    public String getName() {
        return name; // should it be this.name ?
    }

    public int getAge() {
        return age; // should it be this.name ?
    }

    public int getStudentID() {
        return studentID; // should it be this.name ?
    }
}