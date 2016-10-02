package com.over.whelmed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.physics.box2d.Box2D;

public class MenuScreen implements Screen {
	private GameManager game;
	
	public MenuScreen(GameManager arggame){
		this.game = arggame;
	}
	
	@Override
	public void show() {
		final OverWhelmed whelmed = new OverWhelmed(game);
		game.setScreen(whelmed);

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

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
