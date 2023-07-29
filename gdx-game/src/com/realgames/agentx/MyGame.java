package com.realgames.agentx;
import com.badlogic.gdx.*;
import com.realgames.agentx.gamescreens.*;
import java.util.*;
import com.badlogic.gdx.graphics.*;
import com.realgames.agentx.files.*;

public class MyGame extends Game
{
	AssetsManager myAsset=new AssetsManager();
	public ArrayList<Texture> textures=new ArrayList<Texture>();
	@Override
	public void create()
	{
		loadAssets();
		this.setScreen(new MainGame(this));
	
		// TODO: Implement this method
	}
	public void loadAssets(){
		textures=myAsset.loadAssets();
	}

}
