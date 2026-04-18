package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.activity1.R;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name, mbno, address;
    RadioGroup genderGroup;
    RadioButton radioMale, radioFemale, radioOthers;
    Button dob, btnSubmit;
    CheckBox checkReading, checkDancing, checkSinging, checkTravelling;

    TextView info, genderinfo, borninfo;

    String selectedDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        mbno = findViewById(R.id.mbno);
        address = findViewById(R.id.address);

        genderGroup = findViewById(R.id.deviceGroup);

        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        radioOthers = findViewById(R.id.radioOthers);

        dob = findViewById(R.id.dob);
        btnSubmit = findViewById(R.id.btnSubmit);

        checkReading = findViewById(R.id.checkReading);
        checkDancing = findViewById(R.id.checkDancing);
        checkSinging = findViewById(R.id.checkSinging);
        checkTravelling = findViewById(R.id.checkTravelling);

        info = findViewById(R.id.info);
        genderinfo = findViewById(R.id.genderinfo);
        borninfo = findViewById(R.id.borninfo);

        dob.setOnClickListener(v -> {

            Calendar c = Calendar.getInstance();

            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (view, y, m, d) -> {

                        selectedDate = d + "/" + (m + 1) + "/" + y;
                        dob.setText(selectedDate);

                    },
                    year, month, day);

            datePickerDialog.show();
        });

        btnSubmit.setOnClickListener(v -> {

            String n = name.getText().toString();
            String m = mbno.getText().toString();
            String a = address.getText().toString();

            int selectedId = genderGroup.getCheckedRadioButtonId();
            RadioButton genderBtn = findViewById(selectedId);
            String gender = genderBtn.getText().toString();

            String hobbies = "";

            if (checkReading.isChecked())
                hobbies += "Reading Books, ";

            if (checkDancing.isChecked())
                hobbies += "Dancing, ";

            if (checkSinging.isChecked())
                hobbies += "Singing, ";

            if (checkTravelling.isChecked())
                hobbies += "Travelling, ";

            info.setText("Your Name is " + n +
                    " Your Mobile No. & Address is " + m + " & " + a);

            genderinfo.setText("Your Gender is " + gender);

            borninfo.setText("Your Born On " + selectedDate +
                    " You like to " + hobbies);

        });

    }
}