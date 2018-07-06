import weatherpack.ForecastRetriever;

import static org.junit.Assert.*;

import org.junit.Test;

public class ForecastRetrieverTest {

	/**
	 * Test method for {@link ForecastRetriever#ForecastRetriever(String)}
	 */
	@Test
	public void testForecastRetriever() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertEquals(test.getCityName(), "Pekanbaru");
		assertEquals(test.getCountry(), "ID");
		assertEquals(test.getLat(), "0.5333");
		assertEquals(test.getLon(), "101.45");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getForecastRetriever()}
	 */
	@Test
	public void testGetForecastRetriever() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotNull(test.getForecastRetriever("1631761"));
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getCityName()}
	 */
	@Test
	public void testGetCityName() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getCityName(), "Name not found!");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getCountry()}
	 */
	@Test
	public void testGetCountry() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getCountry(), "Country not found!");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getLon()}
	 */
	@Test
	public void testGetLon() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getLon(), "Longitude not found!");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getLat()}
	 */
	@Test
	public void testGetLat() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getLat(), "Latitude not found!");
	}

	/**
	 * Test method for {@link ForecastRetriever#getForecastTime(int)}
	 */
	@Test
	public void testGetForecastTime() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getForecastTime(0), "Date not found!");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getIcon(int)}
	 */
	@Test
	public void testGetIcon() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getIcon(0), "Image not found!");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getTemperature(int)}
	 */
	@Test
	public void testGetTemperature() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getTemperature(0), "Temperature not found!");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getHumidity(int)}
	 */
	@Test
	public void testGetHumidity() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getHumidity(0), "Humidity not found!");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getPressure(int)}
	 */
	@Test
	public void testGetPressure() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getPressure(0), "Pressure not found!");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getWindSpeed(int)}
	 */
	@Test
	public void testGetWindSpeed() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getWindSpeed(0), "Wind Speed not found!");
	}
	
	/**
	 * Test method for {@link ForecastRetriever#getWindDegree(int)}
	 */
	@Test
	public void testGetWindDegree() {
		ForecastRetriever test = new ForecastRetriever("1631761");
		assertNotEquals(test.getWindDegree(0), 0);
	}
}
