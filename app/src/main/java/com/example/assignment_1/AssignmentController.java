package com.example.assignment_1;

/*
Class AssignmentController :
- functional class to control the Assignment Class
*/
public class AssignmentController {
    
    // Constructor
    public AssignmentController() {
    }

    public String convert_grade_to_character(int grade) {
        // feature : convert number grade to letter grade
        if(grade <= 100 && grade >= 90) {
            return "A";
        }
        else if(grade <= 89 && grade >= 80) {
            return "B";
        }
        else if(grade <= 79 && grade >= 70) {
            return "C";
        }
        else if(grade <= 69 && grade >= 60) {
            return "D";
        }
        else if(grade <= 59 && grade >= 0) {
            return "F";
        }
        else{
            return "Z"; // should never get here
        }
    }
}