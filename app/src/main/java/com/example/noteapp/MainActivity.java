package com.example.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DrawView drawView;
    private ImageButton currPaint;
    public ArrayList savedNotes = new ArrayList();

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList("key", savedNotes);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedNotes = savedInstanceState.getParcelableArrayList("key");
        for (int i = 0; i < savedNotes.size(); i++){
            drawView.createNote(float x, float y, boolean pauseTool);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView = (DrawView) findViewById(R.id.drawing);
        LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paint_colors);
        currPaint = (ImageButton) paintLayout.getChildAt(0);
        currPaint.setImageDrawable(getResources().getDrawable(R.drawable.paint_pressed));
    }

    public void normalPaint(View view) {
        drawView.setTool(false);
        drawView.setDotTool(false);
        drawView.setPauseTool(false);
    }

    public void deletePaint(View view) {
        drawView.setTool(true);
    }


    public void dotPaint(View view) {
        drawView.setDotTool(true);
    }

    public void pausePaint(View view) {
        drawView.setPauseTool(true);
    }
}