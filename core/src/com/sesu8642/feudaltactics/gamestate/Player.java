package com.sesu8642.feudaltactics.gamestate;

import com.badlogic.gdx.graphics.Color;

/** A human or bot player participating in a game. **/
public class Player {

	private Color color;
	private Type type;
	private boolean defeated = false;

	/** Type of a player. **/
	public enum Type {
		LOCAL_PLAYER, LOCAL_BOT, REMOTE
	}

	public Player() {
	}

	public Player(Color color, Type type) {
		this.color = color;
		this.type = type;
	}

	/**
	 * Constructor.
	 * 
	 * @param color    color this player's tiles have
	 * @param defeated whether this player is defeated
	 * @param type     player type
	 */
	public Player(Color color, boolean defeated, Type type) {
		this.color = color;
		this.defeated = defeated;
		this.type = type;
	}

	public Color getColor() {
		return color;
	}

	public boolean isDefeated() {
		return defeated;
	}

	public void setDefeated(boolean defeated) {
		this.defeated = defeated;
	}

	public Type getType() {
		return type;
	}

	/**
	 * Returns a deep copy of the original. Exception: color field is the same
	 * instance as the original one
	 * 
	 * @return copy
	 */
	public static Player copyOf(Player original) {
		return new Player(original.getColor(), original.isDefeated(), original.getType());
	}

}
