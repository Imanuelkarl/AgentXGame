package com.realgames.agentx.gameobjects.gamecharacter;
import com.realgames.agentx.gameobjects.*;
import com.badlogic.gdx.math.*;

public class Character extends SpriteObjects
{
	public Rectangle getFoot(){
		Rectangle foot =new Rectangle();
		foot.setSize(this.getWidth()/2+this.getWidth()/4,this.getHeight()/32);
		foot.setPosition(getX(),getY());
		return foot;
	}
	public Rectangle getFront(){
		Rectangle front =new Rectangle();
		front.setSize(this.getWidth()/4,this.getHeight()-this.getHeight()/16);
		front.setPosition(getX()+getWidth()/2+getWidth()/4,getY()+this.getHeight()/2);
		return front;
	}
}
