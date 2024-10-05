/*
 *@author:<Wallace Moura Machado de Oliveira;1110482413004>
 */

package com.example.project2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnCalcular = (Button)findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double a = Double.parseDouble(((EditText)findViewById(R.id.txtA)).getText().toString());
                double b = Double.parseDouble(((EditText)findViewById(R.id.txtB)).getText().toString());
                double c = Double.parseDouble(((EditText)findViewById(R.id.txtC)).getText().toString());

                double delta = b*b - 4*a*c;

                TextView lblDelta = (TextView)findViewById(R.id.lblDelta);
                TextView lblFirst = (TextView)findViewById(R.id.lblFirst);
                TextView lblSecond = (TextView)findViewById(R.id.lblSecond);

                lblDelta.setText("O valor de delta é " + delta);

                if(delta > 0) {
                    lblFirst.setText("O valor da primeira raíz é: " + ((-b + Math.sqrt(delta))/(2*a)));
                    lblSecond.setText("O valor da segunda raíz é: " + ((-b - Math.sqrt(delta))/(2*a)));
                } else if(delta == 0) {
                    lblFirst.setText("O valor da única raíz é: " + ((-b + Math.sqrt(delta))/(2*a)));
                    lblSecond.setText("");
                } else {
                    lblFirst.setText("Não existem raízes reais para esse delta");
                    lblSecond.setText("");
                }


            }
        });
    }
}