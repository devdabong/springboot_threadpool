package com.wideshot.alimtalk.dao2;

import java.util.List;

import com.wideshot.alimtalk.model.WeatherVO;

public interface Weather2Mapper {
	
	/**
	 * 날씨DB 리스트 전체 조회
	 * @return
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
