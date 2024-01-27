package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn;
        TextView result;
        EditText edtWt,edtHt;

        edtWt = findViewById(R.id.inWt);
        edtHt = findViewById(R.id.inHt);
        result = findViewById(R.id.txt);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try {
                    int weight = Integer.parseInt(edtWt.getText().toString());
                    double Height = Double.parseDouble(edtHt.getText().toString());
                    if (BmiCalculate(weight, Height) > 25) {
                        result.setText(R.string.msgOver);
                    } else if (BmiCalculate(weight, Height) < 18) {
                        result.setText(R.string.msgUnder);
                    } else {
                        result.setText(R.string.msgHealthy);
                    }
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, R.string.errormsg, Toast.LENGTH_SHORT).show();
                    result.setText("");
                }
            }
        });

    }
    public double BmiCalculate(int wt,double ht)
    {
        double met = ht * 0.3048;
        return wt / (met * met);
    }
}