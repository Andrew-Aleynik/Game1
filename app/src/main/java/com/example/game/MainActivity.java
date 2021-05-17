package com.example.game;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {
    private GameView game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game=new GameView(this);
        setContentView(R.layout.activity_game);
        setContentView(game);
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
        game.pause();
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

    /*public void onClickPersonSettings(View view) {
        Intent intent = new Intent(MainActivity.this, PersonSettings.class);
        startActivity(intent);
    }
    public void onClickStartGame(View view) {
        Intent intent = new Intent(MainActivity.this, Levels.class);
        startActivity(intent);
    }*/

}