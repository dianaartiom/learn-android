package com.example.diana.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static Button button_submit;
    private static EditText editText;
    private static WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openUrl();
    }

    public void openUrl() {
        button_submit = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        browser = (WebView) findViewById(R.id.webView);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editText.getText().toString();

                browser.getSettings().setLoadsImagesAutomatically(true);
                browser.getSettings().setJavaScriptEnabled(true);
                browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

                // now we can load some url to browser
                browser.loadUrl(url);
            }
        });
    }
}
