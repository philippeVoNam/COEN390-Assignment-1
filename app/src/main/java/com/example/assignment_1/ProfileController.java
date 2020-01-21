package com.example.assignment_1;
import java.lang.Math;

public class ProfileController {

    // Constructor
    public ProfileController() {

    }

    // Methods
    public boolean check_name(String name) {

        System.out.println("check name");

        // checks if the String is null
        if (name == null) {
            return false;
        }

        // check if name is empty
        if (name.length() == 0) {
            return false;
        }

        // check if string is only characters
        int len = name.length();
        for (int i = 0; i < len; i++) {
        if ((Character.isLetter(name.charAt(i)) == false)) {
            return false;
            }
        }

      return true;
    }

    public boolean check_age(int age) {

        // - cannot have : decimals, negative , 0 ...

        System.out.println("check age");

        // check if age is between 1 - 99
        if ((age >= 1) && (age <= 99)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean check_studentid(int studentid) {

        // - cannot have : decimals, negative , 0 ...

        System.out.println("check student id");

        // check if the studentid is max 6 numbers, also check if it is negative
        double id = studentid;
        if (studentid >= 0) {
            double digits = Math.log10(id) + 1;

            if ((digits >= 1) && (digits <= 6)) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

}