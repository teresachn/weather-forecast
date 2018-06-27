import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppUI {

  public AppUI() {
    JFrame frame = new JFrame("Weather Forecast");

    // SETTING UP PANEL 1
    // AND OBJECT INSIDE IT
    JPanel panel1 = new JPanel();
    panel1.setBounds(0, 0, 260, 480);
    panel1.setBackground(Color.white);
    panel1.setLayout(null);
    JLabel background = new JLabel(new ImageIcon("Asset/Background1.png"));
    background.setBounds(0, 0, 260, 480);
    JLabel label1 = new JLabel("Weather");
    label1.setBounds(52, 40, 210, 50);
    label1.setFont(new Font("Olde English", Font.BOLD, 50));
    JLabel label2 = new JLabel("Forecast");
    label2.setBounds(47, 90, 210, 50);
    label2.setFont(new Font("Olde English", Font.BOLD, 50));
    JLabel city = new JLabel("Search city:");
    city.setBounds(70, 160, 120, 12);
    city.setFont(new Font("Times New Roman", Font.BOLD, 12));
    JTextField text = new JTextField();
    text.setBounds(70, 180, 120, 20);
    JButton button = new JButton(new ImageIcon("Asset/Button1.png"));
    button.setBounds(40, 210, 180, 45);
    button.setBorder(null);

    // add object to panel1
    panel1.add(background);
    panel1.add(city);
    panel1.add(label1);
    panel1.add(label2);
    panel1.add(text);
    panel1.add(button);
    frame.add(panel1);

    // FRAME CONFIGURATION
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(640, 520);
    frame.setLayout(null);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new AppUI();
  }
}