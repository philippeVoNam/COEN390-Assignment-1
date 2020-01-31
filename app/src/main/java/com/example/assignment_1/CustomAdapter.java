package com.example.assignment_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/*
Class CustomAdapter:
- class to contain the data to be displayed in the "CourseActivity" window
- data such as : course title -> assignments titles -> assignments grades -> course average grade
*/
public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Course> courses;
    LayoutInflater inflter;
    String mode;

    public CustomAdapter(Context applicationContext, List<Course> courses, String mode) {
        this.context = applicationContext;
        this.courses = courses;
        inflter = (LayoutInflater.from(applicationContext)); // not sure if needed ...

        this.mode = mode; // "letter" or "number"
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.multiline_text_view, null);
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.linearLayout);

        // Set Course Title
        TextView courseName = new TextView(context);
        courseName.setText(courses.get(i).getTitle());
        layout.addView(courseName);

        AssignmentController assignmentController = new AssignmentController();

        // Set Assignment title and Grades
        for(Assignment assignment : courses.get(i).getAssignmets()){

            TextView assignmentIDandGrade = new TextView(context);
            
            // choosing between if displaying the number or letter version of the grade
            if(this.mode == "number"){
                assignmentIDandGrade.setText(assignment.getIDStr() + " " + assignment.getGradeStr());
            }
            else{
                assignmentIDandGrade.setText(assignment.getIDStr() + " Grade : " + assignmentController.convert_grade_to_character(assignment.getGrade()));
            }

            layout.addView(assignmentIDandGrade);
        }

        // Set Course Average Grade
        CourseController controller = new CourseController();
        int averageGrade = controller.calculate_avg_grade(courses.get(i).getAssignmets());

        TextView courseGrade = new TextView(context);

        // choosing between if displaying the number or letter version of the grade
        if(this.mode == "number") {
            courseGrade.setText("Average Grade : " + String.valueOf(averageGrade));
        }
        else{
            courseGrade.setText("Average Grade : " + assignmentController.convert_grade_to_character(averageGrade));
        }
        layout.addView(courseGrade);

        return view;
    }
}