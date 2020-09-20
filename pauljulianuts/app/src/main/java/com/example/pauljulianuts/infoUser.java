package com.example.pauljulianuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class infoUser extends AppCompatActivity {
    private User user;
    Button edit, delete;
    TextView nama, alamat, umur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infouser);

        nama = findViewById(R.id.txt_nama);
        alamat = findViewById(R.id.txt_alamat);
        umur  = findViewById(R.id.txt_umur);

        nama.setText(user.getName());
        alamat.setText(user.getAddress());
        umur.setText(user.getAge());

        edit = findViewById(R.id.button_edit);
        delete = findViewById(R.id.button_delete);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(infoUser.this, editUser.class);
                startActivity(intent);
            }
        });


    }
}
