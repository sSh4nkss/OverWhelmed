package com.overwhelmed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.physics.box2d.Box2D;

public class GameManager extends Game {

	private float windowWidth;
	private float windowHeight;
	
	public GameManager(float windowWidth, float windowHeight) {
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}
	
	public float getWindowWidth() {
		return this.windowWidth;
	}

	public float getWindowHeight() {
		return this.windowHeight;
	}

	@Override
	public void create() {
		Box2D.init();
		final MenuScreen menuScreen = new MenuScreen(this);
		this.setScreen(menuScreen);
	}

}
