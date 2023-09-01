package com.realgames.agentx.files;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import java.util.*;

public class AssetsManager
{
	ArrayList<Texture> myTextures=new ArrayList<Texture>();
	public ArrayList<Texture> loadAssets(){
		myTextures.add(new Texture(Gdx.files.internal("background/background6.png")));
		myTextures.add(new Texture(Gdx.files.internal("background/floor6.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/coin_board.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/up_btn.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/down_btn.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/right_btn.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/left_btn.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/add.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/coin.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/health.png")));
		myTextures.add(new Texture(Gdx.files.internal("characters/player1.png")));
		myTextures.add(new Texture(Gdx.files.internal("background/ptiles1.png")));
		myTextures.add(new Texture(Gdx.files.internal("background/tree1.png")));
		myTextures.add(new Texture(Gdx.files.internal("buttons/coin_spin.png")));
		return myTextures;
	}
}
