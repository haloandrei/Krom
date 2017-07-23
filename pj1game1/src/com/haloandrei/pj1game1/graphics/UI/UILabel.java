package com.haloandrei.pj1game1.graphics.UI;

import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.util.Vector2i;

public class UILabel extends UIComponent{

	public String text;
	public Font font;
	
	public UILabel(Vector2i position, String text) {
		super(position);
		font = new Font();
		this.text = text;
	}
	public void render (Screen screen ) 
	{
		font.render(position.x + offset.x,position.y + offset.y,-4,0, text, screen);
	}
}
