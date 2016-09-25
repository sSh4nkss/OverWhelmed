package com.over.whelmed;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OverWhelmed extends ApplicationAdapter 

{
	SpriteBatch batch;
	Texture img;
	int x;
	int y;
	int wallx;
	int timer;
	boolean directionforward;
	Sprite knight;
	Sprite background;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		final Texture texture = new Texture(Gdx.files.internal("Knight.png"));
		knight = new Sprite(texture);
		background = new Sprite(new Texture(Gdx.files.internal("Background.png")));
		knight.scale(1);
		background.scale((float) 0.3);
		x = 300;
		wallx = -600;
		y = 25;
		timer = 1;
		directionforward = true;
	}
	@Override
	public void render () {
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		batch.draw(background, wallx, 0, background.getScaleX()*background.getWidth(), background.getScaleY()*background.getHeight());
		batch.draw(knight, x, y, knight.getScaleX()*knight.getWidth(), knight.getScaleY()*knight.getHeight());
		batch.end();
		if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) 
		      wallx -= 5;
		if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) 
		      wallx -= -5;
		/** if (x >= 400){
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
		*/
	}
	@Override
	public void dispose() {
		batch.dispose();
	}
	
}