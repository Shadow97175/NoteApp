package com.example.noteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Николай on 29.05.2017.
 */

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.buttonNote).setOnClickListener(this);
        findViewById(R.id.buttonHelp).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonNote:
                MainActivity.start(this);
                break;
            case R.id.buttonHelp:
                HelpActivity.start(this);
                break;
        }
    }
}
