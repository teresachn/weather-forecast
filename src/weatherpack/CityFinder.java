package weatherpack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class CityFinder {

  private JSONArray jsonCityData;
  
  /**
   * Default constructor CityFinder.
   */
  public CityFinder() {
    jsonCityData = new JSONArray(loadCityData());
  }

  /**
   * Method untuk memuat data kota ke dalam memory.
   * @return String json dari city.list.json
   */
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
      return stringBuilder.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Method untuk mengembalikan atribut jsonCityData.
   * @return jsonCityData
   */
  public JSONArray getJsonCityData() {
    return jsonCityData;
  }

  /**
   * Method untuk mencari kota yang memiliki substring city.
   * @param city Kota yang dicari
   * @return JSONArray berisi JSONObject dengan nama kota memiliki substring city
   */
  public JSONArray findCity(String city) {
    JSONArray citySameName = new JSONArray();
    for (int i = 0; i < jsonCityData.length(); i++) {
      JSONObject oneCity = jsonCityData.getJSONObject(i);
      if (oneCity.getString("name").contains(city)) {
        citySameName = citySameName.put(oneCity);
      }
    }
    return citySameName;
  }
}