package com.example.ooptesting1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAlphabets, btnNumbers, btnColours, btnShapes, btnBodyParts, btnAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAlphabets = findViewById(R.id.btnAlphabets);
        btnNumbers = findViewById(R.id.btnNumbers);
        btnColours = findViewById(R.id.btnColours);
        btnShapes = findViewById(R.id.btnShapes);
        btnBodyParts = findViewById(R.id.btnBodyParts);
        btnAnimals = findViewById(R.id.btnAnimals);

        btnAlphabets.setOnClickListener(this);
        btnNumbers.setOnClickListener(this);
        btnColours.setOnClickListener(this);
        btnShapes.setOnClickListener(this);
        btnBodyParts.setOnClickListener(this);
        btnAnimals.setOnClickListener(this);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.btnAlphabets) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("QuizCategoriesNum",0);
            startActivity(intent);
        } else if (v.getId() == R.id.btnNumbers) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("QuizCategoriesNum",1);
            startActivity(intent);
        } else if (v.getId() == R.id.btnColours) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("QuizCategoriesNum",2);
            startActivity(intent);
        } else if (v.getId() == R.id.btnShapes) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("QuizCategoriesNum",3);
            startActivity(intent);
        } else if (v.getId() == R.id.btnBodyParts) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("QuizCategoriesNum",4);
            startActivity(intent);
        } else if (v.getId() == R.id.btnAnimals) {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("QuizCategoriesNum",5);
            startActivity(intent);
        }

    }
}
