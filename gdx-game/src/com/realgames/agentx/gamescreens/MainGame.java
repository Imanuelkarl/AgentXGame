package com.realgames.agentx.gamescreens;
import com.badlogic.gdx.*;
import com.realgames.agentx.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.*;
import java.util.*;
import com.realgames.agentx.gameobjects.*;
import com.realgames.agentx.gameobjects.gamecharacter.*;
import com.realgames.agentx.files.*;
import com.badlogic.gdx.assets.*;
import com.badlogic.gdx.audio.*;

public class MainGame implements Screen,InputProcessor
{
	public MainGame(){
		
	}
	public MainGame(MyGame game){
		this.game=game;
		scree=1;
		gameover=false;
	}
	MyGame game;
	SpriteBatch batch;
	OrthographicCamera camera;
	boolean isPlaying;
	boolean isPaused;
	Texture background;
	TextureRegion upfloor;
	TextureRegion midfloor;
	TextureRegion platform;
	TextDisplay writer;
	boolean gameover=false;
	Sprite upbutton;
	Sprite downbutton;
	Sprite health;
	Sprite coinbar;
	Sprite coin;
	Sprite til=new Sprite();
	Players player;
	int lid=0;
	int coinscore=0;
	int scree=1;
	float time=0;
	float gravity;
	boolean falling;  
	boolean run;
	boolean touching;
	Sprite intersect=new Sprite();
	int speed=500;
	int initial=speed;
	Music backgroundMusic;
	ArrayList<Environment> mySpace =new ArrayList<>();
	ArrayList<Sprite> life=new ArrayList<>();
	TextureRegion downfloor;
	
	@Override
	public boolean keyDown(int p1)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean keyUp(int p1)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean keyTyped(char p1)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean touchDown(int p1, int p2, int p3, int p4)
	{
		// TODO: Implement this method
		if(touching){
			gravity=1500;
		}
		touching=false;
		return true;
		
	}

