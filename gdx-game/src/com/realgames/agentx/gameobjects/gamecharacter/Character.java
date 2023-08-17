package com.realgames.agentx.gameobjects.gamecharacter;
import com.realgames.agentx.gameobjects.*;
import com.badlogic.gdx.math.*;

public class Character extends SpriteObjects
{
	public Rectangle getFoot(){
		Rectangle foot =new Rectangle();
		foot.setSize(this.getWidth(),this.getHeight()/8);
		foot.setPosition(getX(),getY());
		return foot;
	}
}
