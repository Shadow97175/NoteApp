package com.example.noteapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Parcel;

/**
 * Created by Николай on 29.05.2017.
 */

public class Note implements Element {
    private int octave;
    private NoteSound noteSound;
    private NoteLength length;
    private int startTime;

    public Note()
    {
        octave = 1;
        noteSound = NoteSound.DO;
        length = new NoteLength();
        startTime = 0;
    }

    public Note(int octave, NoteSound noteSound, NoteLength length, int startTime)
    {
        this.octave = octave;
        this.noteSound = noteSound;
        this.length = length;
        this.startTime = startTime;
    }

    public Note(int startTime, int line)
    {
        this.startTime = startTime;
        this.length = new NoteLength();

        octave = line / 7 - 1;
        noteSound = NoteSound.values()[line % 7];

    }

    public int getLine()
    {
        return noteSound.ordinal() + (octave + 1) * 7;
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
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @Override
    public int getDrawable() {
        switch (length.division) {
            case 0: return R.drawable.wholenote;
            case 1: return R.drawable.halfnote;
            case 2: return R.drawable.quarternote;
            case 3: return R.drawable.eighthnote;
            case 4: return R.drawable.sixteenthnote;
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


    public String toString(){
        return "Octave: " + octave + ", " + noteSound.toString() + ", " + "Length in seconds: " + length.getSeconds();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.octave);
        dest.writeInt(this.noteSound == null ? -1 : this.noteSound.ordinal());
        dest.writeParcelable(this.length, flags);
        dest.writeInt(this.startTime);
    }

    protected Note(Parcel in) {
        this.octave = in.readInt();
        int tmpNoteSound = in.readInt();
        this.noteSound = tmpNoteSound == -1 ? null : NoteSound.values()[tmpNoteSound];
        this.length = in.readParcelable(NoteLength.class.getClassLoader());
        this.startTime = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}