package com.example.numbers_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button goBtn;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locAnswers;
    TextView answerTv;
    int score=0;
    int numberQuestions=0;
    TextView scoreTv;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTv;
    TextView timerTv;
    Button playAgainBtn;
    ConstraintLayout constraint1;



    public void newQuestion(){
        Random random = new Random();

        int a = random.nextInt(21);
        int b = random.nextInt(31);
        sumTv.setText(Integer.toString(a) + "+" + Integer.toString(b));

        locAnswers = random.nextInt(4);
        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i== locAnswers) {
                answers.add(a + b);
            } else {
                int wrongAnswer=random.nextInt(51);
                while(wrongAnswer==a+b){
                    wrongAnswer=random.nextInt(51);
                }

                answers.add(wrongAnswer);
            }

        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    public  void playAgain(View view){
        score=0;
        numberQuestions=0;
        timerTv.setText("30s");
        scoreTv.setText(Integer.toString(score) +"/"+ Integer.toString(numberQuestions));
        newQuestion();
        playAgainBtn.setVisibility(View.INVISIBLE);
        answerTv.setText("");

        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long l) {
                timerTv.setText(String.valueOf(l/1000)+ "s");

            }

            @Override
            public void onFinish() {
               // scoreTv.setText("Done!!!");
                playAgainBtn.setVisibility(View.VISIBLE);
            }
        }.start();


    }

   public  void chooseAnswer(View view){
       if(Integer.toString(locAnswers).equals(view.getTag().toString())) {
           answerTv.setText("Correct! :)");
           score++;
       }else{
           answerTv.setText("Wrong! :(");
       }
     numberQuestions++;
       scoreTv.setText(Integer.toString(score) +"/"+ Integer.toString(numberQuestions));
       newQuestion();
   }


    public void start(View view) {

        goBtn.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.timerTv));
        constraint1.setVisibility(View.VISIBLE);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         button0=findViewById(R.id.button0);
         button1=findViewById(R.id.button1);
         button2=findViewById(R.id.button2);
         button3=findViewById(R.id.button3);
        goBtn = findViewById(R.id.goBtn);
        sumTv = findViewById(R.id.sumTv);
        answerTv=findViewById(R.id.answerTv);
        scoreTv=findViewById(R.id.scoreTv);
        timerTv=findViewById(R.id.timerTv);
        playAgainBtn=findViewById(R.id.playAgainBtn);
        constraint1=findViewById(R.id.constraint1);

        goBtn.setVisibility(View.VISIBLE);
        constraint1.setVisibility(View.INVISIBLE);


    }
}