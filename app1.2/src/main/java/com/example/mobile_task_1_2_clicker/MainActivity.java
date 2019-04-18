package com.example.mobile_task_1_2_clicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    Button mainbtn;
    Button mainbtn2;
    Button mainbtn3;
    ImageView imgbtn;

    private long score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.mainText);
        mainbtn = (Button) findViewById(R.id.button);
        mainbtn2 = (Button) findViewById(R.id.mainbtn2);
        mainbtn3 = (Button) findViewById(R.id.mainbtn3);
        imgbtn = (ImageView) findViewById(R.id.image_view);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button:
                        score++;
                        if(score%10>1 && score%10<5 && score%12!=0 && score%13!=0 && score%14!=0 && score%15!=0){
                            {
                                String s = "Кнопка нажата: " + score + " раза";
                                mainText.setText(s.toCharArray(), 0, s.length());
                            }}
                        else {
                            String ss = "Кнопка нажата: " + score + " раз";
                            mainText.setText(ss.toCharArray(), 0, ss.length());
                        }
                        break;
                    case R.id.mainbtn2:
                        if(score>0){
                            if(score%10>2 && score%10<5 && score%12!=0 && score%13!=0 && score%14!=0 && score%15!=0){
                                String ss = "Кнопка нажата: " + --score + " раза";
                                mainText.setText(ss.toCharArray(), 0, ss.length());                                }
                            else {
                                String ss = "Кнопка нажата: " + --score + " раз";
                                mainText.setText(ss.toCharArray(), 0, ss.length());}}
                        break;
                    case R.id.mainbtn3:
                        score=0;
                        mainText.setText("Кнопка нажата: "+ score + " раз");
                        break;
                    case R.id.image_view:
                        score=0;
                        mainText.setText("Кнопка нажата: "+ score + " раз");
                        break;
                }
            }
        };

        mainbtn.setOnClickListener(clickListener);
        mainbtn2.setOnClickListener(clickListener);
        mainbtn3.setOnClickListener(clickListener);
        imgbtn.setOnClickListener(clickListener);

    }
}

