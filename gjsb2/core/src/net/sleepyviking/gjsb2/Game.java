package net.sleepyviking.gjsb2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {

	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}