package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * this is a background image class,
 * it contain data and method around background image,
 * in another word this background image class is independent.
 *
 * in this non-main class we need to have constructor to initialize variable.
 * make more method for outsider to access is nice.
 */
public class MyTextureBackground {
    Texture textureBackground;
    /**
     * store current timestamp use TimeUtils.nanoTime()
     */
    long lastTimeBg;
    /**
     * use to tell which background image
     */
    int bgNumber;

    /**
     * default constructor, initialize variable when this class object create
     */
    public MyTextureBackground(){
        textureBackground = new Texture(Gdx.files.internal("Starry_sky.png"));
        lastTimeBg = TimeUtils.nanoTime();
        bgNumber = 1;
    }

    /**
     * constructor, initialize variable when this class object create base on given parameter
     */
    public MyTextureBackground(String backgroundFileName){
        textureBackground = new Texture(Gdx.files.internal(backgroundFileName));
        lastTimeBg = TimeUtils.nanoTime();
        bgNumber = 1;
    }

    /**
     * every 4 seconds rotate 1 of the 6 background images from rainbg1.png to rainbg6.png,
     * use TimeUtils.nanoTime() to get current timestamp to keep track of the time
     */
    public void updateBackground(){
        if(TimeUtils.nanoTime() - lastTimeBg > 4000000000l){
            textureBackground = new Texture(Gdx.files.internal("rainbg" + bgNumber + ".png"));
            lastTimeBg = TimeUtils.nanoTime();
            if(bgNumber >= 6){
                bgNumber = 1;
            }
            else{
                bgNumber++;
            }
        }
    }
}
