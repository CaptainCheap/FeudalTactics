package com.sesu8642.feudaltactics.gamestate;

import java.util.HashSet;

import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.sesu8642.feudaltactics.gamestate.mapobjects.Tree;
import com.sesu8642.feudaltactics.gamestate.mapobjects.Unit;

public class Kingdom {

	private HashSet<HexTile> tiles;
	private Player player;
	private int savings = 0;
	// only used by ai
	private boolean doneMoving = false;

	public Kingdom(Player player) {
		this.player = player;
		this.tiles = new HashSet<HexTile>();
	}

	public int getIncome() {
		int income = tiles.size();
		for (HexTile tile : tiles) {
			if (tile.getContent() != null
					&& ClassReflection.isAssignableFrom(tile.getContent().getClass(), Tree.class)) {
				income -= 1;
			}
		}
		return income;
	}

	public int getSalaries() {
		int salaries = 0;
		for (HexTile tile : tiles) {
			if (tile.getContent() != null
					&& ClassReflection.isAssignableFrom(tile.getContent().getClass(), Unit.class)) {
				salaries += ((Unit) tile.getContent()).getUnitType().salary();
			}
		}
		return salaries;
	}

	public HashSet<HexTile> getTiles() {
		return tiles;
	}

	public void setTiles(HashSet<HexTile> tiles) {
		this.tiles = tiles;
	}

	public Player getPlayer() {
		return player;
	}

	public int getSavings() {
		return savings;
	}

	public void setSavings(int savings) {
		this.savings = savings;
	}

	public boolean isDoneMoving() {
		return doneMoving;
	}

	public void setDoneMoving(boolean doneMoving) {
		this.doneMoving = doneMoving;
	}

	@Override
	public String toString() {
		return super.toString() + "; savings: " + getSavings() + ", income: " + getIncome() + ", salaries: "
				+ getSalaries();
	}

}
