package test.java.com.insurance.integration.cc.client;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.Test;

import main.java.com.insurance.integration.cc.client.WeatherServiceClient;
import main.java.com.insurance.integration.domain.gen.weatherService.WeatherReturn;
import main.java.com.insurance.integration.domain.gen.weatherService.WeatherSoap;
 public class WeatherServiceClientTest {

	@Test
	public void testGetCityWeatherByZIP() {
		WeatherServiceClient clientSpy = spy(new WeatherServiceClient());
	    WeatherSoap mockWeatherService = mock(WeatherSoap.class);
	 	WeatherReturn mockResult = mock(WeatherReturn.class);
		when(mockResult.getDescription()).thenReturn("Cloudy");
		when(mockResult.getCity()).thenReturn("San Francisco");
		when(mockWeatherService.getCityWeatherByZIP("94101")).thenReturn(mockResult);
		doReturn(mockWeatherService).when(clientSpy).getWeatherService(); 
		doReturn(mockResult).when(mockWeatherService).getCityWeatherByZIP("94101");
        WeatherReturn result = clientSpy.getCityWeatherByZIP("94101");
		assertEquals("Cloudy",result.getDescription()); 
	} 
}
