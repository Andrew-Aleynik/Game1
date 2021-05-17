package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_startgame=(Button)findViewById(R.id.start_game);
        button_startgame.setOnClickListener(this);
        Button button_personsettings=(Button)findViewById(R.id.settings_person);
        button_personsettings.setOnClickListener(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId())
        {
            case R.id.start_game:
                i=new Intent(this,MainActivity.class);
                startActivity(i);
            case R.id.settings_person:
                i=new Intent(this,PersonSettings.class);
                startActivity(i);
        }
    }
}

