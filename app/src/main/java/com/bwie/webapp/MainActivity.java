package com.bwie.webapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);

        findViewById(R.id.hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name="hao";
                webView.loadUrl("javascript:javaCallJs("+"'"+name+"'"+")");
            }
        });

        webView.loadUrl("file:///android_asset/index.html");

        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JSObject(), "myObj");

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                Toast.makeText(MainActivity.this,"Alert",Toast.LENGTH_SHORT).show();
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }
        });

        webView.setWebViewClient
                (new WebViewClient() {
                     @Override
                     public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                         return super.shouldInterceptRequest(view, request);
                     }

                     @Override
                     public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                         return super.shouldOverrideUrlLoading(view, request);
                     }

                     @Override
                     public boolean shouldOverrideUrlLoading(WebView view, String url) {
                         Log.d(getLocalClassName(),url);
                         //TODO 支付
                         return super.shouldOverrideUrlLoading(view, url);
                     }

                     @Override
                     public void onPageStarted(WebView view, String url, Bitmap favicon) {
                         super.onPageStarted(view, url, favicon);
                     }

                     @Override
                     public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                         return super.shouldInterceptRequest(view, url);
                     }

                     @Override
                     public void onPageFinished(WebView view, String url) {
                         super.onPageFinished(view, url);
                     }
                 }
                );
    }
}
