package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

/**
 */
public class MyTextureMoon {
    Texture textureMoon;
    /**
     * store current timestamp use TimeUtils.nanoTime()
     */
    long lastTimeMoon;
    /**
     * moon image x position
     */
    float moonXposition;

    boolean isXAtBorder;
    long lastTimeXAtBorder;

    /**
     * default constructor, initialize variable when this class object create
     */
    public MyTextureMoon(){
        textureMoon = new Texture(Gdx.files.internal("moon2.png"));
        lastTimeMoon = TimeUtils.nanoTime();
        moonXposition = Gdx.graphics.getWidth() / 2 - textureMoon.getWidth() / 2;
        isXAtBorder = false;
        lastTimeXAtBorder = 0;
    }

    /**
     * constructor, initialize variable when this class object create base on given parameter
     */
    public MyTextureMoon(String moonImageFileName){
        textureMoon = new Texture(Gdx.files.internal(moonImageFileName));
        lastTimeMoon = TimeUtils.nanoTime();
        moonXposition = Gdx.graphics.getWidth() / 2 - textureMoon.getWidth() / 2;
        isXAtBorder = false;
        lastTimeXAtBorder = 0;
    }

    /**
     * every 0.02 second change image location
     * 20000000 nanosecond is 0.02 second
     * 30 frame per second is 0.0333
     * 60 frame per second is 0.0167
     * 80 frame per second is 0.0125
     *
     * note is set the time interval smaller than 0.0125 then it will be at 0.0125 for fast phone
     */
    public void updateMoon(){
        if(TimeUtils.nanoTime() - lastTimeMoon > 20000000l){
            lastTimeMoon = TimeUtils.nanoTime();
            if(moonXposition + textureMoon.getWidth() >= Gdx.graphics.getWidth()){
                moonXposition = 0;
                isXAtBorder = true;
                lastTimeXAtBorder = TimeUtils.nanoTime();
            }
            else{
                moonXposition += 400f * Gdx.graphics.getDeltaTime();
                if(TimeUtils.nanoTime() - lastTimeXAtBorder > 500000000){
                    isXAtBorder = false;
                }
            }
        }
    }
}
