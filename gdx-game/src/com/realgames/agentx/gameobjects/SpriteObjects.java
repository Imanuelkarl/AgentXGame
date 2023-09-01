package com.realgames.agentx.gameobjects;
import com.badlogic.gdx.graphics.g2d.*;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.g3d.*;

public class SpriteObjects extends Sprite
{
	Model model;
	public SpriteObjects(Texture texture){
		super(texture);
		this.setTexture(texture);
	}
	public SpriteObjects(){
		
	}
	ArrayList<Animation> motions=new ArrayList<>();
	public void addAnimation(Texture walkSheet,int columns,int rows,int frames,float speed){
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / columns, walkSheet.getHeight() / rows);
        TextureRegion[] walkFrames = new TextureRegion[frames];
        int index = 0;
        for (int i = 0; i < rows; i++)
		{
            for (int j = 0; j < columns; j++)
			{
                walkFrames[index++] = tmp[i][j];
            }
        }
       Animation walkAnimation = new Animation(speed, walkFrames);
	   motions.add(walkAnimation);
	}
	public void addAnimation(Texture texture,int columns,int rows,float speed){
		addAnimation(texture,columns,rows,columns*rows,speed);
	}
	public void addAnimation(Texture texture,int columns,int rows,int frame){
		addAnimation(texture,columns,rows,frame,0.067f);
	}
	public void addAnimation(Texture texture,int columns,int rows){
		addAnimation(texture,columns,rows,columns*rows,0.067f);
	}
	public void playAnimation(int id,float time,Batch batch){
		if(motions.size()>0&&motions.size()>id){
			setRegion(motions.get(id).getKeyFrame(time,true));
			draw(batch);
		}
	}
	public void playAnimation(float time,Batch batch){
		
		playAnimation(0,time,batch);
		
	}
	
}
