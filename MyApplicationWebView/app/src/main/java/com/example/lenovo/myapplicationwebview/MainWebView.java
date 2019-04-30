package com.example.lenovo.myapplicationwebview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainWebView extends AppCompatActivity {

    private WebView webView;
    private String Url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWeb();
        viewWeb();
    }
    public void getWeb(){
        webView = findViewById(R.id.webview);
        Uri uri = getIntent().getData();
        if(uri == null)
            Url = "www.baidu.com";
        else
            Url = uri.toString();

    }

    public void viewWeb(){
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);

        webView.loadUrl(Url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                webView.loadUrl(Url);
                return true;
            }
        });
    }
}
