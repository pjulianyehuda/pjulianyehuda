package com.example.pauljulianuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class AddUserActivity extends AppCompatActivity implements TextWatcher {

    TextInputLayout inputFName, inputAge, inputAddress;
    Button button_tambah;
    String fname, address, age;
    Toolbar toolbar;
    myDbAdapter helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        inputFName = findViewById(R.id.input_fname);
        inputAge = findViewById(R.id.input_age);
        inputAddress = findViewById(R.id.input_address);
        button_tambah = findViewById(R.id.button_tambah);








        helper = new myDbAdapter(this);

        inputFName.getEditText().addTextChangedListener(this);
        inputAge.getEditText().addTextChangedListener(this);
        inputAddress.getEditText().addTextChangedListener(this);

        toolbar = findViewById(R.id.tooladd);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        button_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            long id = helper.insertData(fname,age,address);
                            Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    },3000);

            }
        });

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        fname = inputFName.getEditText().getText().toString().trim();
        age = inputAge.getEditText().getText().toString().trim();
        address = inputAddress.getEditText().getText().toString().trim();

        if (!fname.isEmpty() && !address.isEmpty() && !age.isEmpty()){
            button_tambah.setEnabled(true);
        }else{
            button_tambah.setEnabled(false);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }public boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onResume(){
        super.onResume();
        this.doubleBackToExitPressedOnce=false;
    }

    @Override
    public void onBackPressed(){
        if (doubleBackToExitPressedOnce){
            Intent a = new Intent(Intent.ACTION_MAIN);
            a.addCategory(Intent.CATEGORY_HOME);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(a);
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(AddUserActivity.this,"Press back again to close the apps!",Toast.LENGTH_SHORT).show();
    }




    }


