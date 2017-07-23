package com.haloandrei.pj1game1.graphics.UI;

import java.util.ArrayList;
import java.util.List;

import com.haloandrei.pj1game1.graphics.Screen;
import com.haloandrei.pj1game1.util.Vector2i;

public class UIPanel {
	private List<UIComponent> components = new ArrayList<UIComponent>();
	private Vector2i position;
	
	public UIPanel(Vector2i position){
		this.position = position;
	}
	public void addComponent(UIComponent component){
		components.add(component);
	}
	public void update(){
		for(UIComponent component : components) {
			component.setOffset(position);
			component.update();

		}
			}
	public void render(Screen screen) {
		
	}
}
