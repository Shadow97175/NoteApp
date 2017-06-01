package com.example.noteapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Николай on 29.05.2017.
 */

public class NoteLength implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.division);
        dest.writeByte(this.dot ? (byte) 1 : (byte) 0);
    }

    protected NoteLength(Parcel in) {
        this.division = in.readInt();
        this.dot = in.readByte() != 0;
    }

    public static final Creator<NoteLength> CREATOR = new Creator<NoteLength>() {
        @Override
        public NoteLength createFromParcel(Parcel source) {
            return new NoteLength(source);
        }

        @Override
        public NoteLength[] newArray(int size) {
            return new NoteLength[size];
        }
    };
}