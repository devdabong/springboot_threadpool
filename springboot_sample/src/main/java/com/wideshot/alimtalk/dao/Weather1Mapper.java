package com.wideshot.alimtalk.dao;

import java.util.List;

import com.wideshot.alimtalk.model.WeatherVO;

public interface Weather1Mapper {
	
	/**
	 * 날씨DB 리스트 전체 조회
	 * @return List<WeatherVO>
	 */
	List<WeatherVO> selectWeatherList();
	
	
	/**
	 * 날씨 insert
	 * 
	 */
	void insertWeather(WeatherVO vo);
	
	/**
	 * update
	 * 
	 */
	void updateWeatherInfo(WeatherVO vo);
}
