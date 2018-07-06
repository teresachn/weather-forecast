package weatherpack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherRetriever {

  private final String appidKey = "db51885724db8f9b34961a728fd29fda";
  private JSONObject weatherData;

  /**
   * Default constructor WeatherRetriever.
   * @param cityId Id kota untuk dipakai di API
   */
  public WeatherRetriever(String cityId) {
    weatherData = new JSONObject(buildWeatherData(cityId));
  }

  /**
   * Membuat string dari hasil panggilan API untuk digunakan dalam membuat JSONObject.
   * @param cityId Id kota untuk dipakai di API
   * @return String yang bisa membentuk JSONObject
   */
  public String buildWeatherData(String cityId) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      URL apiOWmurl = new URL("http://api.openweathermap.org/data/2.5/weather?id=" + cityId + "&appid=" + appidKey);
      HttpURLConnection httpConnection = (HttpURLConnection) apiOWmurl.openConnection();
      httpConnection.setUseCaches(false);
      httpConnection.connect();
      BufferedReader bufferedReader = new BufferedReader(
          new InputStreamReader(httpConnection.getInputStream()));
      String streamInputString;
      while ((streamInputString = bufferedReader.readLine()) != null) {
        stringBuilder.append(streamInputString);
      }
      bufferedReader.close();
      return stringBuilder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    } 
    return null;
  }

  /**
   * Mengembalikan weatherData.
   * @return JSONObject weatherData
   */
  public JSONObject getWeatherData() {
    return weatherData;
  }

  /**
   * Mengembalikan nama kota yang telah dicari.
   * @return nama kota
   */
  public String getCity() {
    String city;
    try {
      city = getWeatherData().getString("name");
    } catch (JSONException e) {
      city = "City Not Found!";
    }
    return city;
  }

  /**
   * Mengembalikan negara dari kota yang telah dicari.
   * @return negara dari kota
   */
  public String getCountry() {
    String country;
    try {
      country = getWeatherData().getJSONObject("sys").getString("country");
    } catch (JSONException e) {
      country = "Country Not Found!";
    }
    return country;
  }

  /**
   * Mengembalikan deskripsi cuaca kota yang telah dicari.
   * @return deskripsi cuaca
   */
  public String getDescription() {
    String desc;
    try {
      desc = getWeatherData().getJSONArray("weather").getJSONObject(0).getString("description");
    } catch (JSONException e) {
      desc = "Description Not Found!";
    }
    return desc;
  }

  /**
   * Mengembalikan kelembapan kota yang telah dicari.
   * @return kelembapan
   */
  public String getHumidity() {
    String hum;
    try {
      hum = Integer.toString(getWeatherData().getJSONObject("main").getInt("humidity"));
    } catch (JSONException e) {
      hum = "Humidity Not Found!";
    }
    return hum;
  }

  /**
   * Mengembalikan nama icon dari cuaca kota yang telah dicari.
   * @return nama icon dari cuaca
   */
  public String getIcon() {
    String name;
    try {
      name = getWeatherData().getJSONArray("weather").getJSONObject(0).getString("icon");
    } catch (JSONException e) {
      name = "Image Not Found!";
    }
    return name;
  }

  /**
   * Mengembalikan tekanan cuaca kota yang telah dicari.
   * @return tekanan cuaca
   */
  public String getPressure() {
    String press;
    try {
      press = String.format("%.2f", getWeatherData().getJSONObject("main").getFloat("pressure"));
    } catch (JSONException e) {
      press = "Pressure Not Found!";
    }
    return press;
  }

  /**
   * Mengembalikan suhu kota yang telah dicari.
   * @return suhu
   */
  public String getTemperature() {
    String temp;
    try {
      temp = Integer.toString(getWeatherData().getJSONObject("main").getInt("temp") - 273);
    } catch (JSONException e) {
      temp = "Temperature Not Found!";
    }
    return temp;
  }

  /**
   * Mengembalikan kecepatan angin kota yang telah dicari.
   * @return kecepatan angin
   */
  public String getWindSpeed() {
    String wind;
    try {
      wind = String.format("%.2f", getWeatherData().getJSONObject("wind").getFloat("speed"));
    } catch (JSONException e) {
      wind = "Wind Speed Not Found!";
    }
    return wind;
  }

  /**
   * Mengembalikan arah angin kota yang telah dicari.
   * @return arah angin
   */
  public int getWindDegree() {
    int windeg;
    try {
      windeg = getWeatherData().getJSONObject("wind").getInt("deg");
    } catch (JSONException e) {
      windeg = 0;
    }
    return windeg;
  }
}
