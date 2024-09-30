package com.example.myapplication ;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity {

    private EditText nameField, emailField, passwordField;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        // Initializing the fields
        nameField = findViewById(R.id.editTextName);
        emailField = findViewById(R.id.editTextEmail);
        passwordField = findViewById(R.id.editTextPassword);
        signupButton = findViewById(R.id.signupButton);

        // Handle signup button click
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String name = nameField.getText().toString().trim();
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        // Simple validation
        if (TextUtils.isEmpty(name)) {
            nameField.setError("Name is required");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            emailField.setError("Email is required");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            passwordField.setError("Password is required");
            return;
        }
        if (password.length() < 6) {
            passwordField.setError("Password must be at least 6 characters");
            return;
        }

        // Proceed with user registration (you can add Firebase/Auth logic here)
        Toast.makeText(signup.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();

        // Reset fields after signup
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
    }
}

