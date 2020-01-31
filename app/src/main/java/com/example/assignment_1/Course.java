package com.example.assignment_1;

import java.util.List;

public class Course {

    // Variables
    String title;
    int averageGrade;
    List<Assignment> assignmets;

    // Constructor
    public Course(String title, int averageGrade, List<Assignment> assignments) {

        // init variables
        this.title = title;
        this.averageGrade = averageGrade;
        this.assignmets = assignments;
    }

    // Get Methods
    public String getTitle() {
        return "Course Title : " + this.title; // should it be this.name ?
    }

    public int getAverageGrade() {
        return this.averageGrade; // should it be this.name ?
    }

    public List<Assignment> getAssignmets(){
        return this.assignmets;
    }
}