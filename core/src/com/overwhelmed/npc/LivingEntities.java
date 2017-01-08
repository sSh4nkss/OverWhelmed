package com.overwhelmed.npc;

import com.badlogic.gdx.graphics.Texture;

public abstract class LivingEntities {
	private int health;
	//relative to the background, not the screen
	private int x;
	private int y;
	Texture texture;
	
	public LivingEntities(Texture texture) {
		this.texture = texture; //connects instance variables to parameters
	}
	
	private int getModifiedX(int movement){
		int modifiedx = movement + this.x;
		return modifiedx;
		
	}
	
}
