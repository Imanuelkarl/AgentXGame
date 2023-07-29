package com.realgames.agentx.files;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import java.util.*;

public class AssetsManager
{
	ArrayList<Texture> myTextures=new ArrayList<Texture>();
	public ArrayList<Texture> loadAssets(){
		myTextures.add(new Texture(Gdx.files.internal("background/background1.png")));
		myTextures.add(new Texture(Gdx.files.internal("background/floor1.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/coin_board.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/up_btn.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/down_btn.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/right_btn.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/left_btn.png")));
		
		return myTextures;
	}
}
