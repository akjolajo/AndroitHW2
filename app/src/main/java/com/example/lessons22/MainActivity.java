package com.example.lessons22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView imageCar;
    private EditText email, password;
    private Button go;
    private TextView forgotPassword;
    private String url = "http://i.imgur.com/DvpvklR.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        go = findViewById(R.id.button_go);
        forgotPassword = findViewById(R.id.forgetpassword);
        imageCar = findViewById(R.id.image_car);
        setImageCar();


        go.setOnClickListener(v -> {
            if (password.getText().toString().length() > 6) {
                Intent intent = new Intent(MainActivity.this, Second_activity.class);
                intent.putExtra("login",email.getText().toString());
                intent.putExtra("pass",password.getText().toString());
                startActivity(intent);
            }
        });
    }
    private void setImageCar(){
        String URI = "https://i.pinimg.com/474x/23/ab/a6/23aba60b66ef08174bb7455c4a8a2d2f.jpg";
        Glide.with(MainActivity.this).load(URI).into(imageCar);

    }
    }

