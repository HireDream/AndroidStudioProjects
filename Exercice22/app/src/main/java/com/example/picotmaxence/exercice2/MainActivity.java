package com.example.picotmaxence.exercice2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView list = null;
    private Button button = null;
    private EditText edit = null;
    private ArrayList<String> al;
    private ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        al = new ArrayList<String>();//initialize array list
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);

        list = (ListView) this.findViewById(R.id.list);
        list.setAdapter(aa);

        button = (Button) this.findViewById(R.id.button);

        edit = (EditText) this.findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = edit.getText().toString();
                al.add(0, item);
                aa.notifyDataSetChanged();
                edit.setText("");
            }
        });
    }
}
