package weatherpack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ForecastRetriever {
  private final String appidKey = "db51885724db8f9b34961a728fd29fda";
  public JSONObject forecastData;
  
  /**
   * Default Constructor.
   */

  public ForecastRetriever(String cityId) {
    forecastData = new JSONObject(getForecastRetriever(cityId));
  }

  /**
   * Membuat string dari hasil panggilan API untuk digunakan dalam membuat JSONObject.
   * @param cityId Id kota untuk dipakai di API
   * @return String yang bisa membentuk JSONObject
   */
  public String getForecastRetriever(String cityId) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      URL apiOWmurl = 
          new URL("http://api.openweathermap.org/data/2.5/forecast?id=" + cityId + "&appid=" + appidKey);
      HttpURLConnection httpConnection = (HttpURLConnection) apiOWmurl.openConnection();
      httpConnection.setUseCaches(false);
      httpConnection.connect();
      BufferedReader bufferedReader = 
          new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
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
   * Mengembalikan list dalam forecastData.
   * @return List ramalan cuaca dalam bentuk JSONArray
   */
  public JSONArray getJsonArrayForecast() {
    return forecastData.getJSONArray("list");
  }

  /**
   * Mengembalikan nama kota yang dicari.
   * @return nama kota
   */
  public String getCityName() {
    String name;
    try {
      name = forecastData.getJSONObject("city").getString("name");
    } catch (JSONException e) {
      name = "Name not found!";
    }
    return name;
  }

  /**
   * Mengembalikan negara dari kota yang dicari.
   * @return negara dari kota yang dicari
   */
  public String getCountry() {
    String name;
    try {
      name = forecastData.getJSONObject("city").getString("country");
    } catch (JSONException e) {
      name = "Country not found!";
    }
    return name;
  }

  /**
   * Mengembalikan longitude dari kota yang dicari.
   * @return longitude kota
   */
  public String getLon() {
    String longitude;
    try {
      longitude = Double.toString(
          forecastData.getJSONObject("city").getJSONObject("coord").getDouble("lon"));
    } catch (JSONException e) {
      longitude = "Longitude not found";
    }
    return longitude;
  }

  /**
   * Mengembalikan latitude dari kota yang dicari.
   * @return latitude kota
   */
  public String getLat() {
    String latitude;
    try {
      latitude = Double.toString(
          forecastData.getJSONObject("city").getJSONObject("coord").getDouble("lat"));
    } catch (JSONException e) {
      latitude = "Latitude not found";
    }
    return latitude;
  }

  /**
   * Mengembalikan waktu ramalan cuaca dari kota yang dicari.
   * @return waktu ramalan cuaca
   */
  public String getForecastTime(int i) {
    String time;
    try {
      time = getJsonArrayForecast().getJSONObject(i).getString("dt_txt");
    } catch (JSONException e) {
      time = "Date not found";
    }
    return time;
  }

  /**
   * Mengembalikan nama icon cuaca dari kota yang dicari.
   * @return nama icon cuaca
   */
  public String getIcon(int i) {
    String name;
    try {
      name = getJsonArrayForecast().getJSONObject(i)
          .getJSONArray("weather").getJSONObject(0).getString("icon");
    } catch (JSONException e) {
      name = "Image Not Found!";
    }
    return name;
  }

  /**
   * Mengembalikan ramalan suhu kota yang dicari.
   * @return ramalan suhu
   */
  public String getTemperature(int i) {
    String temp;
    try {
      temp = String.format("%.2f",
          getJsonArrayForecast().getJSONObject(i).getJSONObject("main").getFloat("temp") - 273);
    } catch (JSONException e) {
      temp = "Temperature not found";
    }
    return temp;
  }

  /**
   * Mengembalikan ramalan kelembapan dari kota yang dicari.
   * @return ramalan kelembapan
   */
  public String getHumidity(int i) {
    String humi;
    try {
      humi = Double.toString(
          getJsonArrayForecast().getJSONObject(i).getJSONObject("main").getDouble("humidity"));
    } catch (JSONException e) {
      humi = "Humidity not found";
    }
    return humi;
  }

  /**
   * Mengembalikan ramalan tekanan dari kota yang dicari.
   * @return ramalan tekanan
   */
  public String getPressure(int i) {
    String press;
    try {
      press = Double.toString(
          getJsonArrayForecast().getJSONObject(i).getJSONObject("main").getDouble("pressure"));
    } catch (JSONException e) {
      press = "Pressure not found";
    }
    return press;
  }

  /**
   * Mengembalikan ramalan kecepatan angin dari kota yang dicari.
   * @return ramalan kecepatan angin
   */
  public String getWindSpeed(int i) {
    String wind;
    try {
      wind = Double.toString(
          getJsonArrayForecast().getJSONObject(i).getJSONObject("wind").getDouble("speed"));
    } catch (JSONException e) {
      wind = "Wind Speed not found";
    }
    return wind;
  }

  /**
   * Mengembalikan ramalan arah angin dari kota yang dicari.
   * @return ramalan arah angin
   */
  public int getWindDegree(int i) {
    int wind;
    try {
      wind = getJsonArrayForecast().getJSONObject(i).getJSONObject("wind").getInt("deg");
    } catch (JSONException e) {
      wind = 0;
    }
    return wind;
  }
}
