package com.example.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

//    protected TextView nameLabel;
//    protected TextView ageLabel;
//    protected TextView studentidLabel;

    // Init UI widgets
    protected EditText nameEditText;
    protected TextView ageEditText;
    protected TextView studentidEditText;

    protected Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // getting UI elements
        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        studentidEditText = findViewById(R.id.studentidEditText);
        saveButton = findViewById(R.id.saveButton);

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

                }

//                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.profilefilekey), Context.MODE_PRIVATE);
//
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString(getString(R.string.profilenamekey), name);
//                editor.apply();
//
//                Toast toast = Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_LONG);
//                toast.show();
            }
        });
    }

    protected boolean check_empty(String data) {
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
}
