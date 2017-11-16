import javax.swing.JFrame;


public class Run {

	public static void main(String[] args) {
		FeelAndLookDemo myframe = new FeelAndLookDemo("Look And Feel");
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myframe.setLocationRelativeTo(null);
		myframe.setSize(300, 100);
		myframe.setVisible(true);
	}
}
