import javax.swing.*;

public class Run{

	public static void main (String[] args){
	
		NotepadDemo  notepad = new NotepadDemo("Notepad");
		notepad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		notepad.setSize(800,700);
		notepad.setVisible(true);
		notepad.setLocationRelativeTo(null);
	}

}
