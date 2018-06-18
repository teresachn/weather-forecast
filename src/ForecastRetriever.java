import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class ForecastRetriever {
  private final String appidKey = "db51885724db8f9b34961a728fd29fda";
  public JSONObject forecastData;
  
  /***
   * Default Constructor
   */

  public ForecastRetriever() {
    forecastData = new JSONObject(getForecastRetriever());
  }

  public String getForecastRetriever() {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      URL apiOWmurl = 
          new URL("http://api.openweathermap.org/data/2.5/forecast?q=London&appid=" + appidKey);
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

  public JSONArray getJsonArrayForecast() {
    return forecastData.getJSONArray("list");
  }

  public static void main(String[] args) {
    ForecastRetriever test =  new ForecastRetriever();
    System.out.println(test.getJsonArrayForecast().toString(4));
  }
}
