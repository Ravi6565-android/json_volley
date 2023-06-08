package com.example.my_j_son_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.my_j_son_h.Image.Image_main_activity;
import com.example.my_j_son_h.comments.MainActivity;

public class home_page extends AppCompatActivity {

    Button cmt,image,other;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        cmt=findViewById(R.id.HP_comments);
        image=findViewById(R.id.HP_Image);
        cmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(home_page.this, MainActivity.class);
                startActivity(intent);

            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(home_page.this, Image_main_activity.class);
                startActivity(intent);
            }
        });
    }
}