package com.example.picotmaxence.tp3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");

        TextView textView1 = (TextView) findViewById(R.id.textView3);
        TextView textView2 = (TextView) findViewById(R.id.textView4);

        textView1.setText(email);
        textView2.setText(password);

    }
}
