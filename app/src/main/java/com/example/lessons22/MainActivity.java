package com.example.lessons22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

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


        Picasso.get().load(url).into(imageCar);


            go.setOnClickListener(v ->{
                if(password.getText().toString().length() > 6) {
                    Intent intent = new Intent(MainActivity.this, second_activity.class);
                    startActivity(intent);
                }
            });
        }
    }

