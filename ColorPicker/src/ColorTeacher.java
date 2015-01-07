import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorTeacher implements ActionListener {
	String voice;

	public ColorTeacher() {

	}

	public ColorTeacher(String voice) {
		this.voice = "-v " + voice + " ";

	}

	JFrame frame = new JFrame("Pick a color");
	JPanel panel = new JPanel();
	JButton yellow = new JButton();
	JButton red = new JButton();
	JButton blue = new JButton();
	JButton green = new JButton();
	JButton randomButton = new JButton();
	Random rand = new Random();

	public void setUp() {

		frame.add(panel);
		panel.add(yellow);
		panel.add(blue);
		panel.add(red);
		panel.add(green);
		panel.add(randomButton);

		yellow.addActionListener(this);
		red.addActionListener(this);
		blue.addActionListener(this);
		green.addActionListener(this);
		randomButton.addActionListener(this);

		red.setBackground(Color.red);
		blue.setBackground(Color.blue);
		green.setBackground(Color.green);
		yellow.setBackground(Color.yellow);
		randomButton.setBackground(new Color(rand.nextInt(0xFFFFFF)));

		red.setOpaque(true);
		blue.setOpaque(true);
		green.setOpaque(true);
		yellow.setOpaque(true);
		randomButton.setOpaque(true);

		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		if (buttonPressed == red) {
			speak("Red");
		} else if (buttonPressed == blue) {
			speak("Blue");
		} else if (buttonPressed == yellow) {
			speak("Yellow");
		} else if (buttonPressed == green) {
			speak("Green");
		} else if (buttonPressed == randomButton) {
			ColorUtils utils = new ColorUtils();
			System.out.println(utils.getColorNameFromRgb(randomButton
					.getBackground().getRed(), randomButton.getBackground()
					.getGreen(), randomButton.getBackground().getBlue()));

			speak(utils.getColorNameFromRgb(randomButton.getBackground()
					.getRed(), randomButton.getBackground().getGreen(),
					randomButton.getBackground().getBlue()));
		}

		randomButton.setBackground(new Color(rand.nextInt(0xFFFFFF)));
		frame.pack();
	}

	public void speak(String words) {
		try {

			if (voice == null) {
				Runtime.getRuntime().exec("say " + words);
			} else {
				Runtime.getRuntime().exec("say " + voice + words);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Ooops Error");
		}
	}
}
