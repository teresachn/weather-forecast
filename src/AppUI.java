import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import weatherpack.WeatherRetriever;

public class AppUI {

  public JFrame frame;
  private static boolean visibleP2 = true;

  /***
   * Membuat objek UI program weather forecast
   * Menciptakan objek dalam UI dan hubungan diantara objek-objek tersebut
   */

  public AppUI() {
    frame = new JFrame("Weather Forecast");

    // SETTING UP PANEL 1
    // AND OBJECT INSIDE IT
    JLabel background = new JLabel(new ImageIcon("Asset/Background1.png"));
    background.setBounds(0, 0, 260, 480);

    JLabel label1 = new JLabel("Weather");
    label1.setBounds(37, 43, 210, 50); label1.setFont(new Font("Olde English", Font.BOLD, 45));

    JLabel label2 = new JLabel("Forecast");
    label2.setBounds(77, 80, 210, 50); label2.setFont(new Font("Olde English", Font.BOLD, 45));

    JLabel city = new JLabel("Search city:");
    city.setBounds(63, 156, 120, 18); city.setFont(new Font("Times New Roman", Font.BOLD, 16));

    JTextField text = new JTextField("Bandung");
    text.setBounds(63, 180, 135, 20);

    JButton button1 = new JButton(new ImageIcon("Asset/Button1.png"));
    button1.setBounds(49, 252, 162, 41); button1.setBorder(null);

    JButton button2 = new JButton(new ImageIcon("Asset/Button2.png"));
    button2.setBounds(49, 322, 162, 41); button2.setBorder(null);

    JPanel panel1 = new JPanel(); 
    panel1.setBounds(0, 0, 260, 480); panel1.setBackground(Color.white); panel1.setLayout(null);

    // add object to panel1
    panel1.add(background);
    panel1.add(city);
    panel1.add(label1); panel1.add(label2);
    panel1.add(text);
    panel1.add(button1); panel1.add(button2);

    // Setting up secondary panel
    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.white); panel2.setBounds(260, 0, 360, 480);
    panel2.setLayout(null);

    JPanel panel3 = new JPanel();
    panel3.setBackground(Color.black); panel3.setBounds(260, 0, 360, 480);
    panel3.setLayout(null);
    
    // Testing toggle between button
    // Action Listener
    button1.addActionListener(new ActionListener(){
    
      @Override
      public void actionPerformed(ActionEvent e) {
        if (!visibleP2) {
          panel3.setVisible(false);
          panel2.setVisible(true);
          visibleP2 = true;
        }
        if (text.getText() != null) {
          panel2.removeAll();
          panel2.updateUI();

          WeatherRetriever wRetriever = new WeatherRetriever(text.getText());

          JLabel wIcon = new JLabel(new ImageIcon("Asset/" + wRetriever.getIcon() + ".png"));
          wIcon.setBounds(85, 60, 200, 200);

          JLabel city = new JLabel(wRetriever.getCity() + ", " + wRetriever.getCountry());
          city.setFont(new Font("Olde English", Font.BOLD, 30)); city.setBounds(40, 0, 300, 30);
          city.setAlignmentX(Component.CENTER_ALIGNMENT);

          JLabel desc = new JLabel(wRetriever.getDescription());
          desc.setFont(new Font("Times New Roman", Font.ITALIC, 18)); 
          desc.setBounds(40, 30, 300, 20);
          desc.setAlignmentX(Component.CENTER_ALIGNMENT);

          JPanel panel2a = new JPanel();
          panel2a.setBounds(40, 275, 300, 60);
          panel2a.setLayout(new BoxLayout(panel2a, BoxLayout.PAGE_AXIS));

          if (wRetriever.getIcon().contains("n")) {
            panel2.setBackground(Color.black);
            panel2a.setBackground(Color.black);
            city.setForeground(Color.white);
            desc.setForeground(Color.white);
          } else if (wRetriever.getIcon().contains("d")) {
            panel2.setBackground(Color.white);
            panel2a.setBackground(Color.white);
            city.setForeground(Color.black);
            desc.setForeground(Color.black);
          }
          panel2.add(wIcon); panel2a.add(city); 
          panel2a.add(Box.createVerticalStrut(2)); panel2a.add(desc);
          panel2.add(panel2a);
        }
      }
    });

    button2.addActionListener(new ActionListener(){
    
      @Override
      public void actionPerformed(ActionEvent e) {
        if (visibleP2) {
          panel3.setVisible(true);
          panel2.setVisible(false);
          visibleP2 = false;
        }
      }
    });

    frame.add(panel1);
    frame.add(panel2);
    frame.add(panel3);

    // FRAME FINAL CONFIGURATION
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(630, 510);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setResizable(false);
  }

  public static void main(String[] args) {
    new AppUI();
  }
}