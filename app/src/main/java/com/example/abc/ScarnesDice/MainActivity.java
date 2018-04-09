package com.example.abc.ScarnesDice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private Button ButtonRoll,ButtonHold,ButtonReset,ButtonHold2,ButtonRoll2;
    ImageView Imageview;


    Timer myTimer;
    TextView Playerscoretext,playerturntext,computerscoretext,computerturntext;

      int turnscore=0;
    int Compturnscore=0;

    int OverallScoreofPlayer=0;
    int CompOverallScore=0;

    public static int randomDiceValue(){
        return RANDOM.nextInt(6)+1;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButtonRoll=findViewById(R.id.ROLL);
        ButtonHold=findViewById(R.id.HOLD);
        ButtonRoll2=findViewById(R.id.ROLL2);
        ButtonHold2=findViewById(R.id.HOLD2);
        ButtonReset=findViewById(R.id.RESET);


        final TextView Playerscoretext=findViewById(R.id.playerscore);
        final TextView playerturntext=findViewById(R.id.playerTurnscore);
       final TextView computerscoretext=findViewById(R.id.Computerscore);
        final TextView computerturntext=findViewById(R.id.ComputerTurnscore);

        Imageview=findViewById(R.id.ImageView1);


        ButtonRoll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View v) {

                final Animation anim1= AnimationUtils.loadAnimation(MainActivity.this,R.anim.shake);

                final Animation.AnimationListener animationListener=new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }
                    public void onAnimationEnd(Animation animation) {
                        final int value2= randomDiceValue();

                        int res1= getResources().getIdentifier("dice" + value2, "drawable","com.example.abc.scannerdice");


                        Imageview.setImageResource(res1);
                        if(value2==1){
                            Compturnscore=0;
                            enablebutton2(false);
                            enablebutton(true);
                        }else {
                            Compturnscore = Compturnscore + value2;
                            computerturntext.setText("Computer Trun score:" + Compturnscore);
                            enablebutton(false);
                        }
                        ButtonHold2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                enablebutton(true);
                                enablebutton2(false);
                                CompOverallScore= CompOverallScore+Compturnscore;
                                computerscoretext.setText("Player2 score:" + CompOverallScore);
                                Compturnscore=0;
                                computerturntext.setText("Player2 Trun score:" + Compturnscore);



                            }
                        });


                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };
                anim1.setAnimationListener(animationListener);
                Imageview.startAnimation(anim1);
            }
        });

        ButtonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View v) {

                final Animation anim1= AnimationUtils.loadAnimation(MainActivity.this,R.anim.shake);

                final Animation.AnimationListener animationListener=new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }
                    public void onAnimationEnd(Animation animation) {
                        final int value= randomDiceValue();
                        int res= getResources().getIdentifier("dice" + value, "drawable","com.example.abc.scannerdice");

                        Imageview.setImageResource(res);
                        if(value==1){
                            turnscore=0;
                            enablebutton(false);
                            enablebutton2(true);
                        }else {
                            turnscore = turnscore + value;
                            playerturntext.setText("Player Trun score:" + turnscore);
                            enablebutton2(false);
                        }
                        ButtonHold.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                enablebutton2(true);
                                enablebutton(false);
                                OverallScoreofPlayer= OverallScoreofPlayer+turnscore;
                                Playerscoretext.setText("Player score:" + OverallScoreofPlayer);
                                turnscore=0;
                                playerturntext.setText("Player Trun score:" + turnscore);

                            }
                        });



                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                };
                anim1.setAnimationListener(animationListener);
                Imageview.startAnimation(anim1);
            }
        });


        ButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turnscore=0;
                OverallScoreofPlayer=0;
                CompOverallScore=0;
                Compturnscore=0;
                playerturntext.setText("Player Trun score:" + turnscore);
                Playerscoretext.setText("Player score:" + OverallScoreofPlayer);
                computerscoretext.setText("Computer score:" + CompOverallScore);
                computerturntext.setText("Computer score:" + Compturnscore);

                enablebutton2(true);
                enablebutton(true);

            }
        });


    };

    private void enablebutton(boolean isEnabled){
        ButtonRoll.setEnabled(isEnabled);
        ButtonHold.setEnabled(isEnabled);
    }
    private void enablebutton2(boolean isEnabled){
        ButtonRoll2.setEnabled(isEnabled);
        ButtonHold2.setEnabled(isEnabled);
    }
}
