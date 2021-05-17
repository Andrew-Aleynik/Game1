package com.example.game;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PersonSettings extends Activity implements View.OnClickListener {
    static int color;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_personsettings);
        super.onCreate(savedInstanceState);
        Button green=(Button)findViewById(R.id.green);
        green.setOnClickListener(this);
        Button white=(Button)findViewById(R.id.white);
        white.setOnClickListener(this);
        Button cian=(Button)findViewById(R.id.cian);
        cian.setOnClickListener(this);
        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(this);
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
    static int getColor(){
        return color;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.green:
                color=Color.GREEN;
            case R.id.white:
                color=Color.WHITE;
            case R.id.cian:
                color=Color.CYAN;
            case R.id.back:
                onDestroy();
        }
    }
}
