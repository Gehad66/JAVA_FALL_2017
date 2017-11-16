import javax.swing.*;

public class Run{

	public static void main (String[] args){
	
		ListModelDemo  listModelDemo = new ListModelDemo("List Model Demo");
		listModelDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//listModelDemo.setSize(200,200);
		listModelDemo.pack();
		listModelDemo.setVisible(true);
		listModelDemo.setLocationRelativeTo(null);
	}

}
