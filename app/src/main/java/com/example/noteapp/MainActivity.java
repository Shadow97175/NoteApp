package com.example.noteapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ActionElementListener {

    public static final String KEY_NOTES_LIST = "key_notes_list";

    private DrawView drawView;
    private ArrayList<Element> savedNotes;


    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList(KEY_NOTES_LIST, savedNotes);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedNotes = savedInstanceState.getParcelableArrayList(KEY_NOTES_LIST);
        drawView.createNotesFromList(savedNotes);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView = (DrawView) findViewById(R.id.drawing);
        drawView.setActionElementListener(this);
        LinearLayout paintLayout = (LinearLayout) findViewById(R.id.paint_colors);

        ImageButton currPaint = (ImageButton) paintLayout.getChildAt(0);
        currPaint.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paint_pressed));
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

    @Override
    public void createElement(Element element) {
        if (savedNotes == null) {
            savedNotes = new ArrayList<>();
        }
        savedNotes.add(element);
    }
}