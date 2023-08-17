package com.realgames.agentx.gamescreens;
import com.badlogic.gdx.graphics.g2d.*;
import com.realgames.agentx.gameobjects.gamecharacter.*;
import java.util.*;
import com.realgames.agentx.gameobjects.*;
import com.badlogic.gdx.graphics.*;
import com.realgames.agentx.files.*;

public class Environment
{
	ArrayList <Texture> texture = new ArrayList<>();
	ArrayList<Enemy> enemies=new ArrayList<>();
	ArrayList <SpriteObjects> coins=new ArrayList<>();
	ArrayList <Sprite> tiles=new ArrayList<>();
	
	ArrayList <Sprite> background=new ArrayList<>();
	ArrayList <SpriteObjects> obstacles=new ArrayList<>();
	TextureIds myIds;
	int id;
	int listID;
	int size=20;
	
	
	public void createTiles(int x,int y,int m,int n)
	{
		
		Sprite tile=new Sprite(texture.get(myIds.GRASSTILE1));
		tile.setRegion(m*tile.getTexture().getWidth()/3,n*tile.getTexture().getHeight()/3,tile.getTexture().getWidth()/3,tile.getTexture().getHeight()/3);
		tile.setBounds(x,y,100,120);
		this.tiles.add(tile);
	}

	public ArrayList<Sprite> getTiles()
	{
		return tiles;
	}

	public void createBackground(ArrayList<Sprite> background)
	{
		this.background = background;
	}

	public ArrayList<Sprite> getBackground()
	{
		return background;
	}

	public void createObstacles(ArrayList<SpriteObjects> obstacles)
	{
		this.obstacles = obstacles;
	}

	public ArrayList<SpriteObjects> getObstacles()
	{
		return obstacles;
	}

	public void setTexture(ArrayList<Texture> texture)
	{
		this.texture = texture;
	}
	public ArrayList<Enemy> getEnemies()
	{
		return enemies;
	}

	public void createCoins(ArrayList<SpriteObjects> coins)
	{
		this.coins = coins;
	}

	public ArrayList<SpriteObjects> getCoins()
	{
		return coins;
	}
	public void createPlatform(int x,int y){
		Sprite tile3=new Sprite(texture.get(11));
		tile3.setRegion(0,0,tile3.getTexture().getWidth(),tile3.getTexture().getHeight());
		tile3.setBounds(x,y,500,150);
		this.tiles.add(tile3);
	}
	public void display(Batch batch,Camera camera){
		batch.draw(texture.get(myIds.BACKGROUNG1),(listID*camera.viewportWidth),0,camera.viewportWidth,camera.viewportHeight);
		if(id!=2){
		batch.draw(texture.get(myIds.TREE1),listID*camera.viewportWidth+300,220,600,600);
		batch.draw(texture.get(myIds.TREE1),listID*camera.viewportWidth+camera.viewportWidth-700,220,600,600);
		}
		for(Sprite tile:tiles){
			tile.draw(batch);
		}
	}
	public void createSpace(int id){
		this.id=id;
		switch(id){
			case 1:
				
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){
						createTiles((listID*2000)+i*100,120,1,0);
						createTiles((listID*2000)+i*100,0,1,2);
					}
				}
				break;
			case 2:
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){
						if(i==3||i==12){
							createPlatform(listID*2000+i*100,400);
							
						}
					}
				}
				break;
			case 3:
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){
						
					}
				}
				break;
			case 4:
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){

					}
				}
				break;
			case 5:
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){

					}
				}
				break;
			case 6:
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){

					}
				}
				break;
			case 7:
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){

					}
				}
				break;
			case 8:
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){

					}
				}
				break;
				
			case 9:
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){

					}
				}
				break;
			case 10:
				for(int i=0;i<size;i++){
					for(int j=0;j<10;j++){

					}
				}
				break;
			case 11:
				for(int i=0;i<16;i++){
					for(int j=0;j<10;j++){

					}
				}
				break;
		}
	}
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		
		return random.nextInt(_max - _min + 1) + _min;
		
	}
}
