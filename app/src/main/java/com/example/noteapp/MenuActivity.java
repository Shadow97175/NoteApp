package com.example.noteapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Николай on 29.05.2017.
 */

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MenuActivity.this, HelpActivity.class);
        startActivity(intent);
    }

    public static final String ACTION_SECOND_ACTIVITY = "com.example.noteapp.MainActivity";

    public void onClick(View view) {
        startActivity(new Intent(ACTION_SECOND_ACTIVITY));
    }
}
