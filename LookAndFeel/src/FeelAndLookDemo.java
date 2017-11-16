import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

class FeelAndLookDemo extends JFrame {

	private JButton windows, motif, metal;
	
	public static final String MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static final String WINDOWS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static final String METAL = "javax.swing.plaf.metal.MetalLookAndFeel";

	FeelAndLookDemo(String title) {
		super(title);
		setLayout(new FlowLayout());

		windows = new JButton("Windows");
		windows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					UIManager.setLookAndFeel(WINDOWS);
					SwingUtilities.updateComponentTreeUI(FeelAndLookDemo.this);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		motif = new JButton("Motif");
		motif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					UIManager.setLookAndFeel(MOTIF);
					SwingUtilities.updateComponentTreeUI(FeelAndLookDemo.this);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		});

		metal = new JButton("Metal");
		metal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					UIManager.setLookAndFeel(METAL);
					SwingUtilities.updateComponentTreeUI(FeelAndLookDemo.this);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		add(windows);
		add(motif);
		add(metal);

	}

}