package com.wideshot.alimtalk.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wideshot.alimtalk.Application;
import com.wideshot.alimtalk.dao.Weather1Mapper;
import com.wideshot.alimtalk.dao2.Weather2Mapper;
import com.wideshot.alimtalk.model.WeatherVO;

@Service
public class ApiService {
	private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
	
	String url = "http://api.openweathermap.org/data/2.5/weather";
	String key = "b6bf47d494802fc5a07ee14239b32df1";
	String city = "";
	
	@Autowired
	Weather1Mapper weather1Mapper;
	
	@Autowired
	Weather2Mapper weather2Mapper;
	
	RestTemplate restTemplate;
	
	public String getAPI(String city) {
		this.city = city;
		
		String apiUrl = url + "?q=" + city + "&appid=" + key;
		
		restTemplate = new RestTemplate();
		
		String json = restTemplate.getForObject(apiUrl, String.class);
		
		System.out.println(json);
		
		return json;
	}
	
	public WeatherVO parsing(String json) {
		WeatherVO vo = new WeatherVO();
		
		JsonParser parser = new JsonParser();
		JsonObject jsonObj = (JsonObject) parser.parse(json);
		System.out.println("obj= " + jsonObj);
		
		JsonObject coord = (JsonObject) jsonObj.get("coord");
		System.out.println("coord= " + coord);
		
		JsonElement lon = coord.get("lon");
		JsonElement lat = coord.get("lat");
		System.out.println("lon= " + lon + ", lat= " + lat);
		
		JsonArray weather = (JsonArray) jsonObj.get("weather");
		JsonObject weatherObj = (JsonObject) weather.get(0);
		System.out.println("weather obj= " + weatherObj);
		
		JsonElement curWeather = weatherObj.get("main");
		JsonElement description = weatherObj.get("description");
		
		JsonObject main = (JsonObject) jsonObj.get("main");
		System.out.println("main= " + main);
		
		double temp = Double.parseDouble(main.get("temp").getAsString()) - 273.15;
		double feelTemp = Double.parseDouble(main.get("feels_like").getAsString()) - 273.15;
		JsonElement humidity = main.get("humidity");
		
		JsonObject sys = (JsonObject) jsonObj.get("sys");
		System.out.println("sys= " + sys);
		
		JsonElement country = sys.get("country");
		
		JsonElement city = jsonObj.get("name");
		System.out.println("city= " + city);
		
		logger.info("coord= " + coord);
		
		vo.setTempLon(lon.getAsString());
		vo.setTempLat(lat.getAsString());
		vo.setCurWeather(curWeather.getAsString());
		vo.setDescription(description.getAsString());
		vo.setCurTemp(String.valueOf(temp));
		vo.setFeelTemp(String.valueOf(feelTemp));
		vo.setCurHumidity(humidity.getAsString());
		vo.setCountry(country.getAsString());
		vo.setCity(city.getAsString());
		
		return vo;
	}
}
