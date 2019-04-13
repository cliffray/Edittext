package com.homework.cliffray.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1 ,ed2 ,ed3;
    private TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.cat);
    }

    int size = 15;
    public void response(View v){

        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);

        txv = findViewById(R.id.textView);

        float height = Float.parseFloat(ed2.getText().toString());
        float weight = Float.parseFloat(ed3.getText().toString());
        float BMI1 = calBMI(height ,weight);
        String BMI2 = String.valueOf(BMI1);

        txv.setTextSize(size);
        txv.setText(ed1.getText().toString() +"您好\n" + "BMI是:" + BMI2);
        Toast.makeText(this, standardBMI(BMI1) ,Toast.LENGTH_LONG).show();
    }

    private float calBMI(float ht ,float wt){
        float BMI = (float)(wt / Math.pow((ht / 100) ,2));
        return BMI;
    }

    private String standardBMI(double st){
        String alert = " ";

        if(st > 25){
            alert = String.valueOf(("you are too heavry."));
            getWindow().setBackgroundDrawableResource(R.drawable.fat_cat);
        }
        else if(st < 18.5){
            alert = String.valueOf("your are too slim.");
            getWindow().setBackgroundDrawableResource(R.drawable.slim_cat);
        }
        else{
            alert = String.valueOf("your body is good.");
            getWindow().setBackgroundDrawableResource(R.drawable.cat);
        }
        return alert;
    }
}
