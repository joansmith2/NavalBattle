package com.jpii.navalbattle.game.gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;

import maximusvladimir.dagen.Rand;

import com.jpii.navalbattle.pavo.Game;
import com.jpii.navalbattle.pavo.grid.Entity;
import com.jpii.navalbattle.pavo.gui.WindowManager;
import com.jpii.navalbattle.pavo.gui.controls.PWindow;

public class HUD extends PWindow{
	
	Entity display;
	Rand ran;
	GradientPaint gp;
	
	
	public HUD(WindowManager parent,int x, int y, int width, int height){
		super(parent, x, y, width, height);
		setSize(Game.Settings.currentWidth, 200);
		setLoc(0,Game.Settings.currentHeight-this.height);
		display = null;
		ran = Game.Settings.rand;
		gp = new GradientPaint(0,0,new Color(96,116,190),0,height,new Color(0,0,54));
		setTitleVisiblity(false);
		setVisible(false);
	}
	
	public void paint(Graphics2D g) {
		super.paint(g);
		if(isVisible())
			g.setPaint(gp);
		if(!isVisible())
			g.setPaint(new GradientPaint(0,0,Color.black,0,height,Color.black));
		g.fillRect(0,0,getWidth(),getHeight());
	}
	
	public void setEntity(Entity e){
		display = e;
		update();
	}
	
	public void update(){
		if(display != null){
			setVisible(true);
		}
		else{
			setVisible(false);
		}
		repaint();
	}
	
}
