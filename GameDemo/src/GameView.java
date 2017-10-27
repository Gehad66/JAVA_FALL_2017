import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends JFrame implements KeyListener {
	private JPanel scene;
	private GameController gameController;

	public GameView(String title, int width, int height) {
		super(title);
		setSize(width, height);

		scene = new JPanel();
		scene.setLayout(null);
		add(scene);

		addKeyListener(this);
		setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public GameController getGameController() {
		return gameController;
	}

	public void setGameController(GameController gameController) {
		this.gameController = gameController;
	}

	public void refreshScene() {
		revalidate();
		repaint();
	}

	public void setSceneBackground() {
		scene.setBackground(Color.WHITE);
	}

	public void showScene() {
		setVisible(true);
	}

	public void drawToScene(List<GameObject> gameObjects) {
		scene.removeAll();
		for (GameObject obj : gameObjects) {
			JLabel lbl = new JLabel(obj.getIcon());
			lbl.setBounds(obj.getPosX(), obj.getPosY(), obj.getWidth(), obj.getHeight());
			scene.add(lbl);
		}
	}

	public void reDrawObejct(GameObject obj) {
		JLabel lbl = new JLabel(obj.getIcon());
		lbl.setBounds(obj.getPosX(), obj.getPosY(), obj.getWidth(), obj.getHeight());
		scene.add(lbl);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			getGameController().fire();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void showGameOver() {
		scene.removeAll();
		ImageIcon icon = new ImageIcon(this.getClass().getResource(ResourcesUtils.GAMEOVER_IMG));
		JLabel lbl = new JLabel(icon);
		lbl.setBounds(300, 300, 200, 200);
		scene.add(lbl);
		refreshScene();

	}
}
