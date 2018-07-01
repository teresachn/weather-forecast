import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

  /**
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
    label1.setBounds(37, 43, 210, 50);
    label1.setFont(new Font("Olde English", Font.BOLD, 45));

    JLabel label2 = new JLabel("Forecast");
    label2.setBounds(77, 80, 210, 50);
    label2.setFont(new Font("Olde English", Font.BOLD, 45));

    JLabel city = new JLabel("Search city:");
    city.setBounds(63, 156, 120, 18);
    city.setFont(new Font("Times New Roman", Font.BOLD, 16));

    JTextField text = new JTextField("Pekanbaru");
    text.setBounds(63, 180, 135, 20);

    JButton button1 = new JButton(new ImageIcon("Asset/Button1.png"));
    button1.setBounds(49, 252, 162, 41);
    button1.setBorder(null);

    JButton button2 = new JButton(new ImageIcon("Asset/Button2.png"));
    button2.setBounds(49, 322, 162, 41);
    button2.setBorder(null);

    JPanel panel1 = new JPanel(); 
    panel1.setBounds(0, 0, 260, 480);
    panel1.setBackground(Color.white);
    panel1.setLayout(null);

    // add object to panel1
    panel1.add(background);
    panel1.add(city);
    panel1.add(label1);
    panel1.add(label2);
    panel1.add(text);
    panel1.add(button1);
    panel1.add(button2);

    // Setting up secondary panel
    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.white);
    panel2.setBounds(260, 0, 380, 480);
    panel2.setLayout(null);

    JPanel panel3 = new JPanel();
    panel3.setBackground(Color.black);
    panel3.setBounds(260, 0, 380, 480);
    panel3.setLayout(null);
    
    // Testing toggle between button
    // Action Listener
    button1.addActionListener(new ActionListener() {
    
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

          WeatherRetriever weRetriever = new WeatherRetriever(text.getText());

          JLabel icon = new JLabel(new ImageIcon("Asset/" + weRetriever.getIcon() + ".png"));
          icon.setBounds(210, 100, 140, 140);

          JLabel city = new JLabel(weRetriever.getCity() + ", " + weRetriever.getCountry());
          city.setFont(new Font("Olde English", Font.PLAIN, 40));
          city.setBounds(20, 30, 300, 45);
          city.setAlignmentX(Component.CENTER_ALIGNMENT);

          JLabel desc = new JLabel(weRetriever.getDescription());
          desc.setFont(new Font("Times New Roman", Font.PLAIN, 20)); 
          desc.setBounds(20, 220, 300, 23);
          desc.setAlignmentX(Component.CENTER_ALIGNMENT);

          JLabel temp = new JLabel(weRetriever.getTemperature());
          temp.setFont(new Font("Times New Roman", Font.PLAIN, 130)); 
          temp.setBounds(20, 85, 180, 130);

          JLabel celsius = new JLabel(" \u00b0C");
          celsius.setFont(new Font("Times New Roman", Font.PLAIN, 30));
          celsius.setBounds(145, 100, 80, 30);

          Font fontBelow = new Font("Times New Roman", Font.PLAIN, 20);

          JLabel press = new JLabel("Pressure: " + weRetriever.getPressure() + " hPa");
          press.setFont(fontBelow);
          press.setBounds(20, 300, 300, 22);

          JLabel humi = new JLabel("Humidity: " + weRetriever.getHumidity() + " %");
          humi.setFont(fontBelow);
          humi.setBounds(20, 350, 300, 22);

          JLabel wind = new JLabel("Wind Speed: " + weRetriever.getWindSpeed() + " m/s");
          wind.setFont(fontBelow);
          wind.setBounds(20, 400, 300, 22);
          
          JLabel windWay = new JLabel(new ImageIcon("Asset/wind.png")) {
            @Override
            protected void paintComponent(Graphics g) {
              //super.paintComponent(g);
              Graphics2D g2 = (Graphics2D) g;
              g2.rotate(weRetriever.getWindDegree()*Math.PI/180, 60, 60);
              super.paintComponent(g2);
            }
          };
          windWay.setBounds(220, 300, 120, 120);

          //JPanel panel2a = new JPanel();
          //panel2a.setBounds(40, 275, 300, 60);
          //panel2a.setLayout(new BoxLayout(panel2a, BoxLayout.PAGE_AXIS));

          if (weRetriever.getIcon().contains("n")) {
            panel2.setBackground(Color.black);
            //panel2a.setBackground(Color.black);
            city.setForeground(Color.white);
            desc.setForeground(Color.white);
            temp.setForeground(Color.white);
            celsius.setForeground(Color.white);
            press.setForeground(Color.white);
            humi.setForeground(Color.white);
            wind.setForeground(Color.white);
          } else if (weRetriever.getIcon().contains("d")) {
            panel2.setBackground(Color.white);
            //panel2a.setBackground(Color.white);
            city.setForeground(Color.black);
            desc.setForeground(Color.black);
            temp.setForeground(Color.black);
            celsius.setForeground(Color.black);
            press.setForeground(Color.black);
            humi.setForeground(Color.black);
            wind.setForeground(Color.black);
          }

          panel2.add(icon);
          panel2.add(city);
          panel2.add(desc);
          panel2.add(press);
          panel2.add(temp);
          panel2.add(humi);
          panel2.add(wind);
          panel2.add(windWay);
          panel2.add(celsius);

        }
      }
    });

    button2.addActionListener(new ActionListener() {
    
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
    frame.setSize(640, 510);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setResizable(false);
  }

  public static void main(String[] args) {
    new AppUI();
  }
}