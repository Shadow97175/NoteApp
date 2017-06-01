package com.example.noteapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by Николай on 29.05.2017.
 */

public interface Element extends Parcelable{

    int getLine();

    int getStartTime();

    void nextLength();

    void setStartTime(int i);

    int getDrawable();

    boolean hasDot();

    void nextDot();
}