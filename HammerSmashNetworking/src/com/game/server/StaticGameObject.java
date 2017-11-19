package com.game.server;

import java.io.Serializable;

public class StaticGameObject extends GameObject implements Hittable,Serializable {

	private static final long serialVersionUID = 4136574207441726112L;

	public StaticGameObject(String iconURL, int width, int height, int posX, int posY) {
		super(iconURL, width, height, posX, posY);
	}

	@Override
	public boolean isHit(GameObject obj) {
		return false;
	}

}
