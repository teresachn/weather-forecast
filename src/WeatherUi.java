import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.JSONArray;

import weatherpack.CityFinder;
import weatherpack.ForecastRetriever;
import weatherpack.WeatherRetriever;

public class WeatherUi {

  public JFrame frame;
  public JPanel panel1;
  public JPanel panel2;
  public JPanel panel3;
  JScrollPane scrollpane;
  public JTextField text;
  public JButton button1;
  public JButton button2;
  private static boolean visibleP2 = true;
  private final String[] errorMessage = new String[] {"No city to search!", "City not found!",
      "Error Encountered, please retry later!"};
  private String cityId;

  private CityFinder cityFinder;

  /**
   * Membuat objek UI program weather forecast.
   * Menciptakan objek dalam UI dan hubungan diantara objek-objek tersebut
   */

  public WeatherUi() {
    frame = new JFrame("Weather Forecast");
    cityFinder = new CityFinder();

    setMainPanel();

    showMainMenu();

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
        if (!text.getText().equals("")) {
          
          JSONArray citySameName = cityFinder.findCity(text.getText());
          if (citySameName.length() == 0) {
            showMessageError(1);
          } else {
            if (citySameName.length() > 1) {
              showCityOption(citySameName);
            } else {
              cityId = Integer.toString(citySameName.getJSONObject(0).getInt("id"));
            }
            if (cityId != null) {
              showCurrentWeather(cityId);
            }
          }
          
        } else {
          showMessageError(0);
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
        if (!text.getText().equals("")) {
          
          JSONArray citySameName = cityFinder.findCity(text.getText());
          if (citySameName.length() == 0) {
            showMessageError(1);
          } else {
            if (citySameName.length() > 1) {
              showCityOption(citySameName);
            } else {
              cityId = Integer.toString(citySameName.getJSONObject(0).getInt("id"));
            }
            if (cityId != null) {
              showWeatherForecast(cityId);
            }
          }
          
        } else {
          showMessageError(0);
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

  /**
   * Method untuk menyiapkan JPanel utama pada program.
   */
  public void setMainPanel() {

    panel1 = new JPanel(); 
    panel1.setBounds(0, 0, 260, 480);
    panel1.setBackground(Color.white);
    panel1.setLayout(null);

    panel2 = new JPanel();
    panel2.setBackground(Color.white);
    panel2.setBounds(260, 0, 380, 480);
    panel2.setLayout(null);

    panel3 = new JPanel();
    panel3.setBackground(Color.black);
    panel3.setBounds(260, 0, 380, 480);
    panel3.setLayout(null);
  }

  /**
   * Method untuk menampilkan komponen yang tidak interaktif pada Main Menu.
   */
  public void showMainMenu() {
    text = new JTextField();
    text.setBounds(63, 180, 135, 20);

    button1 = new JButton(new ImageIcon("Asset/Button1.png"));
    button1.setBounds(49, 252, 162, 41);
    button1.setBorder(null);

    button2 = new JButton(new ImageIcon("Asset/Button2.png"));
    button2.setBounds(49, 322, 162, 41);
    button2.setBorder(null);

    // add object to panel1
    panel1.add(text);
    panel1.add(button1);
    panel1.add(button2);

    JLabel background = new JLabel(new ImageIcon("Asset/Background.png"));
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

    panel1.add(background);
    panel1.add(city);
    panel1.add(label1);
    panel1.add(label2);
  }

  /**
   * Method untuk menampilkan UI cuaca terkini pada program.
   * @param cityId Id dari suatu kota berdasarkan city.list.json
   */
  public void showCurrentWeather(String cityId) {
    panel2.removeAll();
    panel2.updateUI();

    WeatherRetriever weRetriever = new WeatherRetriever(cityId);
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

    JLabel celsius = new JLabel(" \u00b0C"); // \u00b0 is °
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
      private static final long serialVersionUID = 1L;

      @Override
      protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.rotate(weRetriever.getWindDegree() * Math.PI / 180, 60, 60);
        super.paintComponent(g2);
      }
    };
    windWay.setBounds(220, 300, 120, 120);

    if (weRetriever.getIcon().contains("n")) {
      panel2.setBackground(Color.black);
      city.setForeground(Color.white);
      desc.setForeground(Color.white);
      temp.setForeground(Color.white);
      celsius.setForeground(Color.white);
      press.setForeground(Color.white);
      humi.setForeground(Color.white);
      wind.setForeground(Color.white);
    } else if (weRetriever.getIcon().contains("d")) {
      panel2.setBackground(Color.white);
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

  /**
   * Method untuk menampilkan ramalan cuaca
   * @param cityId Id dari suatu kota berdasarkan city.list.json
   */
  public void showWeatherForecast(String cityId) {
    panel3.removeAll();
    panel3.updateUI();

    try {
      ForecastRetriever foRetriever = new ForecastRetriever(cityId);
      JPanel cityPanel = new JPanel();
      cityPanel.setBounds(0, 0, 380, 70);
      cityPanel.setBackground(Color.white);
      cityPanel.setLayout(null);

      JLabel cityName = new JLabel(foRetriever.getCityName() + ", " + foRetriever.getCountry());
      cityName.setFont(new Font("Olde English", Font.PLAIN, 30));
      cityName.setBounds(10, 10, 360, 35);
      
      JLabel cityLonLat = new JLabel("Lon: " + foRetriever.getLon() + ", Lat: " 
          + foRetriever.getLat());
      cityLonLat.setFont(new Font("Times New Roman", Font.BOLD, 12));
      cityLonLat.setBounds(10, 50, 360, 15);

      cityPanel.add(cityName);
      cityPanel.add(cityLonLat);

      panel3.add(cityPanel);

      JPanel pan = new JPanel(new BorderLayout(0,0));
      pan.setBounds(10, 80, 355, 390);
      pan.setBackground(Color.white);

      JPanel pan1 = new JPanel(new GridBagLayout());
      pan1.setBounds(0, 0, 355, 390);

      GridBagConstraints c = new GridBagConstraints();
      c.fill = GridBagConstraints.HORIZONTAL;
      c.gridy = 0;
      c.ipadx = 355;
      c.gridx = 0;

      SimpleDateFormat fodatereader = new SimpleDateFormat("yyyy-MM-dd");
      SimpleDateFormat fodateformat = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);

      String date = "";

      //Set Windway icon
      ImageIcon windway = new ImageIcon("Asset/wind.png");
      Image windwayimg = windway.getImage();
      Image newwindimg = windwayimg.getScaledInstance(50, 50, Image.SCALE_DEFAULT);


      for (int i = 0; i < foRetriever.getJsonArrayForecast().length(); i++) {
        String temp = fodateformat.format(fodatereader.parse(foRetriever.getForecastTime(i)));
        if (!date.equals(temp)) {
          date = temp;
          //Create JPanel for date
          JPanel datePanel = new JPanel();
          datePanel.setLayout(null);
          datePanel.setBackground(Color.gray);
          JLabel dateLabel = new JLabel(date);
          dateLabel.setHorizontalAlignment(SwingConstants.LEFT);
          dateLabel.setFont(new Font("Olde English", Font.PLAIN, 30));
          dateLabel.setBounds(10, 5, 300, 32);
          datePanel.add(dateLabel);
          c.ipady = 40;
          c.gridy = c.gridy + 1;
          pan1.add(datePanel, c);
        }
        
        //Create JPanel for forecast
        JPanel forePan = new JPanel();
        forePan.setLayout(null);
        forePan.setBackground(Color.white);
        
        //JLabel time
        String foTime = foRetriever.getForecastTime(i);
        JLabel time = new JLabel(foTime.substring(foTime.length() - 8,foTime.length() - 3));
        time.setFont(new Font("Olde English", Font.PLAIN, 30));
        time.setBounds(15, 25, 100, 35);

        //Set weather icon
        ImageIcon conv = new ImageIcon("Asset/" + foRetriever.getIcon(i) + ".png");
        Image imaconv = conv.getImage();
        Image newimg = imaconv.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(newimg));
        icon.setBounds(90, 15, 50, 50);
        
        final int degree = foRetriever.getWindDegree(i);
        JLabel wind = new JLabel(new ImageIcon(newwindimg)) {
          private static final long serialVersionUID = 1L;
          
          @Override
          protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.rotate(degree * Math.PI / 180, 25, 25);
            super.paintComponent(g2);
          }
        };
        wind.setBounds(150, 15, 50, 50);

        //Add JLabel for temp, humidity, pressure, windspeed
        JLabel desc = new JLabel("<html><p>Temperature: " + foRetriever.getTemperature(i) 
            + " \u00b0C<br>Pressure: " + foRetriever.getPressure(i)  // \u00b0 is °
            + " hPa<br>Humidity: " + foRetriever.getHumidity(i) 
            + " %<br>Wind Speed: " + foRetriever.getWindSpeed(i) + " m/s<p>");
        desc.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        desc.setBounds(210, 10, 300, 60);
        c.ipady = 80;
        c.gridy = c.gridy + 1;

        //Possibly also wind degree

        //Add component to forePan
        forePan.add(icon);
        forePan.add(wind);
        forePan.add(time);
        forePan.add(desc);
        
        pan1.add(forePan, c);
      }

      //*/
      
      //Add JScrollpane
      JScrollPane scroll = new JScrollPane();
      scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      scroll.setViewportView(pan1);

      pan.add(scroll, BorderLayout.CENTER);
      panel3.add(pan);
    } catch (Exception e) {
      showMessageError(2);
    }
  }

