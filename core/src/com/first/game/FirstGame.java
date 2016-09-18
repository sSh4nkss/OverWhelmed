package com.first.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FirstGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	int x;
	int y;
	int timer;
	boolean directionforward;
	Sprite knight;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		final Texture texture = new Texture(Gdx.files.internal("Knight.png"));
		knight = new Sprite(texture);
		knight.scale(6);
		x = 0;
		y = 0;
		timer = 1;
		directionforward = true;
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(knight, x, y, knight.getScaleX()*knight.getWidth(), knight.getScaleY()*knight.getHeight() );
		batch.end();
		if (x >= 400){
			directionforward = false;
		}
		if (x <= 0){
			directionforward = true;
		}
		if (directionforward == false){
			x = x - 500/(timer); // x = x - f(t)
		}
		if (directionforward == true){
			x = x + 500/(timer);
			//System.out.println(x);
		}
		timer++;
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
