import javax.swing.ImageIcon;

public abstract class GameObject {

	private ImageIcon icon;
	private int width;
	private int height;
	private int posX;
	private int posY;

	public GameObject(String iconURL, int width, int height, int posX, int posY) {
		System.out.println(this.getClass().getResource(iconURL));
		this.icon = new ImageIcon(this.getClass().getResource(iconURL));
		this.width = width;
		this.height = height;
		this.posX = posX;
		this.posY = posY;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

}
