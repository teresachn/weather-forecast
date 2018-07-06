import weatherpack.CityFinder;

import static org.junit.Assert.*;

import org.junit.Test;

public class CityFinderTest {

  /**
   * Test method for {@link CityFinder#CityFinder()}
   */
  @Test
  public void testCityFinder() {
    CityFinder test = new CityFinder();
    assertNotNull(test.getJsonCityData());
  }
  
  /**
   * Test method for {@link CityFinder#loadCityData()}
   */
  @Test
  public void testLoadCityData() {
  	CityFinder test = new CityFinder();
    assertNotNull(test.loadCityData());
  }
  
  /**
   * Test method for {@link CityFinder#getJsonCityData()}
   */
  @Test
  public void testGetJsonCityData() {
    CityFinder test = new CityFinder();
    assertNotNull(test.getJsonCityData());
  }
  
  /**
   * Test method for {@link CityFinder#findCity(String)}
   */
  @Test
  public void testFindCity() {
  	CityFinder test = new CityFinder();
  	assertEquals(test.findCity("Pekanbaru").length(), 1);
  }

}
