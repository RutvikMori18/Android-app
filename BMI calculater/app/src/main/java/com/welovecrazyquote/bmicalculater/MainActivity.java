package com.welovecrazyquote.bmicalculater;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static com.welovecrazyquote.bmicalculater.R.id.button_calculate;
import static com.welovecrazyquote.bmicalculater.R.id.text;

public class MainActivity extends AppCompatActivity {

    //class variable
    private TextView resultText;
    private RadioButton male;
    private RadioButton feMale;
    private EditText ageEditText;
    private EditText feetageEditText;
    private EditText inchesageEditText;
    private EditText weightageEditText;
    private Button calculateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateButton = findViewById(button_calculate);

        setUpButtonCkickListener();


    }

    private void setUpButtonCkickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               double bmiresult= calculatebmi();

                String ageText = ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);
                if(age>18){
                    displayresult(bmiresult);
                }else{
                    displayGiidance(bmiresult);
                }

            }


        });
    }

    private void displayGiidance(double bmi) {
        DecimalFormat myDecimalFormater= new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormater.format(bmi);

        String fullResultString;

        if(male.isChecked()){
            //display boy guidance
            fullResultString = bmiTextResult + "- as you are under 18, please consult with your doctor for healthy range for boys..! ";
        }else if(feMale.isChecked()) {
            //display girl guidance
            fullResultString = bmiTextResult + "- as you are under 18, please consult with your doctor for healthy range for girls ..!";
        }else {
            //display general guidance
            fullResultString = bmiTextResult + "- as you are under 18, please consult with your doctor for healthy range..! ";
        }
    }

    private double calculatebmi() {

        String feetText = feetageEditText.getText().toString();
        String inchesText = inchesageEditText.getText().toString();
        String weightText = weightageEditText.getText().toString();


        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches=(feet * 12) +inches;
        //height in meter is the inches multiply by 0.0254
        double heightInMeter = totalInches*0.0254;
       //bmi formula =weight in kg divided by height in meters squred

        return weight / (heightInMeter * heightInMeter);
    }


    private void findViews()
        {
             resultText = findViewById(R.id.text_view_result);

            male = findViewById(R.id.radio_buton_male);
            feMale = findViewById(R.id.radio_buton_male);
            ageEditText = findViewById(R.id.edit_text_age);
            feetageEditText = findViewById(R.id.edit_text_feet);
            inchesageEditText = findViewById(R.id.edit_text_inches);
            weightageEditText = findViewById(R.id.edit_text_weight);


        }

    private void displayresult(double bmi){
        DecimalFormat myDecimalFormater= new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormater.format(bmi);

        String fullResultString;
        if(bmi < 18.5) {
            //display under weight
            fullResultString = bmiTextResult +"you are under Weight.!";
        }else if(bmi>25) {

            //display overweight
            fullResultString = bmiTextResult +"you are over Weight.!";
        }else {
            //display healthy
            fullResultString = bmiTextResult +"you are Healthy.!";
        }

        resultText.setText(fullResultString);


    }
}