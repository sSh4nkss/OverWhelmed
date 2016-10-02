package com.over.whelmed;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class OverWhelmed implements Screen{
	private Viewport viewport;
	private Camera camera;
	private GameManager game;
	SpriteBatch batch;
	Texture img;
	int x;
	int y;
	int wallx;
	int timer;
	boolean directionforward;
	Sprite knight;
	Sprite background;
	
	public OverWhelmed(GameManager game) {
		this.game = game;
	}
	
	public float getScalingFactor(){
		float xscale = game.getWindowWidth()/640;
		return xscale;
		
	}
	
	@Override
	public void show () {
		camera = new OrthographicCamera();
	    viewport = new ExtendViewport(800, 600, camera);
		World world = new World(new Vector2(0, -10), true);
		batch = new SpriteBatch();
		final Texture texture = new Texture(Gdx.files.internal("C:\\Users\\Sh4nks\\workspace\\OverWhelmed\\core\\assets\\Knight.png"));
		knight = new Sprite(texture);
		background = new Sprite(new Texture(Gdx.files.internal("C:\\Users\\Sh4nks\\workspace\\OverWhelmed\\core\\assets\\Background.png")));
		final float scalingFactor = getScalingFactor();
		knight.scale(1);
		knight.scale(scalingFactor);
		background.scale((float) 0.3);
		background.scale(scalingFactor);
		x = 300;
		wallx = -600;
		y = 25;
		timer = 1;
		directionforward = true;
	}
	@Override
	public void render(float delta) {
		
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