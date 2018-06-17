import java.io.BufferedReader;
import java.io.IOException;
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
  private String weatherData;

  public WeatherRetriever() {
    
    try {
      URL apiOWMurl = new URL("http://api.openweathermap.org/data/2.5/weather?q=London&appid=" + appidKey);
      HttpURLConnection httpConnection = (HttpURLConnection) apiOWMurl.openConnection();
      httpConnection.setUseCaches(false);
      httpConnection.connect();

      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
      String streamInputString;
      while ((streamInputString = bufferedReader.readLine()) != null) {
        weatherData = streamInputString;
      }
      bufferedReader.close();
    } catch (IOException e) {
      response = "Service not available!";
    } 
  }

  public String getWeatherData() {
    return weatherData;
  }

  public String getTemperature() {
    String temp;
    try {
      JSONObject json = new JSONObject(weatherData);
      temp = Float.toString(json.getJSONObject("main").getFloat("temp"));
    } catch (JSONException e) {
      temp = "Temperature Not Found!";
    }
    return temp;
  }

  public String getPressure() {
    String press;
    try {
      JSONObject json = new JSONObject(weatherData);
      press = Float.toString(json.getJSONObject("main").getFloat("pressure"));
    } catch (JSONException e) {
      press = "Pressure Not Found!";
    }
    return press;
  }

  public String getHumidity() {
    String hum;
    try {
      JSONObject json = new JSONObject(weatherData);
      hum = Float.toString(json.getJSONObject("main").getFloat("humidity"));
    } catch (JSONException e) {
      hum = "Humidity Not Found!";
    }
    return hum;
  }

  public String getWindSpeed() {
    String wind;
    try {
      JSONObject json = new JSONObject(weatherData);
      wind = Float.toString(json.getJSONObject("wind").getFloat("speed"));
    } catch (JSONException e) {
      wind = "Wind Speed Not Found!";
    }
    return wind;
  }

  public static void main(String[] args) {
    WeatherRetriever test =  new WeatherRetriever();
    System.out.println(test.getTemperature());
    System.out.println(test.getPressure());
    System.out.println(test.getHumidity());
    System.out.println(test.getWindSpeed());
  }
}
