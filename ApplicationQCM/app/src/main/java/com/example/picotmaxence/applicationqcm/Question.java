package com.example.picotmaxence.applicationqcm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.plattysoft.leonids.ParticleSystem;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Question extends AppCompatActivity implements View.OnClickListener {

    private ListView listView;
    private TextView question;
    private Button retour;
    private int numero;
    private boolean[] boolQuestions;
    private RelativeLayout include;
    private Spinner spinner;
    private MediaPlayer mPlayer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent intent = getIntent();
        this.numero = intent.getIntExtra("numero",0);

        this.boolQuestions = intent.getBooleanArrayExtra("boolQuestion");

        this.question = (TextView) findViewById(R.id.questionText);
        this.retour = (Button) findViewById(R.id.button2);

        this.retour.setOnClickListener(this);

        this.question.setText(Main2Activity.getQuestion(this.numero));
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/police5.ttf");
        this.question.setTypeface(typeFace);

        this.inculdeLayout();
    }

    @Override
    public void onClick(View view) {
        Intent mainActivity = new Intent(Question.this, Main2Activity.class);
        switch (view.getId()) {
            case R.id.button2:
                mainActivity.putExtra("boolQuestion",this.boolQuestions);
                startActivity(mainActivity);
                break;
            case R.id.valider1:
                RadioButton r1 = (RadioButton) findViewById(R.id.radioButton2);
                if ( !this.boolQuestions[this.numero] ) {
                    if ( r1.isChecked() ) {
                        this.boolQuestions[this.numero] = true;
                        Toast.makeText(this, "Bonne réponse !", Toast.LENGTH_SHORT).show();
                        this.playSoundGagnant();
                    } else {
                        Toast.makeText(this, "Mauvaise réponse !", Toast.LENGTH_SHORT).show();
                        this.playSoundPerdant();
                    }
                }
                mainActivity.putExtra("boolQuestion",this.boolQuestions);
                startActivity(mainActivity);
                break;
            case R.id.valider2:
                CheckBox c1 = (CheckBox) findViewById(R.id.checkBox);
                CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
                CheckBox c3 = (CheckBox) findViewById(R.id.checkBox4);
                if ( !this.boolQuestions[this.numero] ) {
                    if (c1.isChecked() && c2.isChecked() && c3.isChecked()) {
                        this.boolQuestions[this.numero] = true;
                        Toast.makeText(this, "Bonne réponse !", Toast.LENGTH_SHORT).show();
                        this.playSoundGagnant();
                    } else {
                        Toast.makeText(this, "Mauvaise réponse !", Toast.LENGTH_SHORT).show();
                        this.playSoundPerdant();
                    }
                }
                mainActivity.putExtra("boolQuestion",this.boolQuestions);
                startActivity(mainActivity);
                break;
            case R.id.button3:
                if ( !this.boolQuestions[this.numero] ) {
                    Toast.makeText(this, "Mauvaise réponse !", Toast.LENGTH_SHORT).show();
                    this.playSoundPerdant();
                }
                mainActivity.putExtra("boolQuestion",this.boolQuestions);
                startActivity(mainActivity);
                break;
            case R.id.button4:
                if ( !this.boolQuestions[this.numero] ) {
                    this.boolQuestions[this.numero] = true;
                    Toast.makeText(this, "Bonne réponse !", Toast.LENGTH_SHORT).show();
                    this.playSoundGagnant();
                }
                mainActivity.putExtra("boolQuestion",this.boolQuestions);
                startActivity(mainActivity);
            case R.id.valider4:
                if ( !this.boolQuestions[this.numero] ) {
                    Spinner spinner = (Spinner) this.include.findViewById(R.id.spinner2);
                    if ( spinner.getSelectedItem().toString().equals("Américain") ) {
                        this.boolQuestions[this.numero] = true;
                        Toast.makeText(this, "Bonne réponse !", Toast.LENGTH_SHORT).show();
                        this.playSoundGagnant();
                    } else {
                        Toast.makeText(this, "Mauvaise réponse !", Toast.LENGTH_SHORT).show();
                        this.playSoundPerdant();
                    }
                }
                mainActivity.putExtra("boolQuestion",this.boolQuestions);
                startActivity(mainActivity);
            case R.id.valider5:
                if ( !this.boolQuestions[this.numero] ) {
                    DatePicker datePicker = (DatePicker) this.include.findViewById(R.id.datePicker);
                    int day = datePicker.getDayOfMonth();
                    int month = datePicker.getMonth()+1;
                    int year = datePicker.getYear();
                    if ( day == 11 && month == 11 && year == 1918 ) {
                        this.boolQuestions[this.numero] = true;
                        Toast.makeText(this, "Bonne réponse !", Toast.LENGTH_SHORT).show();
                        this.playSoundGagnant();
                    } else {
                        Toast.makeText(this, "Mauvaise réponse !", Toast.LENGTH_SHORT).show();
                        this.playSoundPerdant();
                    }
                }
                mainActivity.putExtra("boolQuestion",this.boolQuestions);
                startActivity(mainActivity);
        }
    }

    private void inculdeLayout() {
        ViewStub stub = (ViewStub) findViewById(R.id.layout_stub);

        switch (this.numero) {
            case 0:
                stub.setLayoutResource(R.layout.question1);
                this.include = (RelativeLayout) stub.inflate();
                Button valider1 = (Button) this.include.findViewById(R.id.valider1);
                RadioButton r1 = (RadioButton) findViewById(R.id.radioButton2);
                if (  this.boolQuestions[this.numero] )
                    r1.setChecked(true);
                valider1.setOnClickListener(this);
                break;
            case 1:
                stub.setLayoutResource(R.layout.question2);
                this.include = (RelativeLayout) stub.inflate();
                Button valider2 = (Button) this.include.findViewById(R.id.valider2);
                CheckBox c1 = (CheckBox) findViewById(R.id.checkBox);
                CheckBox c2 = (CheckBox) findViewById(R.id.checkBox2);
                CheckBox c3 = (CheckBox) findViewById(R.id.checkBox4);
                if ( this.boolQuestions[this.numero] ) {
                    c1.setChecked(true);
                    c2.setChecked(true);
                    c3.setChecked(true);
                }
                valider2.setOnClickListener(this);
                break;
            case 2:
                stub.setLayoutResource(R.layout.question3);
                this.include = (RelativeLayout) stub.inflate();
                Button vrai = (Button) findViewById(R.id.button3);
                Button faux = (Button) findViewById(R.id.button4);
                if ( this.boolQuestions[this.numero] ) {
                    faux.setBackgroundColor(Color.GREEN);
                }
                vrai.setOnClickListener(this);
                faux.setOnClickListener(this);
                break;
            case 3:
                stub.setLayoutResource(R.layout.question4);
                this.include = (RelativeLayout) stub.inflate();
                this.initSpinner();
                Button valider4 = (Button) this.include.findViewById(R.id.valider4);
                valider4.setOnClickListener(this);
                break;
            default:
                stub.setLayoutResource(R.layout.question5);
                this.include = (RelativeLayout) stub.inflate();
                Button valider5 = (Button) this.include.findViewById(R.id.valider5);
                valider5.setOnClickListener(this);
                DatePicker datePicker = (DatePicker) this.include.findViewById(R.id.datePicker);
                if ( this.boolQuestions[this.numero] ) {
                    datePicker.updateDate(1918,10,11);
                }
                break;
        }
    }

    private void initSpinner() {
        String[] arraySpinner;
        arraySpinner = new String[] {
                "Français", "Américain", "Canadien", "Australien", "Anglais"
        };
        Spinner s = (Spinner) this.include.findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        s.setAdapter(adapter);
    }

    private void createParticule() {
        new ParticleSystem(this, 80, R.drawable.bg, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.layout_stub), 8);
    }

    private void playSoundPerdant() {
        if(mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(this, R.raw.perdu);
        mPlayer.start();
    }

    private void playSoundGagnant() {
        if(mPlayer != null) {
            mPlayer.stop();
            mPlayer.release();
        }
        mPlayer = MediaPlayer.create(this, R.raw.gagne);
        mPlayer.start();
    }
}
