package com.example.lessons22;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Second_activity extends AppCompatActivity {
    private ImageView imageforprofil;
    private EditText emailText;
    private EditText passText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        emailText = findViewById(R.id.SAemail);
        passText = findViewById(R.id.SApassword);
        Intent intent = getIntent();
        String email = (String) intent.getSerializableExtra("login");
        String pass = (String) intent.getSerializableExtra("pass");
        String sETxt = emailText.getText().toString();
        String sPTxt = passText.getText().toString();
        if (sETxt.equals("") &&sPTxt.equals("") ) {
            emailText.setText(email);
            passText.setText(pass);
        }

        imageforprofil = findViewById(R.id.iv_from_camera);

        imageforprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, RESULT_OK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && requestCode == RESULT_OK){
            Toast.makeText(this, "text", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, (CharSequence) data.getData(), Toast.LENGTH_SHORT).show();
            imageforprofil.setImageURI(data.getData());
        }else{
            Toast.makeText(this, "text222", Toast.LENGTH_SHORT).show();

        }
    }
}