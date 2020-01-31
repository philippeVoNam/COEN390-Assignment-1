/*
author : Philippe Vo
date   : Jan-20-2020
 */

package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Questions :
// Where are the "SharedPreferences" data stored ?
// How to make sure there are no conflicts with "widgets id names" ?
// Do we have to use specifically the widgets they told us to use ?
// Ans : Yes
// Is Profile and Courses "related" ?
// Ans : No
// Not quite sure what to put in "OnCreate" vs "OnStart" ?

// Notes :
// - make sure to try invalid inputs
// - name can ONLY have : characters
//     X - cannot be empty
// - age can ONLY be : integer
//      - cannot have : decimals, negative , 0 ...
//     X - cannot be a string
//     X - cannot be empty
// - studentid can ONLY be : integer
//      - cannot have : decimals, negative , 0 ...
//     X - cannot be a string
//     X - cannot be empty


/*
Class MainActivity:
- ui class that represents the main home window of the application
- only has two buttons that redirects user to : course window or profile window
*/
public class MainActivity extends AppCompatActivity {

//  Init UI widgets
    protected Button profileButton;
    protected Button showGradeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init UI
        setupUI();
    }

//  Init UI
    protected void setupUI() {

        // UI Slots
        profileButton = findViewById(R.id.profileButton);
        profileButton.setOnClickListener(new View.OnClickListener() { // is this a class ?
            @Override
            public void onClick(View v) {
                goToProfileActivity();
            }
        });

        showGradeButton = findViewById(R.id.showGradeButton);
        showGradeButton.setOnClickListener(new View.OnClickListener() { // is this a class ?
            @Override
            public void onClick(View v) {
                goToShowGradeActivity();
            }
        });
    }

//  Init UI widgets slots
    protected void goToProfileActivity() {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class); // what is Intent ? -> signals and slots from QT
        startActivity(intent);
    }

    protected void goToShowGradeActivity() {
        Intent intent = new Intent(MainActivity.this, CoursesActivity.class); // what is Intent ? -> signals and slots from QT
        startActivity(intent);
    }
}
