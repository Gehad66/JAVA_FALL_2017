
public class StaticGameObject extends GameObject implements Hittable {

	public StaticGameObject(String iconURL, int width, int height, int posX, int posY) {
		super(iconURL, width, height, posX, posY);
	}


	@Override
	public boolean isHit(GameObject obj) {
		return false;
	}

	
}
