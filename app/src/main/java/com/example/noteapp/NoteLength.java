package com.example.noteapp;

/**
 * Created by Николай on 29.05.2017.
 */

public class NoteLength {
    public int division;
    public boolean dot;
    public final static int finalDivision = 4;

    public NoteLength(int division, boolean dot){
        this.division = division;
        this.dot = dot;
    }

    public NoteLength(){
        division = 0;
        dot = false;
    }

    double getSeconds(){
        return (dot ? 1.5 : 1) * Math.pow(2,-division);
    }

    public void next() {
        ++division;
        if (division > finalDivision)
            division = 0;
    }

    public void changeDot() {
        dot = !dot;
    }
}