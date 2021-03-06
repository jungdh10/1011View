package com.example.a503_14.a1011view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_use);


        //레이아웃 파일에 있는 View 객체 모두 찾아오기(안에서 사용할 거니까 final붙여주기)
        final EditText addr=(EditText)findViewById(R.id.addr);
        final WebView webView=(WebView)findViewById(R.id.webView);
        Button local=(Button)findViewById(R.id.local);
        Button url=(Button)findViewById(R.id.url);

        //웹화면 만들어서 보여주기위해 사용(이 설정이 없으면 크롬으로 보여주고 빠져나가버림)
        //리다이렉트되는 URL을 요청할 때 WebView가 처리하도록 설정
        webView.setWebViewClient(new WebViewClient());
        //자바스크립트 사용과 확대 축소를 사용할 수 있도록 설정
        WebSettings set=webView.getSettings();
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(true);

        //웹 뷰를 이용해서 외부 URL 읽기
        webView.loadUrl("https://www.apple.com");

        //버튼의 클릭이벤트를 처리하는 Listener 객체를 생성
        View.OnClickListener eventHandler=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.local:
                        //로컬에 있는 파일 읽기
                        webView.loadUrl("file:///android_asset/test.html");
                        break;
                    case R.id.url:
                        webView.loadUrl(addr.getText().toString());
                        /*
                        if(webView.canGoBack()){
                            webView.goBack();
                        }
                        */
                        break;

                }
            }
        };
        //버튼에 리스너 연결
        local.setOnClickListener(eventHandler);
        url.setOnClickListener(eventHandler);
    }
}
