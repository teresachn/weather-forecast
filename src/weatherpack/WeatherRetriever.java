package weatherpack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherRetriever {

  /*
  How to compile this file:
  javac -cp json-20180130.jar WeatherRetriever.java
  java -cp json-20180130.jar;. WeatherRetriever
  */

  private final String appidKey = "db51885724db8f9b34961a728fd29fda";
  private JSONObject weatherData;

  public WeatherRetriever(String city) {
    weatherData = new JSONObject(buildWeatherData(city));
  }

  public String buildWeatherData(String cityName) {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      URL apiOWmurl = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&appid=" + appidKey);
      HttpURLConnection httpConnection = (HttpURLConnection) apiOWmurl.openConnection();
      httpConnection.setUseCaches(false);
      httpConnection.connect();
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
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

  public JSONObject getWeatherData() {
    return weatherData;
  }

  public String getCity() {
    String city;
    try {
      city = weatherData.getString("name");
    } catch (JSONException e) {
      city = "City Not Found!";
    }
    return city;
  }

  public String getCountry() {
    String country;
    try {
      country = weatherData.getJSONObject("sys").getString("country");
    } catch (JSONException e) {
      country = "Country Not Found!";
    }
    return country;
  }


  public String getDescription() {
    String desc;
    try {
      desc = weatherData.getJSONArray("weather").getJSONObject(0).getString("description");
    } catch (JSONException e) {
      desc = "Description Not Found!";
    }
    return desc;
  }

  public String getHumidity() {
    String hum;
    try {
      hum = Float.toString(weatherData.getJSONObject("main").getFloat("humidity"));
    } catch (JSONException e) {
      hum = "Humidity Not Found!";
    }
    return hum;
  }

  public String getIcon() {
    String name;
    try {
      name = weatherData.getJSONArray("weather").getJSONObject(0).getString("icon");
    } catch (JSONException e) {
      name = "Image Not Found!";
    }
    return name;
  }

  public String getPressure() {
    String press;
    try {
      press = Float.toString(weatherData.getJSONObject("main").getFloat("pressure"));
    } catch (JSONException e) {
      press = "Pressure Not Found!";
    }
    return press;
  }

  public String getTemperature() {
    String temp;
    try {
      temp = Float.toString(weatherData.getJSONObject("main").getFloat("temp"));
    } catch (JSONException e) {
      temp = "Temperature Not Found!";
    }
    return temp;
  }

  public String getWindSpeed() {
    String wind;
    try {
      wind = Float.toString(weatherData.getJSONObject("wind").getFloat("speed"));
    } catch (JSONException e) {
      wind = "Wind Speed Not Found!";
    }
    return wind;
  }
}
