package com.example.a503_14.a1011view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_use);

        //이벤트핸들링 할꺼니까 final로 찾아오기
        final ProgressBar lect=(ProgressBar)findViewById(R.id.progress1);
        final ProgressBar circle=(ProgressBar)findViewById(R.id.progress2);

        //여러 개의 클릭 이벤트를 처리하기 위한 핸들러 만들기
        View.OnClickListener eventHandler=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.start:
                        lect.setProgress(lect.getProgress()+20);
                        circle.setVisibility(View.VISIBLE);
                        break;
                    case R.id.end:
                        lect.setProgress(lect.getProgress()-20);
                        circle.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        };
        Button start=(Button)findViewById(R.id.start);
        Button end=(Button)findViewById(R.id.end);
        start.setOnClickListener(eventHandler);
        end.setOnClickListener(eventHandler);

        SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);
        final TextView textView=(TextView)findViewById(R.id.value);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //매개변수 progress는 int니까 아래와 같은 형식
                //textView.setText(progress +"");
                //textView.setText(String.format("%d", progress));
                //변경될 때마다 숫자 값이 변경되니까 stop에 가서 처리(마지막 숫자 값만 보여줌)
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Listener안에 있으니까 ProgressUse.this, 밖에 있으면 this만 줘도 가능
                Toast.makeText(ProgressUse.this, "값 변경 시작", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText(String.format("%d", seekBar.getProgress()));
                Toast.makeText(ProgressUse.this, "값 변경 종료", Toast.LENGTH_LONG).show();
            }
        });

        RatingBar ratingBar=(RatingBar)findViewById(R.id.ratingBar);
        final TextView ratingText=(TextView)findViewById(R.id.ratingvalue);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            //rating이 값
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingText.setText(String.format("%f", rating));
            }
        });

    }
}
