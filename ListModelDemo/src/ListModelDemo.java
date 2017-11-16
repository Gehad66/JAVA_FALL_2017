import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListModelDemo extends JFrame {

	private JLabel label1;
	private JTextField textField;
	private JButton addBtn;
	private JLabel label2;
	private JLabel label3;
	private JList countryList;
	private JComboBox countryDropdown;
	private DefaultListModel<String> listModel;
	private DefaultComboBoxModel<String> dropdownModel;
	
	public ListModelDemo(String title) {
		super(title);

		setLayout(new FlowLayout());
		
		listModel = new DefaultListModel<>();
		listModel.addElement("USA");
		listModel.addElement("India");
		listModel.addElement("Vietnam");
		listModel.addElement("Canada");
		listModel.addElement("Denmark");
		listModel.addElement("France");
		listModel.addElement("Great Britain");
		listModel.addElement("Japan");

		dropdownModel = new DefaultComboBoxModel<String>();
		dropdownModel.addElement("USA");
		dropdownModel.addElement("India");
		dropdownModel.addElement("Vietnam");
		dropdownModel.addElement("Canada");
		dropdownModel.addElement("Denmark");
		dropdownModel.addElement("France");
		dropdownModel.addElement("Great Britain");
		dropdownModel.addElement("Japan");

		
		label1 = new JLabel("Add Item : ");
		label2 = new JLabel("Selected Item From List : ");
		label3 = new JLabel("Selected Item From Dropdown : ");
		
		textField = new JTextField("Enter Text Here");
		addBtn = new JButton("Add Item To List");

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dropdownModel.addElement(textField.getText());
				listModel.addElement(textField.getText());
			}
		});

		// create the list
		countryList = new JList<>(listModel);
		countryDropdown = new JComboBox<>(dropdownModel);
		
		countryList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				label2.setText("Selected Item From List : " + countryList.getSelectedValue().toString());
			}
		});
		
		countryDropdown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label3.setText("Selected Item From Dropdown : " + countryDropdown.getSelectedItem().toString());
			}
		});
		
		add(label1);
		add(textField);
		add(addBtn);
		add(countryList);
		add(countryDropdown);
		add(label2);
		add(label3);
	}
}
