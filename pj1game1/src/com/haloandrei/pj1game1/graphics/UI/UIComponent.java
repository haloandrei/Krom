package com.haloandrei.pj1game1.graphics.UI;

import com.haloandrei.pj1game1.util.Vector2i;

public class UIComponent {
	
	private Vector2i position, offset;
	private String label;
	private int backgroundcolor;
	
	public UIComponent(Vector2i position){
		this.position = position;
		offset = new Vector2i();
	}
	
	public void update(){
		
	}
	public void render(){
		
	}
	void setOffset(Vector2i offset)	{
		this.offset = offset;
	}
	
}
