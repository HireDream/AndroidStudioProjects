package com.example.picotmaxence.tp3;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button connexion;
    private Button inscription;

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Application TP3");
        setSupportActionBar(toolbar);

        this.connexion = (Button) findViewById(R.id.button);
        this.inscription = (Button) findViewById(R.id.button2);

        this.email = (EditText) findViewById(R.id.editText);
        this.password = (EditText) findViewById(R.id.editText2);

        this.connexion.setOnClickListener(this);
        this.inscription.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        String strToast = "";
        String emailTmp = this.email.getText().toString();
        String passwordTmp = this.password.getText().toString();
        switch (view.getId()) {
            case R.id.button:

                if ( checkedForm(emailTmp,passwordTmp)) {
                    strToast = "Vous êtes maintenant connecté !";
                    Intent secondeActivite = new Intent(MainActivity.this, Main2Activity.class);
                    secondeActivite.putExtra("email", emailTmp);
                    secondeActivite.putExtra("password", passwordTmp);
                    startActivity(secondeActivite);
                }
                break;
            case R.id.button2:
                if ( checkedForm(emailTmp,passwordTmp)) {
                    strToast = "Vous êtes maintenant inscrit !";
                    Intent secondeActivite = new Intent(MainActivity.this, Main2Activity.class);
                    secondeActivite.putExtra("email", emailTmp);
                    secondeActivite.putExtra("password", passwordTmp);
                    startActivity(secondeActivite);
                }

                break;
        }

        Toast.makeText(this, strToast, Toast.LENGTH_SHORT).show();
    }

    private boolean checkedForm(String emailTmp, String passwordTmp) {
        if (emailTmp.isEmpty() || emailTmp.isEmpty() || passwordTmp.length() < 8 || !checkEmail(emailTmp)) {
            if (!passwordTmp.isEmpty() && passwordTmp.length() < 8)
                Toast.makeText(this, "Votre mot de passe doit faire au moins 8 caractères !", Toast.LENGTH_SHORT).show();
            else if (emailTmp.isEmpty() && passwordTmp.isEmpty())
                Toast.makeText(this, "Vous devez saisir un email et un mot de passe", Toast.LENGTH_SHORT).show();
            else if (emailTmp.isEmpty())
                Toast.makeText(this, "Vous devez saisir un email", Toast.LENGTH_SHORT).show();
            else if (passwordTmp.isEmpty())
                Toast.makeText(this, "Vous devez saisir un mot de passe", Toast.LENGTH_SHORT).show();
            else if (!checkEmail(emailTmp))
                Toast.makeText(this, "L'email saisi n'est pas valide", Toast.LENGTH_SHORT).show();

            return false;
        }

        return true;
    }

    private boolean checkEmail(String email) {
        return Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", email);
    }
}
