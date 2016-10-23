package com.over.whelmed;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class OverWhelmed implements Screen{
	private Viewport viewport;
	private Camera camera;
	private GameManager game;
	SpriteBatch batch;
	Texture img;
	float xmoonposition;
	float ymoonposition;
	int x;
	int y;
	int movement;
	int wallx;
	int timer;
	boolean directionforward;
	Sprite BackgroundRocks;
	Sprite background;
	Sprite wall;
	Sprite nightsky;
	SpriteBatch spriteBatch;
	float stateTime;
	Sprite currentFrame;
	Sprite moon;
	List<Sprite> mistlist;
	Sprite[] knightwalk;
	Animation Knightanimation;
	public OverWhelmed(GameManager game) {
		this.game = game;
	}
	
	public float getScalingFactor(){
		float xscale = game.getWindowWidth()/640;
		return xscale;
		
	}
	
	@Override
	public void show () {		
		Music music = Gdx.audio.newMusic(Gdx.files.internal("..\\core\\assets\\NightTime.mp3"));

		final float scalingFactor = getScalingFactor();
		Texture knightsheet = new Texture(Gdx.files.internal("..\\core\\assets\\Knight.png"));
		
		mistlist = new ArrayList<Sprite>();
		
		knightwalk = new Sprite[4];
		knightwalk[0] = new Sprite(knightsheet,0,0,39,35);
		knightwalk[1] = new Sprite(knightsheet,39,0,39,35);
		knightwalk[2] = new Sprite(knightsheet,78,0,39,35);
		knightwalk[3] = new Sprite(knightsheet,117,0,39,35);
		knightwalk[0].scale(1);
		knightwalk[1].scale(1);
		knightwalk[2].scale(1);
		knightwalk[3].scale(1);
		knightwalk[0].scale(scalingFactor);
		knightwalk[1].scale(scalingFactor);
		knightwalk[2].scale(scalingFactor);
		knightwalk[3].scale(scalingFactor);
		
		Knightanimation = new Animation(0.5f, knightwalk);
        spriteBatch = new SpriteBatch();               
        stateTime = 0f;                                 
		camera = new OrthographicCamera();
	    viewport = new ExtendViewport(800, 600, camera);
		batch = new SpriteBatch();
		BackgroundRocks = new Sprite(new Texture(Gdx.files.internal("..\\core\\assets\\Background Rocks.png")));
		nightsky = new Sprite(new Texture(Gdx.files.internal("..\\core\\assets\\Night Sky.png")));
		background = new Sprite(new Texture(Gdx.files.internal("..\\core\\assets\\Background.png")));
		wall = new Sprite(new Texture(Gdx.files.internal("..\\core\\assets\\Wall.png")));
		Sprite mist = new Sprite(new Texture(Gdx.files.internal("..\\core\\assets\\Mist.png")));
		mistlist.add(mist);
		mist.scale(1);
		mist.scale(scalingFactor);
		moon = new Sprite(new Texture(Gdx.files.internal("..\\core\\assets\\Moon.png")));
		BackgroundRocks.scale(1);
		BackgroundRocks.scale(scalingFactor);
		wall.scale(1);
		moon.scale(1);
		moon.scale(scalingFactor);
		nightsky.scale(scalingFactor);
		wall.scale(scalingFactor);
		background.scale((float) 0.3);
		background.scale(scalingFactor);
		xmoonposition = 0.1f;
		ymoonposition = 0.1f;
		x = 1000;
		wallx = -1000;
		movement = -600;
		y = 25;
		timer = 1;
		directionforward = true;
		music.play();
		music.setLooping(true);
		music.setVolume(0.5f); 

	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT); 
		batch.enableBlending();
		stateTime += Gdx.graphics.getDeltaTime();
		currentFrame = (Sprite)Knightanimation.getKeyFrame(stateTime, true);
		batch.begin();
		batch.draw(nightsky, movement/2, 0, nightsky.getScaleX()*nightsky.getWidth(), nightsky.getScaleY()*nightsky.getHeight());
		batch.draw(BackgroundRocks, movement, 0, BackgroundRocks.getScaleX()*BackgroundRocks.getWidth(), BackgroundRocks.getScaleY()*BackgroundRocks.getHeight());
		batch.draw(wall, movement-150, 0, wall.getScaleX()*wall.getWidth(), wall.getScaleY()*wall.getHeight());
		batch.draw(currentFrame, x, 46, currentFrame.getScaleX()*currentFrame.getWidth(), currentFrame.getScaleY()*currentFrame.getHeight());
		batch.draw(moon, xmoonposition + movement, 0 + ymoonposition, moon.getScaleX()*moon.getWidth(), moon.getScaleY()*moon.getHeight());
		batch.draw(background, movement, 0, background.getScaleX()*background.getWidth(), background.getScaleY()*background.getHeight());
		for(Sprite mist : mistlist){
			batch.draw(mist, mist.getX() + movement, 0, mist.getScaleX()*mist.getWidth(), mist.getScaleY()*mist.getHeight());
			mist.setX(mist.getX()+1);
		}
		Sprite firstmist = mistlist.get(0);
		if(firstmist.getX() >= 0){
			Sprite mist = new Sprite(new Texture(Gdx.files.internal("..\\core\\assets\\Mist.png")));
			mistlist.add(0, mist);
			mist.scale(1);
			mist.scale(getScalingFactor());
			mist.setX(0-mist.getWidth()*mist.getScaleX());
		}
		
		Sprite lastmist = mistlist.get(mistlist.size()-1);
		if(lastmist.getX() >= lastmist.getWidth()*lastmist.getScaleX()+1000){
			mistlist.remove(lastmist);
			xmoonposition = 950;
			ymoonposition = 100;
		}
		batch.end();
		
		if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) 
		      movement -= 5;
		if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) 
		      movement -= -5;
		if (movement < -2100){
			movement = -2100;
			x -= -5;
		}
		if (x>1000){
			movement = -2100;
		}
		if (Gdx.input.isKeyPressed(Keys.DPAD_LEFT)&&(x>1000)){
			x-= 5;
		}
		if (xmoonposition<1000){
			xmoonposition += 1.1;
		}
		if (ymoonposition < 400){
			//https://www.desmos.com/calculator/00kjado6gm
			ymoonposition = (float) (-0.05*(0.1*Math.pow(xmoonposition-180, 2.0))+160);
		}
		if (x>1750){
			x=1750;
		}
		if (movement >0){
			movement = 0;
			x -= 5;
		}
		if (x< 0){
			movement = 0;
			x=0;
		}
		if (Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)&&(x<1000)){
			x-= -5;
			movement = 0;
		}
		/** if (x >= 400){
			directionforward = false;
		}
		if (x <= 0){   
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
	
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);	
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	
}