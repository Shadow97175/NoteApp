package com.example.noteapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;

/**
 * Created by Николай on 29.05.2017.
 */

public class Pause implements Element {

    private NoteLength length;
    private int startTime;
    private int line;

    public Pause(NoteLength length, int startTime)
    {
        this.length = length;
        this.startTime = startTime;
    }

    public Pause(int startTime, int line)
    {
        this.startTime = startTime;
        this.length = new NoteLength();
        this.line = line;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @Override
    public int getDrawable() {
        switch (length.division) {
            case 0: return R.drawable.wholepause;
            case 1: return R.drawable.halfpause;
            case 2: return R.drawable.quarterpause;
            case 3: return R.drawable.eighthpause;
            case 4: return R.drawable.sixteenthpause;
            default: return R.drawable.brush;
        }
    }

    @Override
    public boolean hasDot() {
        return length.dot;
    }

    @Override
    public void nextDot() {
        length.changeDot();
    }

    @Override
    public int getStartTime() {
        return startTime;
    }

    @Override
    public void nextLength() {
        length.next();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.length, flags);
        dest.writeInt(this.startTime);
        dest.writeInt(this.line);
    }

    protected Pause(Parcel in) {
        this.length = in.readParcelable(NoteLength.class.getClassLoader());
        this.startTime = in.readInt();
        this.line = in.readInt();
    }

    public static final Creator<Pause> CREATOR = new Creator<Pause>() {
        @Override
        public Pause createFromParcel(Parcel source) {
            return new Pause(source);
        }

        @Override
        public Pause[] newArray(int size) {
            return new Pause[size];
        }
    };
}