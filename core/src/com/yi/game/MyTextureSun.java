package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 */
public class MyTextureSun {
    Texture textureSun;

    public MyTextureSun(){
        textureSun = new Texture(Gdx.files.internal("sun.png"));
    }
}
