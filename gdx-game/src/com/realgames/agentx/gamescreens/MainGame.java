package com.realgames.agentx.gamescreens;
import com.badlogic.gdx.*;
import com.realgames.agentx.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.graphics.*;

public class MainGame implements Screen,InputProcessor
{
	public MainGame(){
		
	}
	public MainGame(MyGame game){
		this.game=game;
	}
	MyGame game;
	SpriteBatch batch;
	OrthographicCamera camera;
	boolean isPlaying;
	boolean isPaused;
	Texture background;
	TextureRegion upfloor;
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
		return false;
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
		batch.end();
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
		background=game.textures.get(0);
		upfloor=new TextureRegion(game.textures.get(1),game.textures.get(1).getWidth()/3,0,game.textures.get(1).getWidth()/3,game.textures.get(1).getHeight()/3);
		downfloor=new TextureRegion(game.textures.get(1),game.textures.get(1).getWidth()/3,game.textures.get(1).getHeight()/3,game.textures.get(1).getWidth()/3,game.textures.get(1).getHeight()/3);
		Gdx.input.setInputProcessor(this);
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
		// TODO: Implement this method
	}
	private void configureCamera(){
		if (Gdx.graphics.getHeight() < Gdx.graphics.getWidth())
			camera.setToOrtho(false, 1600, 1600 * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
		else
			camera.setToOrtho(false, 1600 * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), 1600);
	}
	void gameAct(Batch batch){
		for(int i=0;i<30;i++){
			batch.draw(upfloor,i*100,100,100,100);
			batch.draw(downfloor,i*100,0,100,100);
		}
	}
	void gameRules(){
		//motion animation
		
		//collision
		
		//button inputs
	}
	
}
