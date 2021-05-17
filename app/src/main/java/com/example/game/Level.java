package com.example.game;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.core.content.res.ResourcesCompat;

import static com.example.game.GameView.unitW;

public class Level {
    int bitmapId;
    public static byte[][] level1=
           {{0,0,2,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,0,0,0,0,2,0,0,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,0,0,0,1,0,0,1,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,0,0,1,0,1,0},
            {0,1,1,0,0,0,1,1,1,0,0,1,0,1,0},
            {0,1,1,0,0,0,1,1,1,1,1,1,0,1,0},
            {0,1,2,0,0,0,1,0,0,1,0,0,0,1,0},
            {0,1,1,1,1,1,1,0,0,1,0,0,0,1,0},
            {0,1,1,0,0,0,1,1,1,1,1,1,1,1,0},
            {0,1,1,0,2,0,0,1,0,0,0,1,1,1,0},
            {0,1,1,0,1,1,0,1,0,0,0,1,1,1,0},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
            {0,1,1,1,1,1,0,0,0,0,0,1,1,1,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,2,0,0}};

    void draw(Canvas canvas, Paint paint){ // рисуем картинку
        for(int j=0,z=0;j<level1.length;j++){
            for(int i=0;i<level1.length;i++){
                switch (level1[i][j]) {
                    case 0: bitmapId=R.drawable.wall;
                        paint.setColor(Color.BLACK);
                    break;
                    case 1: bitmapId=R.drawable.floor;
                        paint.setColor(Color.GRAY);
                    break;
                    case 2:
                        if (!Levels.getComplete(z)){
                            bitmapId=R.drawable.task_active;
                            paint.setColor(Color.RED);
                            break;
                        }else{
                            bitmapId=R.drawable.task_disactive;
                            paint.setColor(Color.GREEN);
                            break;
                        }
                }
                canvas.drawRect(j*50,i*50,(j+1)*50,(i+1)*50, paint);
            }
        }
    }

    public void update() {

    }
}

