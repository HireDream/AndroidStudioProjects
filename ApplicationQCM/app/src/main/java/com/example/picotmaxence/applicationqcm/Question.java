package com.example.picotmaxence.applicationqcm;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Question extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private TextView question;
    private Button button;
    private int numero;
    private boolean[] boolQuestions;
    private RelativeLayout include;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        this.numero = intent.getIntExtra("numero",0);

        this.boolQuestions = intent.getBooleanArrayExtra("boolQuestion");

        this.question = (TextView) findViewById(R.id.questionText);
        this.button = (Button) findViewById(R.id.button2);

        this.button.setOnClickListener(this);

        this.question.setText(Main2Activity.getQuestion(this.numero));
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/police5.ttf");
        this.question.setTypeface(typeFace);

        this.inculdeLayout();

        FireworkLayout firework = new FireworkLayout( this );
        RelativeLayout surface = (RelativeLayout) findViewById(R.id.activity_question_one);
        surface.addView( firework );

    }

    @Override
    public void onClick(View view) {
        this.boolQuestions[this.numero] = true;
        Intent mainActivity = new Intent(Question.this, Main2Activity.class);
        mainActivity.putExtra("boolQuestion",this.boolQuestions);
        startActivity(mainActivity);
    }

    private void inculdeLayout() {
        ViewStub stub = (ViewStub) findViewById(R.id.layout_stub);

        switch (this.numero) {
            case 0:
                stub.setLayoutResource(R.layout.question1);
                this.include = (RelativeLayout) findViewById(R.id.layout_question1);
                break;
            case 1:
                stub.setLayoutResource(R.layout.question2);
                this.include = (RelativeLayout) findViewById(R.id.layout_question2);
                break;
            case 2:
                stub.setLayoutResource(R.layout.question3);
                this.include = (RelativeLayout) findViewById(R.id.layout_question3);
                break;
            case 3:
                stub.setLayoutResource(R.layout.question4);
                this.include = (RelativeLayout) findViewById(R.id.layout_question4);
                break;
            default:
                stub.setLayoutResource(R.layout.question5);
                this.include = (RelativeLayout) findViewById(R.id.layout_question5);
                this.initQuestion1();
                break;
        }

        View inflated = stub.inflate();

    }

    private void initQuestion1() {
        this.spinner = (Spinner) this.include.findViewById(R.id.spinner);
        ArrayList<String> reponses = new ArrayList<String>();
        reponses.add("1995");
        reponses.add("2000");
        reponses.add("2001");
        reponses.add("2006");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,reponses);
        this.spinner.setAdapter(adapter);
    }
}
