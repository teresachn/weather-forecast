import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppUI {
  private JFrame frame;
  private JPanel panel1;
  private JButton button;
  private JTextField text;
  private JLabel label;

  public AppUI() {
    frame = new JFrame("Weather Forecast");

    // SETTING UP PANEL 1
    // AND OBJECT INSIDE IT
    panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
    panel1.setBounds(0, 0, 260, 480);
    panel1.setBackground(Color.white);
    panel1.setLayout(null);
    label = new JLabel("Weather Forecast");
    label.setBounds(10, 20, 250, 40);
    label.setFont(new Font("Olde English", Font.BOLD, 35));
    text = new JTextField();
    text.setBounds(70, 70, 120, 20);
    button = new JButton("Weather Now");
    button.setBounds(70, 100, 120, 30);
    panel1.add(label);
    panel1.add(text);
    panel1.add(button);
    frame.add(panel1);

    // FRAME CONFIGURATION
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(640, 480);
    frame.setLayout(null);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new AppUI();
  }
}