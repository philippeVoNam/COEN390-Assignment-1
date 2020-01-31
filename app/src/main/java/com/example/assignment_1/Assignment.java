package com.example.assignment_1;

/*
Class Assignment :
- class to represent the assignments
*/
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
        return idStr; 
    }

    public String getGradeStr() {
        String gradeStr = "Grade : " + String.valueOf(this.grade);
        return gradeStr; 
    }

    public int getGrade() { return this.grade; }
}