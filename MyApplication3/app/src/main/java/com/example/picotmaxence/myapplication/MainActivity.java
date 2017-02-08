package com.example.picotmaxence.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout layout = null;
    TextView text = null;
    EditText edit = null;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        layout = (RelativeLayout) RelativeLayout.inflate(this, R.layout.content_main, null);
        text = (TextView) layout.findViewById(R.id.textView2);

        edit = (EditText) layout.findViewById(R.id.editText);

        Button b = (Button) layout.findViewById(R.id.button);
        b.setOnClickListener(this);

        setContentView(layout);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                String txt = "Bonjour "+edit.getText()+" !";
                text.setText(txt);
                Toast.makeText(getApplicationContext(), txt,
                        Toast.LENGTH_LONG).show();
                this.setContentView(layout);
                break;
        }
    }
}
