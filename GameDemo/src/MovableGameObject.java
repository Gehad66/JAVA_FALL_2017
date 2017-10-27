import java.awt.Rectangle;

public class MovableGameObject extends GameObject implements Hittable, Movable {

	private int xMinBound;
	private int xMaxBound; 
	private int yMinBound;
	private int yMaxBound;
	
	private int direction = 0;
	
	private int dx = 1;
	private int dy = 1;
	
	public static final int MOVE_X = 1;
	public static final int MOVE_Y = -1;
	public static final int MOVE_XY = 0;
	
	private Thread mover;
	


	public MovableGameObject(String iconURL, int width, int height, int posX, int posY,
			int xMinBound,int xMaxBound,int yMinBound, int yMaxBound, int direction) {
		super(iconURL, width, height, posX, posY);
		this.xMinBound = xMinBound;
		this.xMaxBound = xMaxBound;
		this.yMinBound = yMinBound;
		this.yMaxBound = yMaxBound;
		this.direction = direction;
	}

	public Thread getMover() {
		return mover;
	}


	public void setMover(Thread mover) {
		this.mover = mover;
	}
	
	public void startMoving(){
		getMover().start();
	}
	
	public void suspendMoving(){
		getMover().suspend();
	}

	public void resumeMoving(){
		getMover().resume();
	}

	@Override
	public void move(int step) {
		if(direction == MovableGameObject.MOVE_X)
			moveX(step);
		else if(direction == MovableGameObject.MOVE_Y)
			moveY(step);
		else if(direction == MovableGameObject.MOVE_XY)
			moveXY(step);
	}
	
	
	private void moveX(int step){
		if((getPosX()+ getWidth()) > xMaxBound || getPosX() < xMinBound)
			dx = dx * -1;
		setPosX(getPosX() + step * dx);
	}
	
	private void moveY(int step){
		if((getPosY() + getHeight()) > yMaxBound || getPosY() < yMinBound)
			dy = dy * -1;
		setPosY(getPosY() + step * dy);
	}
	
	private void moveXY(int step){
		moveX(step);
		moveY(step);
	}

	@Override
	public boolean isHit(GameObject obj) {
		Rectangle rec1 = new Rectangle(getPosX(), getPosY(), getWidth(), getHeight());
		Rectangle rec2 = new Rectangle(obj.getPosX(), obj.getPosY(), obj.getWidth(), obj.getHeight()); 
		return rec1.intersects(rec2);
	}
	
}
