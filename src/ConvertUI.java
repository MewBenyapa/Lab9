

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User can convert unit.
 */

public class ConvertUI extends JFrame {

	/**
	 * Create attributes.
	 */
	private JButton convertButton;
	private JButton clearButton;

	private JComboBox<Unit> unit1ComboBox;
	private JComboBox<Unit> unit2ComboBox;

	private JTextField inputField1;
	private JTextField inputField2;

	private JRadioButton right;
	private JRadioButton left;
	private JRadioButton auto;

	private UnitConverter converter;

	private JLabel equalLabel; 

	public ConvertUI(UnitConverter uc) {
		this.converter = uc;
		this.setTitle("Distance Converter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}

	public void run() {
		setVisible(true);
	}

	/**
	 * Set all graphic 
	 */

	private void initComponents() {

		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Units");

		JMenuItem length = new JMenuItem("Length");
		length.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Unit[] lengths = converter.getLength();
				unit1ComboBox.removeAllItems();
				for (Unit u : lengths)
					unit1ComboBox.addItem(u);
				unit1ComboBox = new JComboBox<Unit>(lengths);

				Unit[] lengthsForUnit2 = converter.getLength();
				unit2ComboBox.removeAllItems();
				for (Unit u : lengthsForUnit2)
					unit2ComboBox.addItem(u);
				unit2ComboBox = new JComboBox<Unit>(lengthsForUnit2);
			}
		});

		JMenuItem area = new JMenuItem("Area");
		area.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Unit[] area = converter.getArea();
				for (Unit u : area)
					unit1ComboBox.addItem(u);
				unit1ComboBox = new JComboBox<Unit>(area);

				Unit[] areaForUnit2 = converter.getArea();
				for (Unit u : areaForUnit2)
					unit2ComboBox.addItem(u);
				unit2ComboBox = new JComboBox<Unit>(areaForUnit2);
			}
		});

		JMenuItem weight = new JMenuItem("Weight");
		weight.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Unit[] weight = converter.getWeight();
				for (Unit u : weight)
					unit1ComboBox.addItem(u);
				unit1ComboBox = new JComboBox<Unit>(weight);

				Unit[] weightForUnit2 = converter.getWeight();
				for (Unit u : weightForUnit2)
					unit2ComboBox.addItem(u);
				unit2ComboBox = new JComboBox<Unit>(weightForUnit2);
			}
		});

		JMenuItem volume = new JMenuItem("Volume");
		volume.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Unit[] volume = converter.getVolume();
				for (Unit u : volume)
					unit1ComboBox.addItem(u);
				unit1ComboBox = new JComboBox<Unit>(volume);

				Unit[] volumeForUnit2 = converter.getVolume();
				for (Unit u : volumeForUnit2)
					unit2ComboBox.addItem(u);
				unit2ComboBox = new JComboBox<Unit>(volumeForUnit2);
			}

		});

		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		menuBar.add(menu);

		menu.add(length);
		menu.add(area);
		menu.add(weight);
		menu.add(volume);
		menu.add(exit);

		/**
		 * Set layout
		 */
		Container bigContent = new Container();
		bigContent.setLayout(new BoxLayout(bigContent, BoxLayout.Y_AXIS));

		Container contents1 = new Container();
		contents1.setLayout(new FlowLayout());

		Container contents2 = new Container();
		contents2.setLayout(new FlowLayout());

		unit1ComboBox = new JComboBox<Unit>();
		unit2ComboBox = new JComboBox<Unit>();

		inputField1 = new JTextField(10);
		inputField2 = new JTextField(10);

		equalLabel = new JLabel(" = ");

		convertButton = new JButton("Convert!");
		clearButton = new JButton("Clear");

		ButtonGroup group = new ButtonGroup();
		left = new JRadioButton("Left -> Right");
		right = new JRadioButton("Right -> Left");
		auto = new JRadioButton("Auto");
		group.add(left);
		group.add(right);
		group.add(auto);

		/**
		 * Add components to window.
		 */
		this.add(bigContent);
		bigContent.add(contents1);
		bigContent.add(contents2);
		contents1.add(inputField1);
		contents1.add(unit1ComboBox);
		contents1.add(equalLabel);
		contents1.add(inputField2);
		contents1.add(unit2ComboBox);
		contents1.add(convertButton);
		contents1.add(clearButton);
		contents2.add(left);
		contents2.add(right);
		contents2.add(auto);

		setJMenuBar(menuBar);

		getContentPane().add(bigContent);

		ActionListener listenerConvert = new ConvertButtonlistener();
		convertButton.addActionListener(listenerConvert);

		ActionListener listenerClear = new ClearButtonLisener();
		clearButton.addActionListener(listenerClear);

		this.pack();
	}

	/**
	 * Set clear button.
	 */

	class ClearButtonLisener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			inputField1.setText("");
			inputField2.setText("");
		}
	}

	/**
	 * Set convert button.
	 */

	class ConvertButtonlistener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {

			// get text from the input field 
			String s = "";
			if (left.isSelected()) {
				s = inputField1.getText().trim();
			} else if (right.isSelected()) {
				s = inputField2.getText().trim();
			} else {
				if (inputField1.getText().length() > 0) {
					s = inputField1.getText().trim();
				} else {
					s = inputField2.getText().trim();
				}
			}

			if (s.length() > 0) {
				try {
					double value = Double.valueOf(s);

					// get the unit that the user selected in combo boxes
					Unit unit1 = (Unit)unit1ComboBox.getSelectedItem();
					Unit unit2 = (Unit)unit2ComboBox.getSelectedItem();

					// call the converter to convert the value
					// write the result into output field


					if (auto.isSelected()) {
						if (inputField1.getText().length() > 0) {
							inputField2.setText(String.valueOf(converter.convert(value, unit1, unit2)));
						} else {
							inputField1.setText(String.valueOf(converter.convert(value, unit2, unit1)));
						}						
					} else if (left.isSelected()) {
						inputField2.setText(String.valueOf(converter.convert(value, unit1, unit2)));
					} else if(right.isSelected()) {
						inputField1.setText(String.valueOf(converter.convert(value, unit2, unit1)));
					} 

				} catch (NumberFormatException exception) {
					System.out.print("You must input number!");
				}
			}			
		}
	}
}