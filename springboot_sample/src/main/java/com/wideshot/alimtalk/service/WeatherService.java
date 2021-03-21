package com.wideshot.alimtalk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wideshot.alimtalk.dao.Weather1Mapper;
import com.wideshot.alimtalk.dao2.Weather2Mapper;
import com.wideshot.alimtalk.model.WeatherVO;

@Service
public class WeatherService {
	
	String url = "http://api.openweathermap.org/data/2.5/weather?q=Seoul&appid=b6bf47d494802fc5a07ee14239b32df1";
	String key = "b6bf47d494802fc5a07ee14239b32df1";
	
	@Autowired
	Weather1Mapper weather1Mapper;
	
	@Autowired
	Weather2Mapper weather2Mapper;
	
	
	public List<WeatherVO> selectWeatherList() {
		
		List<WeatherVO> list = weather1Mapper.selectWeatherList();
		
		return list;
	}
	
	public boolean insertWeather(WeatherVO vo) {
		try {
			weather1Mapper.insertWeather(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean insertWeather2(WeatherVO vo) {
		try {
			weather2Mapper.insertWeather(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean updateWeather1(WeatherVO vo) {
		try {
			weather1Mapper.updateWeatherInfo(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean updateWeather2(WeatherVO vo) {
		try {
			weather2Mapper.updateWeatherInfo(vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}
