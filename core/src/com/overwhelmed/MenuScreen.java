package com.overwhelmed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class MenuScreen implements Screen {
	private GameManager game;
	private Stage stage;
	Image backgroundmenu = new Image(new Texture(Gdx.files.internal("..\\core\\assets\\backgroundmenu.jpg")));
	Texture playTexture = new Texture("..\\core\\assets\\PlayButton.png");
	Drawable drawable = new TextureRegionDrawable(new TextureRegion(playTexture));
	ImageButton playButton = new ImageButton(drawable);
	
	public MenuScreen(GameManager arggame){
		this.game = arggame;
	}
	
	
	@Override
	public void show() {
		stage = new Stage();
		playButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				final OverWhelmed whelmed = new OverWhelmed(game);
				game.setScreen(whelmed);
				super.clicked(event, x, y);}});
		stage.addActor(backgroundmenu);
		stage.addActor(playButton);
		playButton.setPosition(750, 500);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {

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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
