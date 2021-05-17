package com.example.game;

public class Levels {
    public static int [][]levels={{13,1,1,13}};
    public static float [][]tasks1={{2,0,270,0},{8,1,270,0},{2,7,90,0},{4,11,270,0},{12,14,90,0}};
    public static int getPX(){
        return levels[0][0];
    }

    public static int getPY() {
        return levels[0][1];
    }

    public static float getXTasks1(int x) {
        return tasks1[x][0];
    }
    public static float getYTasks1(int x) {
        return tasks1[x][1];
    }
    public static boolean getComplete(int x){
        if (tasks1[x][3]==0) {
            return false;
        }else{
            return true;
        }
    }


}
