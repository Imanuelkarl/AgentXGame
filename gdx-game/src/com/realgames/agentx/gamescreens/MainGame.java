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
			camera.setToOrtho(false, 800, 800 * Gdx.graphics.getHeight() / Gdx.graphics.getWidth());
		else
			camera.setToOrtho(false, 800 * Gdx.graphics.getWidth() / Gdx.graphics.getHeight(), 800);
	}
	void gameAct(){
		
	}
	void gameRules(){
		//motion animation
		
		//collision
		
		//button inputs
	}
	
}
