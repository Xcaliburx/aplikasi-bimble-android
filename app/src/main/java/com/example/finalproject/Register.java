package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText ID;
    EditText email;
    EditText nama;
    EditText password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ID = findViewById(R.id.Fullname);
        nama = findViewById(R.id.Name);
        password = findViewById(R.id.Password);
        email = findViewById(R.id.Email);
        register = findViewById(R.id.signups);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkDataEntered() {
        if (isEmpty(ID)) {
            Toast t = Toast.makeText(this, "ID required", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(nama)){
            nama.setError("Nama is required!");
        }

        if (isEmpty(password)){
            nama.setError("Password is required!");
        }

        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }
    }
}

