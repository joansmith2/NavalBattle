/*
 * Copyright (C) 2012 JPII and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.jpii.navalbattle.game.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.jpii.navalbattle.game.*;

public class Entity implements Runnable {
	
	private Location location;
	private Image image;
	private boolean active;
	private String tag;
	private EntityReference ref;
	private BufferedImage detailedImage;
	
	/**
	 * Default constructor. Sets instance to inactive.
	 */
	public Entity() {
		setActive(false);
	}
	
	/**
	 * Construct an <code>Entity</code>
	 * @param location
	 * @param image
	 * @param tag
	 */
	public Entity(Location location, Image image, String tag) {
		setLocation(location);
		setImage(image);
		setTag(tag);
		setActive(true);
		setReference(new EntityReference(-1,-1));
	}
	
	public void setReference(EntityReference r) {
		ref = r;
	}
	public EntityReference getReference() {
		return ref;
	}
	
	public void invokeUpdate() {
		run();
		/*if (latestThread == null || !latestThread.isAlive() || latestThread.getState() == State.TERMINATED) {
			latestThread = new Thread(this);
			latestThread.run();
		}
		else
			update();*/
	}
	
	public void update() {
		
	}
	
	/**
	 * Gets the tag for the entity.
	 * @return
	 */
	public String getTag() {
		return tag;
	}
	
	/**
	 * Ticks the entity (updates info).
	 */
	public void tick() {
		
	}
	
	/**
	 * Sets the tag for the Entity.
	 * @param tag
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	/**
	 * Called when moving
	 * @param location
	 */
	public void onMove(Location location) {
		
	}
	
	/**
	 * Called when attacked
	 * @param attacker
	 */
	public void onAttacked(Entity attacker) {
		
	}
	
	/**
	 * Called when attacking
	 * @param target
	 */
	public void onAttack(Entity target) {
		
	}
	
	/**
	 * Set current <code>Location</code>
	 * @param location
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * Get current <code>Location</code>.
	 * @return
	 */
	public Location getLocation() {
		return location;
	}
	
	/**
	 * Set current <code>Image</code>
	 * @param image
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	public void setDetailedImage(BufferedImage img) {
		this.detailedImage = img;
	}
	
	/**
	 * Get current <code>Image</code>
	 * @return
	 */
	public Image getImage() {
		return image;
	}
	
	public BufferedImage getDetailedImage() {
		return detailedImage;
	}
	
	/**
	 * Set active
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Get if active
	 * @return
	 */
	public boolean isActive() {
		return active;
	}
	
	public void updateImage() {
		
	}
	
	public void onMouseHover(int localMX, int localMY) {
		if (!getTag().equals("red")) {
			setImage(new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB));
			Graphics g = getImage().getGraphics();
			g.setColor(new Color(127,0,0,80));
			g.fillRect(0,0,50,50);
			g.setColor(Color.black);
			g.drawRect(0,0,50,50);
			setTag("red");
		}
		else {
			setImage(new BufferedImage(50,50,BufferedImage.TYPE_INT_ARGB));
			Graphics g = getImage().getGraphics();
			g.setColor(Color.black);
			g.drawRect(0,0,50,50);
			setTag("grid");
		}
	}
	
	public void onMouseDown(int localMX, int localMY) {
		// TODO needs to be implemented in Game.java
	}

	@Override
	public void run() {
		update();		
	}
}