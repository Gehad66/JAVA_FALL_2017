import java.awt.event.*;
import javax.swing.*;

public class NotepadDemo extends JFrame {

	private JTextArea workspace;
	private JMenuBar menu;
	private JMenu file, edit, help;
	private JMenuItem new_f, open, save, exit, cut, copy, paste, delete, selectall, about;
	private String selectedtext = " ";

	NotepadDemo(String title) {
		super(title);

		workspace = new JTextArea(20, 20);
		menu = new JMenuBar();
		setJMenuBar(menu);

		file = new JMenu("File");
		edit = new JMenu("Edit");
		help = new JMenu("Help");

		new_f = new JMenuItem("New", 'N');
		new_f.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_MASK));
		
		open = new JMenuItem("Open", 'O');
		open.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
		
		save = new JMenuItem("Save", 'S');
		save.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
		
		exit = new JMenuItem("Exit", 'E');
		exit.setAccelerator(KeyStroke.getKeyStroke('R', KeyEvent.CTRL_MASK));
		
		cut = new JMenuItem("Cut", 'X');
		cut.setAccelerator(KeyStroke.getKeyStroke('Q', KeyEvent.CTRL_MASK));
		
		copy = new JMenuItem("Copy", 'V');
		copy.setAccelerator(KeyStroke.getKeyStroke('W', KeyEvent.CTRL_MASK));
		
		paste = new JMenuItem("Paste", 'P');
		paste.setAccelerator(KeyStroke.getKeyStroke('E', KeyEvent.CTRL_MASK));
		
		delete = new JMenuItem("Delete", 'D');
		delete.setAccelerator(KeyStroke.getKeyStroke('D', KeyEvent.CTRL_MASK));
		
		selectall = new JMenuItem("Select All", 'A');
		selectall.setAccelerator(KeyStroke.getKeyStroke('A', KeyEvent.CTRL_MASK));
		
		about = new JMenuItem("About", 'A');
		about.setAccelerator(KeyStroke.getKeyStroke('T', KeyEvent.CTRL_MASK));

		file.add(new_f);
		file.add(open);
		file.add(save);
		file.add(exit);
		
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(delete);
		edit.add(selectall);
		
		help.add(about);
		
		menu.add(file);
		menu.add(edit);
		menu.add(help);

		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFileChooser chooser = new JFileChooser();
				if (chooser.showOpenDialog(NotepadDemo.this) == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getPath();
					/* TODO 
					 *  You should now able to read file content and am asking you instead of printing the file path
					 *  read the file content and add it to the workspace. 
					 * */
					workspace.setText(path);
				}
			}
		});

		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if (chooser.showSaveDialog(NotepadDemo.this) == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getPath();
					/* TODO 
					 *  As above you also advised to write a text file to the chosen path.
					 * */
					workspace.setText(path);
				}
			}
		});

		new_f.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				int reply1 = JOptionPane.showConfirmDialog(null,
						"Press Yes If You Want To Save. \n", "Save",
						JOptionPane.YES_NO_OPTION);

				if (reply1 == JOptionPane.YES_OPTION) {

					JFileChooser chooser = new JFileChooser();
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					if (chooser.showSaveDialog(NotepadDemo.this) == JFileChooser.APPROVE_OPTION) {
						String path = chooser.getSelectedFile().getPath();
						workspace.setText(path);
					}

				} else if (reply1 == JOptionPane.NO_OPTION)
					workspace.setText("");

			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				System.exit(0);
			}
		});

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				JOptionPane.showMessageDialog(null, "Developed By Mokhtar Ahmed.");
			}
		});

		cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {

				int start = workspace.getSelectionStart();
				int end = workspace.getSelectionEnd();
				selectedtext = workspace.getSelectedText();
				workspace.replaceRange("", start, end);
			}
		});

		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				selectedtext = workspace.getSelectedText();
			}
		});

		paste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				workspace.insert(selectedtext, workspace.getCaretPosition());
			}
		});

		selectall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				workspace.setSelectionStart(0);
				String s = workspace.getText();
				workspace.setSelectionEnd((s.length()));
			}
		});

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				int start = workspace.getSelectionStart();
				int end = workspace.getSelectionEnd();
				workspace.replaceRange("", start, end);
			}
		});
		
		add(workspace);
	}

}