	@Override
	public boolean touchUp(int p1, int p2, int p3, int p4)
	{
		
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean touchDragged(int p1, int p2, int p3)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean mouseMoved(int p1, int p2)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public boolean scrolled(int p1)
	{
		// TODO: Implement this method
		return false;
	}

	@Override
	public void render(float p1)
	{
		Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(background,0,0,camera.viewportWidth,camera.viewportHeight);
		gameAct(batch);
		upbutton.setBounds(camera.position.x-camera.viewportWidth/2+100,50,200,200);
		downbutton.setBounds(camera.position.x+camera.viewportWidth/2-300,50,200,200);
		
		coin.setBounds(camera.position.x+camera.viewportWidth/2-350,camera.position.y+camera.viewportHeight/2-120,100,100);
		coinbar.setBounds(camera.position.x+camera.viewportWidth/2-300,camera.position.y+camera.viewportHeight/2-90,280,50);

		
		
		player.setY(player.getY()+Gdx.graphics.getDeltaTime()*gravity);
		gameRules();
		coinbar.draw(batch);
		coin.draw(batch);
		writer.write(batch,""+coinscore,coinbar.getX()+coinbar.getWidth()/4,coinbar.getY());
		for(Sprite hp:life){
			hp.draw(batch);
		}
		
		downbutton.draw(batch);
		upbutton.draw(batch);
		batch.end();
		if(run){
			player.setX(player.getX()+Gdx.graphics.getDeltaTime()*speed);
			camera.translate(Gdx.graphics.getDeltaTime()*speed,0);
		}
	}

	@Override
	public void resize(int p1, int p2)
	{
		// TODO: Implement this method
	}

	@Override
	public void show()
	{
		batch=new SpriteBatch();
		camera=new OrthographicCamera();
		configureCamera();
		writer=new TextDisplay();
		gravity=00;
		run=true;
		AssetManager assetManager = new AssetManager();
		assetManager.load("background_music.mp3", Music.class);
		assetManager.finishLoading();
		backgroundMusic = assetManager.get("background_music.mp3", Music.class);
		background=game.textures.get(0);
		platform=new TextureRegion(game.textures.get(11),0,0,game.textures.get(11).getWidth(),game.textures.get(11).getHeight());
		upfloor=new TextureRegion(game.textures.get(1),game.textures.get(1).getWidth()/3,0,game.textures.get(1).getWidth()/3,game.textures.get(1).getHeight()/3);
		downfloor=new TextureRegion(game.textures.get(1),game.textures.get(1).getWidth()/3,game.textures.get(1).getHeight()/3,game.textures.get(1).getWidth()/3,game.textures.get(1).getHeight()/3);
		midfloor=new TextureRegion(game.textures.get(1),game.textures.get(1).getWidth()/3,2*game.textures.get(1).getHeight()/3,game.textures.get(1).getWidth()/3,game.textures.get(1).getHeight()/3);
		coin=new Sprite(game.textures.get(8));
		coinbar=new Sprite(game.textures.get(2));
		health=new Sprite(game.textures.get(9));
		player=new Players();
		Texture playText=game.textures.get(10);
		player.setTexture(playText);
		player.setRegion(0,0,playText.getWidth()/3,playText.getHeight()/3);
		player.setBounds(300,240,250,250);
		player.addAnimation(playText,3,2,6,0.067f);
		coin.setRegion(0,0,game.textures.get(8).getWidth(),game.textures.get(8).getHeight());
		coinbar.setRegion(0,0,game.textures.get(2).getWidth(),game.textures.get(2).getHeight());
		health.setRegion(0,0,game.textures.get(9).getWidth(),game.textures.get(9).getHeight());
		
		for(int i=0;i<3;i++){
			Sprite hp=new Sprite(game.textures.get(TextureIds.HEALTH1));
			hp.setRegion(0,0,game.textures.get(9).getWidth(),game.textures.get(9).getHeight());
			hp.setBounds(camera.position.x-camera.viewportWidth/2+20+i*100,camera.position.y+camera.viewportHeight/2-100,70,70);
			life.add(hp);
		}
		upbutton=new Sprite(game.textures.get(3));
		upbutton.setRegion(0,0,game.textures.get(3).getWidth(),game.textures.get(3).getHeight());
		downbutton=new Sprite(game.textures.get(4));
		upbutton.setRegion(0,0,game.textures.get(4).getWidth(),game.textures.get(4).getWidth());
		createEnvironment();
		writer.setFont(game.textures.get(TextureIds.FONTS1));
		writer.setFontSize(50);
		Gdx.input.setInputProcessor(this);
		backgroundMusic.setLooping(true);
		backgroundMusic.play();
		// TODO: Implement this method
	}

	@Override
	public void hide()
	{
		// TODO: Implement this method
	}

	@Override
	public void pause()
	{
		// TODO: Implement this method
	}

	@Override
	public void resume()
	{
		// TODO: Implement this method
	}

	@Override
	public void dispose()
	{
		batch.dispose();
		game.dispose();
		// TODO: Implement this method
	}
	private void configureCamera(){
		if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
			camera.setToOrtho(false, 2000, 2000 * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
		else
			camera.setToOrtho(false, 2000 * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), 2000);
	}
	public void gameAct(Batch batch){
		
		for(int i=0;i<3;i++){
			life.get(i).setBounds(camera.position.x-camera.viewportWidth/2+20+i*100,camera.position.y+camera.viewportHeight/2-100,70,70);
		}
		if(mySpace.size()<10){
			createEnvironment();
		}
		for(int i=0;i<mySpace.size();i++){
			mySpace.get(i).display(batch,camera,time);
			if(mySpace.get(i).listID*2000+4000<camera.position.x-camera.viewportWidth/2){
				mySpace.remove(i);
			}
		}
		
		player.playAnimation(time,batch);
		
		time+=Gdx.graphics.getDeltaTime();
	}
	private void createEnvironment(){
		Environment myEnviron =new Environment();
		myEnviron.setTexture(game.textures);
		myEnviron.listID=lid;
		int spas=1;
		if(mySpace.size()==0){
			spas=1;
		}
		else{
			spas=getRandom(1,3);
		}
		
		myEnviron.createSpace(spas);
		mySpace.add(myEnviron);
		lid++;
	}
	public void gameRules(){
		//motion animation
		
		//collision
		gravity-=50;
		for(Environment home : mySpace){
		
			for(Sprite tile: home.getTiles()){
				if(player.getFoot().overlaps(tile.getBoundingRectangle())){
					til=tile;
					gravity=0;
					falling=false;
					touching=true;
				}
				else {
					falling=true;
					
				}
				if(player.getFront().overlaps(tile.getBoundingRectangle())){
					run=false;
					intersect=tile;
					gameover=true;
					if(gameover){
						gameover();
					}
						
					
			
				}
				if(!player.getFront().overlaps(intersect.getBoundingRectangle())){
					run=true;
				}
				if(player.getY()<0){
					if (backgroundMusic.isPlaying()) {
						backgroundMusic.stop();
					}
					gameover();
				}
				
			}
			for(SpriteObjects coin: home.getCoins()){
				if(player.getBoundingRectangle().overlaps(coin.getBoundingRectangle())){
					if(coin.isActive()){
						coinscore++;
						coin.setActive(false);
					}
					
				}
			}
		}
		//button inputs
	}
	public void gameover(){
		backgroundMusic.dispose();
		backgroundMusic.stop();
		
		if(scree==1){
			game.setScreen(new MainGame(game));
			scree++;
		}
		
		
	}
	public int getRandom(int _min, int _max) {
		Random random = new Random();

		return random.nextInt(_max - _min + 1) + _min;

	}
	
}
