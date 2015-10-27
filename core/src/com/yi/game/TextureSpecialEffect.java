package com.yi.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * this main class use the 4 texture classes MyTextureBackground, MyTextureMoon, MyTextureCheesecake, and MyTextureSun.
 *
 * this class control the update and the render of images
 *
 * DeltaTime is time between last frame and current frame,
 * usage is to make movement looks the same on both slow and fast device,
 * because old device can be running 30 frame per second, new device running 80 frame per second.
 * use it to multiply your changing element, like speed.
 *
 */
public class TextureSpecialEffect extends ApplicationAdapter {
	SpriteBatch batch;
	MyTextureBackground myTextureBackground;
	MyTextureMoon myTextureMoon;
	MyTextureCheesecake myTextureCheesecake;
	MyTextureSun myTextureSun;

	long lastTimeColorChange;

	@Override
	public void create () {
		batch = new SpriteBatch();
		myTextureBackground = new MyTextureBackground();
		myTextureMoon = new MyTextureMoon();
		myTextureCheesecake = new MyTextureCheesecake();
		myTextureSun = new MyTextureSun();
//		myTextureBackground = new MyTextureBackground("rainbg1.png");
//		myTextureMoon = new MyTextureMoon("badlogic.jpg");
		lastTimeColorChange = TimeUtils.nanoTime();
	}

	/**
	 * free up memory resource that no long in use,
	 * dispose resource within this class,
	 * dispose resource use by but not within this class
	 */
	@Override
	public void dispose() {
		batch.dispose();
		myTextureBackground.textureBackground.dispose();
		myTextureMoon.textureMoon.dispose();
		myTextureCheesecake.textureCheesecake.dispose();
		myTextureSun.textureSun.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// merge a color to the drawing
		batch.begin();
		batch.draw(myTextureBackground.textureBackground, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(myTextureMoon.textureMoon, myTextureMoon.moonXposition, Gdx.graphics.getHeight() / 2 - myTextureMoon.textureMoon.getHeight() / 2);
//		batch.draw(myTextureCheesecake.textureCheesecake, myTextureCheesecake.cheesecakeXposition, myTextureCheesecake.cheesecakeYposition);
//		batch.draw(myTextureCheesecake.textureRegion, myTextureCheesecake.cheesecakeXposition, myTextureCheesecake.cheesecakeYposition);

		// change color every 2 seconds
		myTextureCheesecake.changeRandomColorTransparency(2000000000l);
		myTextureCheesecake.spriteCheesecake.setPosition(myTextureCheesecake.cheesecakeXposition, myTextureCheesecake.cheesecakeYposition);
		myTextureCheesecake.spriteCheesecake.rotate(1f);
		myTextureCheesecake.spriteCheesecake.draw(batch);
		if(myTextureMoon.isXAtBorder == true){
			batch.draw(myTextureSun.textureSun, Gdx.graphics.getWidth() - myTextureSun.textureSun.getWidth(), Gdx.graphics.getHeight() / 2 - myTextureMoon.textureMoon.getHeight() / 2);
		}
		batch.end();

		myTextureBackground.updateBackground();
		myTextureMoon.updateMoon();
		myTextureCheesecake.updateCheesecake();
	}
}
