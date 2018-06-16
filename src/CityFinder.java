import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class CityFinder {

  /*
  How to compile this file:
  javac -cp json-20180130.jar CityFinder.java
  java -cp json-20180130.jar;. CityFinder
  */

  public JSONArray jsonCityData;
  
  public CityFinder() {
    jsonCityData = new JSONArray(loadCityData());
    System.out.println(jsonCityData.toString(4));
  }

  public String loadCityData() {
    StringBuilder stringBuilder = new StringBuilder();
    try {
      File fileInput = new File("city.list.json");
      InputStream inputStream = new FileInputStream(fileInput);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        stringBuilder.append(line);
      }
      bufferedReader.close();
      System.out.println("yay!");
      return stringBuilder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  

  public static void main(String[] args) {
    CityFinder test = new CityFinder();
  }
}