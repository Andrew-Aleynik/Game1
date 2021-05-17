package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Joystick {
    //int Jx=750
    //int Jy=1615;
    private Paint OutCirPaint;
    private Paint InCirPaint;
    private int InCirR;
    private int OutCirR;
    private int InCirPosX;
    private int InCirPosY;
    private int OutCirPosX;
    private int OutCirPosY;
    public boolean isPressed = false;
    private double joystickCenterToTouchDistance;
    private double actuatorX;
    private double actuatorY;

    public Joystick(int CenterX, int CenterY, int InCirR,int OutCirR){
        InCirPosX=CenterX;
        InCirPosY=CenterY;
        OutCirPosX=CenterX;
        OutCirPosY=CenterY;
        this.InCirR=InCirR;
        this.OutCirR=OutCirR;

        OutCirPaint=new Paint();
        OutCirPaint.setColor(Color.BLUE);
        OutCirPaint.setStyle(Paint.Style.FILL_AND_STROKE);

        InCirPaint=new Paint();
        InCirPaint.setColor(Color.BLACK);
        InCirPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }
    public void draw(Canvas canvas){
        canvas.drawCircle(OutCirPosX,OutCirPosY,OutCirR,OutCirPaint);
        canvas.drawCircle(InCirPosX,InCirPosY,InCirR,InCirPaint);
    }

    public void update() {
        updateInnerCirclePosition();
    }

    private void updateInnerCirclePosition() {
        InCirPosX = (int) (OutCirPosX + actuatorX*OutCirR);
        InCirPosY = (int) (OutCirPosY + actuatorY*OutCirR);
    }

    public void setActuator(double touchPositionX, double touchPositionY) {
        double deltaX = touchPositionX - OutCirPosX;
        double deltaY = touchPositionY - OutCirPosY;
        double deltaDistance = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));

        if(deltaDistance < OutCirR) {
            actuatorX = deltaX/OutCirR;
            actuatorY = deltaY/OutCirR;
        } else {
            actuatorX = deltaX/deltaDistance;
            actuatorY = deltaY/deltaDistance;
        }
    }

    public boolean isPressed(double touchPositionX, double touchPositionY) {
        joystickCenterToTouchDistance = Math.sqrt(
                Math.pow(OutCirPosX - touchPositionX, 2) +
                        Math.pow(OutCirPosY - touchPositionY, 2)
        );
        return joystickCenterToTouchDistance < OutCirR;
    }

    public boolean getIsPressed() {
        return isPressed;
    }

    public void setIsPressed(boolean isPressed) {
        this.isPressed = isPressed;
    }

    public double getActuatorX() {
        return actuatorX;
    }

    public double getActuatorY() {
        return actuatorY;
    }

    public void resetActuator() {
        actuatorX = 0;
        actuatorY = 0;
    }
}
