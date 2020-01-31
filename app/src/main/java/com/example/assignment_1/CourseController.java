package com.example.assignment_1;

import java.util.List;

public class CourseController {

    // Constructor
    public CourseController() {

    }

    public int calculate_avg_grade(List<Assignment> assignments) {
        int sumGrade = 0;
        int count = 0;
        for(Assignment item : assignments){
            sumGrade = sumGrade + item.grade;
            count = count + 1;
        }

        int averageGrade = sumGrade/count;

        return averageGrade;
    }
}