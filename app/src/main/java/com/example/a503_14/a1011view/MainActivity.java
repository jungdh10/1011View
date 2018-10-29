package com.example.a503_14.a1011view;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=(TextView)findViewById(R.id.textView);
        //스크롤 가능하도록 설정(이미지 사용해야 해서 설정)
        textView.setMovementMethod(new ScrollingMovementMethod());

        String data="포로리 \n img \n 텍스트 중간에" + "이미지를 출력하고 제목 부분만 서식을 변경합니다.";

        //img부분에 이미지 삽입하기
        SpannableStringBuilder builder=new SpannableStringBuilder(data);
        //삽입할 시작 위치 찾기
        int start=data.indexOf("img");
        //삽입할 종료 위치 찾기
        int end=start +"img".length();
        //출력할 이미지 찾기
        Drawable dr= ResourcesCompat.getDrawable(getResources(), R.drawable.porori, null);
        //이미지 추출하기(세 번째, 네 번째 매개변수에 dr.getInstricWidth(), dr.getInstricHieght()하면 이미지 본래의 크기)
        dr.setBounds(0,0,800, 1000);
        //이미지를 출력하기 위한 Span 만들기
        ImageSpan imageSpan=new ImageSpan(dr);
        //SpannableBuilder에 적용
        builder.setSpan(imageSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //"포로리" 부분의 서식을 변경
        start=data.indexOf("포로리");
        end=start + "포로리".length();
        StyleSpan styleSpan=new StyleSpan(Typeface.BOLD_ITALIC);
        RelativeSizeSpan sizeSpan=new RelativeSizeSpan(2.0f);
        builder.setSpan(styleSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(sizeSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        //텍스트 뷰에 적용
        textView.setText(builder);
    }
}
