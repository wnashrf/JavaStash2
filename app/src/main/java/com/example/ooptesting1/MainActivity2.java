package com.example.ooptesting1;
/*
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    private Button btnRightAns, btnWrongAns;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnRightAns = findViewById(R.id.btnAnsRight);
        btnWrongAns = findViewById(R.id.btnAnsWrong);
        builder = new AlertDialog.Builder(this);
        btnRightAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Correct Answer!")
                        .setMessage("Do you want to continue?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
            }
        });
        btnWrongAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setTitle("Wrong Answer!")
                        .setMessage("Do you want to try again?")
                        .setCancelable(true)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
            }
        });
    }


}*/
//---------------------------------------------------------------------------------------------------------------------


import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView, questionTextView;
    Button ansA, ansB, ansC, ansD, submitBtn;

    int score=0;
    int totalQuestion = QandA.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

//    class QandA {
//        public static String question[] = {
//                "What is the color of the above shape??",
//                "What animal is this?",
//                "Which body part is this?",
//                "What shape is this?"
//        };
//
//        public static String choices[][] = {
//                {"Pink","Red","Green","Brown"},
//                {"Armadillo","Cat","Giraffe","Elephant"},
//                {"Leg","Nose","Ear","Hand"},
//                {"Circle","Triangle","Oval","Rectangle"}
//        };
//
//        public static String correctAnswers[] = {
//                "Red",
//                "Elephant",
//                "Hand",
//                "Triangle"
//        };
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        totalQuestionsTextView = findViewById(R.id.txtnumQuestion);
        questionTextView = findViewById(R.id.txtQuestion);
        ansA = findViewById(R.id.btnAnsA);
        ansB = findViewById(R.id.btnAnsB);
        ansC = findViewById(R.id.btnAnsC);
        ansD = findViewById(R.id.btnAnsD);
        submitBtn = findViewById(R.id.btnSubmit);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions : "+totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.btnSubmit){
            if(selectedAnswer.equals(QandA.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
        }else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            finishQuiz();
            return;
        }

        questionTextView.setText(QandA.question[currentQuestionIndex]);
        ansA.setText(QandA.choices[currentQuestionIndex][0]);
        ansB.setText(QandA.choices[currentQuestionIndex][1]);
        ansC.setText(QandA.choices[currentQuestionIndex][2]);
        ansD.setText(QandA.choices[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Congratulations you pass!";
        }else{
            passStatus = "Failed, you can try again later.";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+ score+" out of "+ totalQuestion)
                .setPositiveButton("Restart",(dialogInterface, i) -> restartQuiz() )
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }


}