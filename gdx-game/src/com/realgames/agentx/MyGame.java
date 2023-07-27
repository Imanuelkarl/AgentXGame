package com.realgames.agentx;
import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.*;
import com.realgames.agentx.gamescreens.*;

public class MyGame extends Game
{
	AssetManager myAsset;
	@Override
	public void create()
	{
		this.setScreen(new MainGame(this));
		// TODO: Implement this method
	}
	public void loadAssets(){
		
	}

}
