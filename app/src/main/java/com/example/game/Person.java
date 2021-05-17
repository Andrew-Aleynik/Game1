package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.game.Level;

import static com.example.game.Level.level1;
import static com.example.game.Levels.getXTasks1;
import static com.example.game.Levels.getYTasks1;
import static com.example.game.Levels.tasks1;
import static com.example.game.PersonSettings.getColor;

public class Person {
    public float x;
    public float y;  // координаты
    public float size; // размер
    public int color;// цвет персонажа
    Paint person;
    Joystick joystick;
    private final float pixels_per_second=160f;// расстояние, преодолеваемое в секунду
    private final float max_speed=pixels_per_second/Game.max_ups; // максимальная скорость допустимая для fps
    protected float shift_time=2; // длительность бега
    public int complete_bar=0;
    private float distance;
    private boolean complete=false;
    private float min_distance;
    public float velocityX;
    public float velocityY;
    private float NextPosX1 = x + velocityX + size;
    private float NextPosX2 = x + velocityX - size;
    private float NextPosY1 = y + velocityY + size;
    private float NextPosY2 = y + velocityY - size;

    public Person(Joystick joystick){
        size=15;
        x=Levels.getPX()*50;
        y=Levels.getPY()*50+size*2;
        color=getColor();
        person = new Paint();
        person.setColor(Color.WHITE);
        person.setStyle(Paint.Style.FILL);
        this.joystick=joystick;
    }

    private boolean canMoveX(){
       if (level1[(int)(y/50)][(int)(NextPosX1/50)]==1 && level1[(int)(y/50)][(int)(NextPosX2/50)]==1) {
           return true;
       }else{
           return false;
       }
    }
    private boolean canMoveY(){
        if (level1[(int)(NextPosY1/50)][(int)(x/50)]==1 && level1[(int)(NextPosY2/50)][(int)(x/50)]==1) {
            return true;
        }else{
            return false;
        }
    }
    /*private boolean canMoveX(){
        for(int j = 0; j < level1.length; j++) {
            for (int i = 0; i < level1.length; i++) {
                if (level1[i][j] == 1) {
                    if ((i * 50 <= NextPosY1 && NextPosY1 <= (i+1)*50) ||
                        (i * 50 <= NextPosY2 && NextPosY2 <= (i+1)*50)){
                        if(j * 50 <= NextPosX1 && NextPosX1 <= ((j + 1) * 50) ||
                           j * 50 <= NextPosX2 && NextPosX2 <= ((j + 1) * 50)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }*/
    void update(){
        velocityX = (float) (joystick.getActuatorX()*max_speed);
        velocityY = (float) (joystick.getActuatorY()*max_speed);
        if(level1[(int)(y/50)][(int)(x/50)]==2){
            for (int i=0;i<5;i++){
                if(getXTasks1(i)==(int)(x/50) && getYTasks1(i)==(int)(y/50)){
                    tasks1[i][3]=1;
                }
            }
        }
        /*if(!canMoveX()){
            velocityX=0;
        }
        if(!canMoveY()){
            velocityY=0;
        }*/
        x+=velocityX;
        y+=velocityY;
    }



    void draw(Canvas canvas){
        canvas.drawCircle(x,y,size,person);
    }
}

