package com.example.game;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;

public class Buttons {
    String name;
    int lefttopX;
    int lefttopY;
    int rightbotX;
    int rightbotY;
    Paint paint;
    boolean isPressed=false;
    @SuppressLint("ResourceAsColor")
    public Buttons(int X, int Y, int Z, int Q, String name){
        int lefttopX=X;
        int lefttopY=Y;
        int rightbotX=Z;
        int rightbotY=Q;
        this.name=name;
        paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
    }
    public void draw(Canvas canvas){
        canvas.drawRect(lefttopX, lefttopY, rightbotX, rightbotY, paint);
    }
    public boolean isPressed(int touchX, int touchY){
        return touchX<lefttopX && touchX>rightbotX && touchY<lefttopY && touchY>rightbotY;
    }
    public void setisPressed(boolean isPressed){
        this.isPressed=isPressed;
    }
}
