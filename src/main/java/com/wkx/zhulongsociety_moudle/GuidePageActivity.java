package com.wkx.zhulongsociety_moudle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class GuidePageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;

    private int countTimer = 5;
    private int port = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);
        initView();
        initTimer();
    }

    private void initView() {
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginButton:
                port = 200;
                Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void initTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (countTimer > 0 && port != 200) {
                            loginButton.setText("倒计时: " + countTimer);
                        } else if (countTimer == 0) {
                            loginButton.setText("完成");
                            Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        countTimer--;
                    }
                });
            }
        }, 0, 1000);
    }
}