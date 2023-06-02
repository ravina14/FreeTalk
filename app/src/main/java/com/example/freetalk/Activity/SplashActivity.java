package com.example.freetalk.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.freetalk.Helper.Utilities;
import com.example.freetalk.R;
import com.example.freetalk.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private Utilities utilities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        ActivitySplashBinding viewBinding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        nextScreenOpen();
    }

    private void init(){
        utilities = new Utilities(this);

        //utilities.setLanguage("en");
        utilities.setLanguage("ko");
    }

    private void nextScreenOpen(){
        new Handler().postDelayed(() -> {
            utilities.enterActivity(new Intent(this, MainActivity.class));
            utilities.exitActivity();

        }, 3000L);
    }
}