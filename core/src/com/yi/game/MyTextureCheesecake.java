package com.yi.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;

/**
 */
public class MyTextureCheesecake {
    Texture textureCheesecake;
    long lastTimeCheesecake;
    float cheesecakeXposition;
    float cheesecakeYposition;
    int cheesecakeNum;
//    TextureRegion textureRegion;
    Sprite spriteCheesecake;

    long lastTimeColorChange;

    public MyTextureCheesecake(){
        textureCheesecake = new Texture(Gdx.files.internal("cheesecake1.png"));
        lastTimeCheesecake = TimeUtils.nanoTime();
        cheesecakeXposition = 0;
        cheesecakeYposition = 0;
        cheesecakeNum = 1;
//        textureRegion = new TextureRegion(textureCheesecake);
//        textureRegion.flip(false, true);
        spriteCheesecake = new Sprite(textureCheesecake);

        lastTimeColorChange = TimeUtils.nanoTime();
    }

    public void updateCheesecake(){
        if(TimeUtils.nanoTime() - lastTimeCheesecake > 20000000l){
            lastTimeCheesecake = TimeUtils.nanoTime();
            System.out.println("mytab cheesecakeNum: "+cheesecakeNum);
            if(cheesecakeXposition + textureCheesecake.getWidth() >= Gdx.graphics.getWidth() || cheesecakeYposition + textureCheesecake.getHeight() >= Gdx.graphics.getHeight()){
                cheesecakeXposition = 0;
                cheesecakeYposition = 0;

                if(cheesecakeNum < 3){
                    cheesecakeNum++;
                }
                else{
                    cheesecakeNum = 1;
                }
                textureCheesecake = new Texture(Gdx.files.internal("cheesecake" + cheesecakeNum + ".png"));
                spriteCheesecake.setTexture(textureCheesecake);

            }
            else{
                cheesecakeXposition += 200f * Gdx.graphics.getDeltaTime();
                cheesecakeYposition += 200f * Gdx.graphics.getDeltaTime();
            }
        }
    }

    /**
     * change sprite color to random color and transparency, it is like merged a color to the image
     * @param changeSpeed
     */
    public void changeRandomColorTransparency(long changeSpeed){
        if(TimeUtils.nanoTime() - lastTimeColorChange > changeSpeed) {
            lastTimeColorChange = TimeUtils.nanoTime();
            spriteCheesecake.setColor((float)Math.random(), (float)Math.random(), (float)Math.random(), (float)Math.random());
        }
    }
}
