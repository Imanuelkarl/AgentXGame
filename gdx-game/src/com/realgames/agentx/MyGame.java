package com.realgames.agentx;
import com.badlogic.gdx.*;
import com.realgames.agentx.gamescreens.*;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.realgames.agentx.files.*;

public class MyGame extends Game
{
	AssetsManager myAsset=new AssetsManager();
	int screens =0;
	public ArrayList<Texture> textures=new ArrayList<Texture>();
	@Override
	public void create()
	{
		
		loadAssets();
		if(screens==0){
			this.setScreen(new MainGame(this));
			screens=1;
		}
		
	
		// TODO: Implement this method
	}
	public void loadAssets(){
		textures=myAsset.loadAssets();
	}
	public int getScreens(){
		return screens;
		
	}
	public void setScren(int ju){
		screens=ju;
	}

}
