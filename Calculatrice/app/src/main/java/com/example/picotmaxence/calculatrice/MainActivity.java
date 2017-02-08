package com.example.picotmaxence.calculatrice;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bouton0;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private Button boutonPlus;
    private Button boutonMoins;
    private Button boutonDivise;
    private Button boutonMultiple;
    private Button boutonEgale;
    private Button boutonPoint;
    private Button boutonEffacer;

    private EditText edit;

    private TextView text;

    private String expression;

    private boolean lastIsOperator;
    private boolean lastIsNumber;
    private boolean numberHasPoint;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Calculatrice");
        setSupportActionBar(toolbar);

        expression = "";

        edit = (EditText) findViewById(R.id.editText);

        text = (TextView) findViewById(R.id.textView);

        bouton0 = (Button) findViewById(R.id.button13);
        bouton1 = (Button) findViewById(R.id.button);
        bouton2 = (Button) findViewById(R.id.button2);
        bouton3 = (Button) findViewById(R.id.button3);
        bouton4 = (Button) findViewById(R.id.button5);
        bouton5 = (Button) findViewById(R.id.button6);
        bouton6 = (Button) findViewById(R.id.button9);
        bouton7 = (Button) findViewById(R.id.button7);
        bouton8 = (Button) findViewById(R.id.button8);
        bouton9 = (Button) findViewById(R.id.button11);

        boutonPlus = (Button) findViewById(R.id.button4);
        boutonMoins = (Button) findViewById(R.id.button10);
        boutonDivise = (Button) findViewById(R.id.button16);
        boutonMultiple = (Button) findViewById(R.id.button12);
        boutonEgale = (Button) findViewById(R.id.button17);
        boutonPoint = (Button) findViewById(R.id.button14);
        boutonEffacer = (Button) findViewById(R.id.button15);

        bouton0.setOnClickListener(this);
        bouton1.setOnClickListener(this);
        bouton2.setOnClickListener(this);
        bouton3.setOnClickListener(this);
        bouton4.setOnClickListener(this);
        bouton5.setOnClickListener(this);
        bouton6.setOnClickListener(this);
        bouton7.setOnClickListener(this);
        bouton8.setOnClickListener(this);
        bouton9.setOnClickListener(this);
        boutonPlus.setOnClickListener(this);
        boutonMoins.setOnClickListener(this);
        boutonDivise.setOnClickListener(this);
        boutonMultiple.setOnClickListener(this);
        boutonEgale.setOnClickListener(this);
        boutonPoint.setOnClickListener(this);
        boutonEffacer.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button:
                this.lastIsOperator = false;
                this.lastIsNumber = true;
                this.expression += bouton1.getText().toString();
                this.edit.setText(this.expression);
                break;
            case R.id.button2:
                this.lastIsNumber = true;
                this.lastIsOperator = false;
                this.expression += bouton2.getText().toString();
                this.edit.setText(this.expression);
                break;
            case R.id.button3:
                this.lastIsNumber = true;
                this.lastIsOperator = false;
                this.expression += bouton3.getText().toString();
                this.edit.setText(this.expression);
                break;
            case R.id.button4:
                if ( this.lastIsNumber ) {
                    this.expression += boutonPlus.getText().toString();
                    this.edit.setText(this.expression);
                    this.lastIsOperator = true;
                    this.lastIsNumber = false;
                    this.numberHasPoint = false;
                }
                break;
            case R.id.button5:
                this.lastIsNumber = true;
                this.lastIsOperator = false;
                this.expression += bouton4.getText().toString();
                this.edit.setText(this.expression);
                break;
            case R.id.button6:
                this.lastIsNumber = true;
                this.lastIsOperator = false;
                this.expression += bouton5.getText().toString();
                this.edit.setText(this.expression);
                break;
            case R.id.button7:
                this.lastIsNumber = true;
                this.lastIsOperator = false;
                this.expression += bouton7.getText().toString();
                this.edit.setText(this.expression);
                break;
            case R.id.button8:
                this.lastIsNumber = true;
                this.lastIsOperator = false;
                this.expression += bouton8.getText().toString();
                this.edit.setText(this.expression);
                break;
            case R.id.button9:
                this.lastIsNumber = true;
                this.lastIsOperator = false;
                this.expression += bouton6.getText().toString();
                this.edit.setText(this.expression);
                break;
            case R.id.button10:
                if ( this.lastIsNumber ) {
                    this.expression += boutonMoins.getText().toString();
                    this.edit.setText(this.expression);
                    this.lastIsOperator = true;
                    this.lastIsNumber = false;
                    this.numberHasPoint = false;
                }
                break;
            case R.id.button11:
                this.lastIsNumber = true;
                this.lastIsOperator = false;
                this.expression += bouton9.getText().toString();
                this.edit.setText(this.expression);
                break;
            case R.id.button12:
                if ( this.lastIsNumber ) {
                    this.expression += boutonMultiple.getText().toString();
                    this.edit.setText(this.expression);
                    this.lastIsOperator = true;
                    this.lastIsNumber = false;
                    this.numberHasPoint = false;
                }
                break;
            case R.id.button13:
                this.lastIsNumber = true;
                this.expression += bouton0.getText().toString();
                this.edit.setText(this.expression);
                this.lastIsOperator = false;
                break;
            case R.id.button14:
                if ( this.lastIsNumber && !this.numberHasPoint ) {
                    this.expression += boutonPoint.getText().toString();
                    this.edit.setText(this.expression);
                    this.numberHasPoint = true;
                    this.lastIsNumber = false;
                    this.lastIsOperator = false;
                }
                break;
            case R.id.button15:
                this.expression = "";
                this.edit.setText(this.expression);
                this.lastIsNumber = false;
                this.lastIsOperator = false;
                this.numberHasPoint = false;
                break;
            case R.id.button16:
                if ( this.lastIsNumber ) {
                    this.expression += boutonDivise.getText().toString();
                    this.edit.setText(this.expression);
                    this.lastIsOperator = true;
                    this.lastIsNumber = false;
                    this.numberHasPoint = false;
                }
                break;
            case R.id.button17:
                if ( this.lastIsNumber ) {
                    double res = this.calcul(this.expression);
                    this.text.setText(this.expression + " = " + res);
                    this.expression = "";
                    this.edit.setText(this.expression);
                }
                break;
        }
    }

    private double calcul(String expression) {

        String[] result=expression.split("(?<=[-+*/])|(?=[-+*/])");

        double res = Double.parseDouble(result[0]);

        for( int i = 1; i < result.length; i++) {

            double d2 = Double.parseDouble(result[i+1]);
            switch (result[i]) {
                case "-":
                    res = res-d2;
                    break;
                case "*":
                    res = res*d2;
                    break;
                case "+":
                    res = res+d2;
                    break;
                case "/":
                    res = res/d2;
                    break;
            }
            i++;
        }

        return res;
    }
}
