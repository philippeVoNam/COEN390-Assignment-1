package com.example.assignment_1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
Class ProfileActivity :
- UI class for displaying profile name, age and studentID
- users can either display or edit their information
*/
public class ProfileActivity extends AppCompatActivity {

    // Init UI widgets
    protected EditText nameEditText;
    protected TextView ageEditText;
    protected TextView studentidEditText;
    protected Button saveButton;

    // Mode of the Profile Activity
    protected String mode; // available modes are : display & edit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // init mode
        this.mode = "display"; // should have 2 modes - edit and display

        // setup UI elements
        setupUI();

        // setup ui slots
        setupSlots();
    }

    protected boolean check_empty(String data) {
        // check if the textEdit field is empty or not 

        if (data.matches("")) {
            Toast.makeText(this, "Some of the field are empty", Toast.LENGTH_SHORT).show();
            return true;
        }
        else {
            return false;
        }
    }

    protected boolean check_size(String data) {
        // check the size of the input before doing any conversion.
        // Cannot convert a string to int, if it is too big
        // for now the max is 6 digits

        if (data.length() > 6) {
            Toast.makeText(this, "Value is too large", Toast.LENGTH_SHORT).show();
            return true;
        }
        else {
            return false;
        }
    }

    protected void setupUI() {
        // setup the UI
        // getting UI elements
        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        studentidEditText = findViewById(R.id.studentidEditText);
        saveButton = findViewById(R.id.saveButton);

        // Setup the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setDisplayMode();

        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }

    protected void setupSlots() {
        // UI slots
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Saving...");

                // get data from EditTexts
                String name = nameEditText.getText().toString();
                String ageStr = ageEditText.getText().toString();
                String studentidStr = studentidEditText.getText().toString();

                // checking if fields are empty
                if (check_empty(name) || check_empty(ageStr) || check_empty(studentidStr)) {
                    System.out.println("Some Fields are empty");
                    return; // stop execution of method
                }

                // checking the size of inputs
                if (check_size(ageStr) || check_size(studentidStr)) {
                    System.out.println("Values are too large");
                    return; // stop execution of method
                }

                // Converting age and studentid to int
                int age = Integer.parseInt(ageStr);
                int studentid = Integer.parseInt(studentidStr);
//
                // check each inputs
                ProfileController profileController = new ProfileController();
                boolean nameCheck = profileController.check_name(name);
                boolean ageCheck = profileController.check_age(age);
                boolean studentidCheck = profileController.check_studentid(studentid);

                System.out.print(name);
                System.out.println(nameCheck);
                System.out.print(age);
                System.out.println(ageCheck);
                System.out.print(studentid);
                System.out.println(studentidCheck);

                // if pass all input tests
                if (nameCheck && ageCheck && studentidCheck) {

                // Save Data
                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.profileKey), Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getString(R.string.profileName), name);
                editor.putInt(getString(R.string.profileAge), age);
                editor.putInt(getString(R.string.profileStudentID), studentid);
                editor.apply();

                Toast toast = Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_LONG);
                toast.show();

                // Set back to display mode
                setDisplayMode();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // implement the toolbar

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.display_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // slots for the menu action items

        switch (item.getItemId()) {
            case R.id.display:
                setDisplayMode();
                System.out.println("display mode");
                return true;

            case R.id.edit:
                setEditMode();
                System.out.println("edit mode");
                return true;

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return true;
    }

    public void setDisplayMode(){
        // set the textfiled to not editable and hides the save buttonn
        nameEditText.setEnabled(false);
        ageEditText.setEnabled(false);
        studentidEditText.setEnabled(false);
        saveButton.setVisibility(View.INVISIBLE);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.profileKey), Context.MODE_PRIVATE);
        String name = sharedPreferences.getString(getString(R.string.profileName),null);
        int age = sharedPreferences.getInt(getString(R.string.profileAge),0);
        int studentID = sharedPreferences.getInt(getString(R.string.profileStudentID),0);

        if(name == null || age == 0 || studentID == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "You should create a profile", Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            nameEditText.setText(name);
            ageEditText.setText(Integer.toString(age));
            studentidEditText.setText(Integer.toString(studentID));
        }
    }

    public void setEditMode(){
        // set the textfiled to  editable and shows the save buttonn

        nameEditText.setEnabled(true);
        ageEditText.setEnabled(true);
        studentidEditText.setEnabled(true);
        saveButton.setVisibility(View.VISIBLE);
    }
}
