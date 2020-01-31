package com.example.assignment_1;

public class Assignment {
    // Variables
    int id;
    int grade;

    // Constructor
    public Assignment(int id, int grade) {

        // init variables
        this.id = id;
        this.grade = grade;
    }

    // Get Methods
    public String getIDStr() {
        String idStr = "Assignment ID : " + String.valueOf(this.id);
        return idStr; // should it be this.name ?
    }

    public String getGradeStr() {
        String gradeStr = "Grade : " + String.valueOf(this.grade);
        return gradeStr; // should it be this.name ?
    }

    public int getGrade() { return this.grade; }
}