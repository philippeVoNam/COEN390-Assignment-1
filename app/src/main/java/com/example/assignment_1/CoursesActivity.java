package com.example.assignment_1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/*
Class CoursesActivity :
- UI class for displaying courses and assignments, along with their grades
*/
public class CoursesActivity extends AppCompatActivity {

    // init variables
    ListView simpleList;
    List<Course> courses = new ArrayList<Course>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        // init data.
        init_data();

        // implement customAdapter
        set_adapter("number");

        /*
        idea is :
        Have a ListView
        Have a custom adapter
        Add some LinearLayout to this adapter
        Dynamically add textviews to this LinearLayout
         */

        // Setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarCourses);
        setSupportActionBar(toolbar);

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }


    public void init_data(){
        // init data.

        // generates the courses and assignments objects 
        int max = 5;
        int min = 1;
        double numCourses = (Math.random() * ((max - min) + 1)) + min;

        for(int i = 0; i<numCourses; i++){

            List<Assignment> assignments = new ArrayList<Assignment>();
            double numAssignments = (Math.random() * ((max - min) + 1)) + min;
            for(int j = 0; j<numAssignments; j++){

                double grade = (Math.random() * ((100 - 0) + 1)) + 0;

                Assignment assignment = new Assignment(j,(int)Math.round(grade));
                assignments.add(assignment);
            }

            CourseController controller = new CourseController();
            int averageGrade = controller.calculate_avg_grade(assignments);

            Course course = new Course(String.valueOf(i),averageGrade, assignments);
            courses.add(course);
        }
    }

    public void set_adapter(String mode){
        // implement customAdapter to insert into the listview
        simpleList = (ListView) findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter(CoursesActivity.this, courses, mode);
        simpleList.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // implement the toolbar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grade_mode_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // slots for the menu action items
        
        switch (item.getItemId()) {
            case R.id.letter_grade:
                // implement customAdapter
                set_adapter("letter");
                System.out.println("letter mode");
                return true;

            case R.id.number_grade:
                // implement customAdapter
                set_adapter("number");
                System.out.println("number mode");
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return true;
    }
}
