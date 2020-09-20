package com.example.pauljulianuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.pauljulianuts.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
        private myDbAdapter db;
        private List<User> listStudent = new ArrayList<>();
        private RecycleAdapter adapter;
        FloatingActionButton button_add;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            db = new myDbAdapter(this);
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

            listStudent = db.allPlayers();
            Log.e("main-list", listStudent.toString());
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager);



            adapter = new RecycleAdapter(this, listStudent);
            recyclerView.setAdapter(adapter);


            button_add = findViewById(R.id.addUser);
            button_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
                    startActivity(intent);
                }
            });
        }
        public boolean doubleBackToExitPressedOnce = false;

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
            Toast.makeText(MainActivity.this,"Press back again to close the apps!",Toast.LENGTH_SHORT).show();
        }

}
