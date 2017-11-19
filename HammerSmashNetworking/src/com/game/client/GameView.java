package com.game.client;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.game.server.GameController;
import com.game.server.GameObject;
import com.game.server.ResourcesUtils;

public class GameView extends JFrame implements KeyListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7526509833400624229L;
	private JPanel scene;
	private PlayerInt playerInt;

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

	public PlayerInt getPlayerInt() {
		return playerInt;
	}

	public void setPlayerInt(PlayerInt playerInt) {
		this.playerInt = playerInt;
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
	

	public void drawToScene(GameObject obj) {
		JLabel lbl = new JLabel(obj.getIcon());
		lbl.setBounds(obj.getPosX(), obj.getPosY(), obj.getWidth(), obj.getHeight());
		scene.add(lbl);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			try {
				getPlayerInt().fire();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