  /**
   * Method untuk menampilkan daftar nama kota yang sama berdasarkan hasil pencarian.
   * @param cityOpt Kata kunci pencarian kota
   */
  public void showCityOption(JSONArray cityOpt) {
    JDialog citySame = new JDialog(frame, "Search Result", true);
    citySame.setBounds(100, 100, 450, 400);
    citySame.getContentPane().setLayout(new BorderLayout(0, 0));
    
    JPanel pan = new JPanel(new GridBagLayout());
    pan.setBackground(Color.white);
    
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;    

    for (int i = 0; i < cityOpt.length(); i++) {
      JButton cityButton = new JButton(
          "<html><h1>" + getName(cityOpt, i) + ", " + getCountry(cityOpt, i) + "</h1><p>Lon: " 
          + getLong(cityOpt, i) + ", Lat:" + getLat(cityOpt, i) + "</p>");
      cityButton.putClientProperty("id", getId(cityOpt, i));
      cityButton.addActionListener(new ActionListener() {
      
        @Override
        public void actionPerformed(ActionEvent e) {
          cityId = (String) cityButton.getClientProperty("id");
          citySame.setVisible(false);
        }
      });

      c.gridx = 0;
      c.gridy = 0 + i;
      c.gridwidth = 1;
      cityButton.setHorizontalAlignment(SwingConstants.LEFT);
      cityButton.setPreferredSize(new Dimension(430, 100));
      pan.add(cityButton, c);
    }

    JScrollPane scroll = new JScrollPane();
    scroll.setViewportView(pan);
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    citySame.getContentPane().add(scroll, BorderLayout.CENTER);
    citySame.setVisible(true);
  }

