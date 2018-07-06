package weatherpack;

import static org.junit.Assert.*;

import org.junit.Test;

public class WeatherRetrieverTest {

	/**
	 * Test for method {@link WeatherRetriever#WeatherRetriever(String)}
	 */
	@Test
	public void testWeatherRetriever() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertEquals(test.getCity(), "Pekanbaru");
		assertEquals(test.getCountry(), "ID");
	}
	
	/**
	 * Test for method {@link WeatherRetriever#buildWeatherData(String)}
	 */
	@Test
	public void testBuildWeatherData() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotNull(test.buildWeatherData("1631761"));
	}
	
	/**
	 * Test for method {@link WeatherRetriever#getWeatherData()}
	 */
	@Test
	public void testGetWeatherData() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotNull(test.getWeatherData());
	}
	
	/**
	 * Test for method {@link WeatherRetriever#getCity()}
	 */
	@Test
	public void testGetCity() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotEquals(test.getCity(), "City Not Found!");
	}
	
	/**
	 * Test for method {@link WeatherRetriever#getCountry()}
	 */
	@Test
	public void testGetCountry() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotEquals(test.getCountry(), "Country Not Found!");
	}
	
	/**
	 * Test for method {@link WeatherRetriever#getDescription()}
	 */
	@Test
	public void testGetDescription() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotEquals(test.getDescription(), "Description Not Found!");
	}
	
	/**
	 * Test for method {@link WeatherRetriever#getHumidity()}
	 */
	@Test
	public void testGetHumidity() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotEquals(test.getHumidity(), "Humidity Not Found!");
	}

	/**
	 * Test for method {@link WeatherRetriever#getIcon()}
	 */
	@Test
	public void testGetIcon() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotEquals(test.getIcon(), "Image Not Found!");
	}
	
	/**
	 * Test for method {@link WeatherRetriever#getPressure()}
	 */
	@Test
	public void testGetPressure() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotEquals(test.getPressure(), "Pressure Not Found!");
	}
	
	/**
	 * Test for method {@link WeatherRetriever#getTemperature()}
	 */
	@Test
	public void testGetTemperature() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotEquals(test.getTemperature(), "Temperature Not Found!");
	}
	
	/**
	 * Test for method {@link WeatherRetriever#getWindSpeed()}
	 */
	@Test
	public void testGetWindSpeed() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotEquals(test.getWindSpeed(), "Wind Speed Not Found!");
	}
	
	/**
	 * Test for method {@link WeatherRetriever#getWindDegree()}
	 */
	@Test
	public void testGetWindDegree() {
		WeatherRetriever test = new WeatherRetriever("1631761");
		assertNotEquals(test.getWindDegree(), 0);
	}
}
