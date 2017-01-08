package com.first.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.overwhelmed.GameManager;
import com.overwhelmed.OverWhelmed;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "OverWhelmed";
		config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width;
		config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		config.fullscreen = true;
		
		//config.width = 640;
		//config.height = 480;
		//config.fullscreen = false;
		 
		 
		new LwjglApplication(new GameManager(config.width, config.height), config);
	}
}
