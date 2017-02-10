package com.example.picotmaxence.applicationqcm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.plattysoft.leonids.ParticleSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static String[] strQuestions;
    private boolean[] boolQuestions;
    private TextView progression;
    private RatingBar ratingBar;
    private ListView listView;
    private ArrayList listQuestions;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        this.ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        this.progression = (TextView) findViewById(R.id.progression);
        this.listView = (ListView) findViewById(R.id.questions);

        this.ratingBar.setStepSize(1);

        this.boolQuestions = new boolean[5];
        Main2Activity.strQuestions = new String[]{
                "Qu'elle est la capitale de l'Australie ?",
                "Cochez les langages de programmation orientés objet",
                "Dennis Ritchie est-il l'un des créateur de Google ?",
                "Nationalité de Bill Gates ?",
                "Date de fin de la Première Guerre mondiale ?"
        };

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        if ( intent.getBooleanArrayExtra("boolQuestion") != null )
            this.boolQuestions = intent.getBooleanArrayExtra("boolQuestion");

        this.setProgression();
        this.setQuestions();

        this.listView.setOnItemClickListener(this);

    }

    private void setProgression() {
        int i = 0;

        for (boolean b : this.boolQuestions ) {
            if ( b )
                i++;
        }

        if ( i == 5 ) {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            new ParticleSystem(this, 80, R.drawable.confetti2, 10000)
                    .setSpeedModuleAndAngleRange(0f, 0.3f, 180, 180)
                    .setRotationSpeed(144)
                    .setAcceleration(0.00005f, 100)
                    .emit(size.x,0, 8);
            new ParticleSystem(this, 80, R.drawable.confetti6, 10000)
                    .setSpeedModuleAndAngleRange(0f, 0.3f, 180, 180)
                    .setRotationSpeed(144)
                    .setAcceleration(0.00005f, 100)
                    .emit(size.x,0, 8);

            new ParticleSystem(this, 80, R.drawable.confetti3, 10000)
                    .setSpeedModuleAndAngleRange(0f, 0.3f, 180, 180)
                    .setRotationSpeed(144)
                    .setAcceleration(0.00005f, 100)
                    .emit(size.x,0, 8);

            new ParticleSystem(this, 80, R.drawable.confetti, 10000)
                    .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                    .setRotationSpeed(144)
                    .setAcceleration(0.00005f, 100)
                    .emit(0,0, 8);
            new ParticleSystem(this, 80, R.drawable.confetti4, 10000)
                    .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                    .setRotationSpeed(144)
                    .setAcceleration(0.00005f, 100)
                    .emit(0,0, 8);
            new ParticleSystem(this, 80, R.drawable.confetti5, 10000)
                    .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                    .setRotationSpeed(144)
                    .setAcceleration(0.00005f, 100)
                    .emit(0,0, 8);
        }

        this.progression.setText("Progression : "+i+"/5");
        this.ratingBar.setProgress(i);
    }

    private void setQuestions() {
        this.listQuestions = new ArrayList<HashMap<String, String>>();

        String[] from = new String[] { "numero", "texte" };
        int[] to = new int[] { R.id.num_question, R.id.text_question };
        this.adapter = new SimpleAdapter(this, this.listQuestions, R.layout.list_row , from, to);

        for ( int i = 0; i < 5; i++)
            this.listQuestions.add(this.createHashMap("Question n°"+(i+1),Main2Activity.strQuestions[i]));

        this.listView.setAdapter(this.adapter);
        this.adapter.notifyDataSetChanged();
    }

    private HashMap<String, String> createHashMap(String val1, String val2) {
        HashMap<String, String> res = new HashMap<String, String>();

        res.put("numero",val1);
        res.put("texte",val2);

        return res;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(Main2Activity.this, Question.class);
        intent.putExtra("numero",i);
        intent.putExtra("boolQuestion",this.boolQuestions);
        startActivity(intent);

    }

    public static String getQuestion(int i) {
        return Main2Activity.strQuestions[i];
    }
}
