package com.realgames.agentx.gameobjects;
import com.badlogic.gdx.graphics.*;
import java.util.*;
import com.badlogic.gdx.graphics.g2d.*;

public class TextDisplay
{
	public TextDisplay(){
		fontSize=30;
		fontId=0;
		
	}
	public TextDisplay(ArrayList<Texture> textures){
		fonts=textures;
		fontId=0;
		fontSize=30;
		if(textures.size()!=0){
			font=textures.get(fontId);
		}
		
	}
	ArrayList<Texture> fonts=new ArrayList<>();
	Texture font;
	int fontSize;
	int fontId;
	
	public void setFont(Texture texture){
		font=texture;
	}
	public void setFont(int font){
		fontId=font;
	}
	public void setFontSize(int size){
		fontSize=size;
	}
	public void write(Batch batch,String text,float x,float y){
		char[] letters=text.toCharArray();
		for(int i=0;i<letters.length;i++){
			if(i!=0){
				batch.draw(charToSprite(letters[i]),x+i*fontSize,y,fontSize,fontSize);
			}
			else{
			batch.draw(charToSprite(letters[i]),x+i*fontSize-0,y,fontSize,fontSize);
			}
		}
	}
	private TextureRegion charToSprite(char letter){
		TextureRegion character = new TextureRegion();
		character.setTexture(font);
		switch(letter){
			case '1':
				character.setRegion(0*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
			case '2':
				character.setRegion(1*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
			case '3':
				character.setRegion(2*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
			case '4':
				character.setRegion(3*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
			case '5':
				character.setRegion(4*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
			case '6':
				character.setRegion(5*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
			case '7':
				character.setRegion(6*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
			case '8':
				character.setRegion(7*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
			case '9':
				character.setRegion(8*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
			case '0':
				character.setRegion(9*font.getWidth()/10,0,font.getWidth()/10,font.getHeight());
				break;
		}
		return character;
	}
}
