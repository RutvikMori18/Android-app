package com.welovecrazyquote.inchesconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText inchsEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesString = inchsEditText.getText().toString();
                if(inchesString.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please input the value",Toast.LENGTH_SHORT).show();
                }
                else{
                    double result = claculateHeight(inchesString);

                    displayResult(result);
                }
            }
        });
    }

    private void displayResult(double result) {
        DecimalFormat myFormatter = new DecimalFormat("0.00");
        String resultString = myFormatter.format(result);
        resultTextView.setText(resultString + " meters");
    }

    private double claculateHeight(String inchesString) {
        int inches = Integer.parseInt(inchesString);
        return inches * 0.0254;
    }

    private void findViews(){
        inchsEditText= findViewById(R.id.edit_text_inches);
       calculateButton = findViewById(R.id.calculate_button);
        resultTextView= findViewById(R.id.text_view_result);

    }
}