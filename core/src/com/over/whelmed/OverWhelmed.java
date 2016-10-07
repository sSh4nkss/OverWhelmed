package com.over.whelmed;


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
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class OverWhelmed implements Screen{
	private Viewport viewport;
	private Camera camera;
	private GameManager game;
	SpriteBatch batch;
	Texture img;
	int mistspeed;
	int x;
	int y;
	int movement;
	int wallx;
	int timer;
	boolean directionforward;
	Sprite background;
	Sprite wall;
	Sprite nightsky;
	SpriteBatch spriteBatch;
	float stateTime;
	Sprite currentFrame;
	Sprite moon;
	Sprite mist;
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
		Music music = Gdx.audio.newMusic(Gdx.files.internal("C:\\Users\\Sh4nks\\workspace\\OverWhelmed\\core\\assets\\NightTime.mp3"));

		final float scalingFactor = getScalingFactor();
		Texture knightsheet = new Texture(Gdx.files.internal("C:\\Users\\Sh4nks\\workspace\\OverWhelmed\\core\\assets\\Knight.png"));
		
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
		nightsky = new Sprite(new Texture(Gdx.files.internal("C:\\Users\\Sh4nks\\workspace\\OverWhelmed\\core\\assets\\Night Sky.png")));
		background = new Sprite(new Texture(Gdx.files.internal("C:\\Users\\Sh4nks\\workspace\\OverWhelmed\\core\\assets\\Background.png")));
		wall = new Sprite(new Texture(Gdx.files.internal("C:\\Users\\Sh4nks\\workspace\\OverWhelmed\\core\\assets\\Wall.png")));
		mist = new Sprite(new Texture(Gdx.files.internal("C:\\Users\\Sh4nks\\workspace\\OverWhelmed\\core\\assets\\Mist.png")));
		moon = new Sprite(new Texture(Gdx.files.internal("C:\\Users\\Sh4nks\\workspace\\OverWhelmed\\core\\assets\\Moon.png")));
		wall.scale(1);
		mist.scale(1);
		mist.scale(scalingFactor);
		nightsky.scale(scalingFactor);
		wall.scale(scalingFactor);
		background.scale((float) 0.3);
		background.scale(scalingFactor);
		mistspeed = 10;
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
		batch.draw(nightsky, movement, 0, nightsky.getScaleX()*nightsky.getWidth(), nightsky.getScaleY()*nightsky.getHeight());
		batch.draw(wall, movement-150, 0, wall.getScaleX()*wall.getWidth(), wall.getScaleY()*wall.getHeight());
		batch.draw(currentFrame, x, 46, currentFrame.getScaleX()*currentFrame.getWidth(), currentFrame.getScaleY()*currentFrame.getHeight());
		batch.draw(background, movement, 0, background.getScaleX()*background.getWidth(), background.getScaleY()*background.getHeight());
		batch.draw(mist, mistspeed + movement, 0, mist.getScaleX()*mist.getWidth(), mist.getScaleY()*mist.getHeight());
		batch.draw(moon, movement, 0, moon.getScaleX()*moon.getWidth(), moon.getScaleY()*moon.getHeight());
		batch.end();
		mistspeed++;
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