  /**
   * Method yang mengembalikan nama kota ke-index dari JSONArray city.
   * @param city JSONArray yang memuat daftar kota
   * @param index Indeks kota pada JSONArray
   * @return nama kota ke-index dari JSONArray city
   */
  public String getName(JSONArray city, int index) {
    return city.getJSONObject(index).getString("name");
  }

  /**
   * Method yang mengembalikan nama negara ke-index dari JSONArray city.
   * @param city JSONArray yang memuat daftar kota
   * @param index Indeks kota pada JSONArray
   * @return nama negara ke-index dari JSONArray city
   */
  public String getCountry(JSONArray city, int index) {
    return city.getJSONObject(index).getString("country");
  }

  /**
   * Method yang mengembalikan Id kota ke-index dari JSONArray city.
   * @param city JSONArray yang memuat daftar kota
   * @param index Indeks kota pada JSONArray
   * @return Id kota ke-index dari JSONArray city
   */
  public String getId(JSONArray city, int index) {
    return Integer.toString(city.getJSONObject(index).getInt("id"));
  }

  /**
   * Method yang mengembalikan koordinat Longitude kota ke-index dari JSONArray city.
   * @param city JSONArray yang memuat daftar kota
   * @param index Indeks kota pada JSONArray
   * @return koordinat Longitude kota ke-index dari JSONArray city
   */
  public String getLong(JSONArray city, int index) {
    return Double.toString(city.getJSONObject(index).getJSONObject("coord").getDouble("lon"));
  }

  /**
   * Method yang mengembalikan koordinat Latitude kota ke-index dari JSONArray city.
   * @param city JSONArray yang memuat daftar kota
   * @param index Indeks kota pada JSONArray
   * @return koordinat Latitude kota ke-index dari JSONArray city
   */
  public String getLat(JSONArray city, int index) {
    return Double.toString(city.getJSONObject(index).getJSONObject("coord").getDouble("lat"));
  }

  /**
   * Method yang menampilkan pesan error.
   * @param i indeks pesan error
   */
  public void showMessageError(int i) {
    JDialog noCity = new JDialog(frame, errorMessage[i], true);
    noCity.setLayout(null);

    JLabel enterCity = new JLabel(errorMessage[i]);
    enterCity.setBounds(12, 13, 260, 14);

    noCity.add(enterCity);

    noCity.setSize(280, 80);
    noCity.setVisible(true);
  }
}