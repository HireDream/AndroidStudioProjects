package com.example.picotmaxence.convertion;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edit = null;
    private Button button = null;
    private RadioButton radioC = null;
    private RadioButton radioF = null;
    private TextView text = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        mActionBarToolbar.setTitle("Application de convertion");
        setSupportActionBar(mActionBarToolbar);

        edit = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        radioC = (RadioButton) findViewById(R.id.radioButton);
        radioF = (RadioButton) findViewById(R.id.radioButton2);
        text = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( edit.getText().toString().matches("") ) {
                    Toast.makeText(getApplicationContext(), "Il faut saisir une valeur !", Toast.LENGTH_LONG).show();
                } else {
                    double temp = Integer.parseInt(edit.getText().toString());
                    if (radioC.isChecked()) {
                        double newTemp = (temp - 32) * 5/9;
                        newTemp = (double) Math.round(newTemp * 100) / 100;
                        text.setText(temp+" °F = "+newTemp+" °C");
                        Toast.makeText(getApplicationContext(), "Vous venez de convertir en Celcius",
                                Toast.LENGTH_LONG).show();
                    } else if (radioF.isChecked()) {
                        double newTemp = temp * 9/5 + 32;
                        newTemp = (double) Math.round(newTemp * 100) / 100;
                        text.setText(temp+" °C = "+newTemp+" °F");
                        Toast.makeText(getApplicationContext(), "Vous venez de convertir en Fahrenhiet",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Il faut selectionner une unité",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}
