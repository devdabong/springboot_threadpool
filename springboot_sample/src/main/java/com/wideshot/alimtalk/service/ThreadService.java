package com.wideshot.alimtalk.service;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.wideshot.alimtalk.model.WeatherVO;

@Service
public class ThreadService {
	
	private static final Logger logger = LoggerFactory.getLogger(ThreadService.class);
	
	@Autowired
	@Qualifier("threadPoolTaskExecutor")
	private Executor threadPoolTaskExecutor;
	
	@Autowired
	ApiService apiService;
	
	@Autowired
	WeatherService weatherService;
	
	@Async
	public void test() {
		logger.info(Thread.currentThread().getName() + " 쓰레드 작업 시작");
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 
        logger.info(Thread.currentThread().getName() + " 쓰레드 작업 종료!");
	}
	
	@Async
	public void insertWeather(WeatherVO vo) {
		boolean result = weatherService.insertWeather(vo);
			
		if(result) {
			boolean result2 = weatherService.insertWeather2(vo);
			
			if(result2) {
				//성공
				logger.info("data insert success");
			} else {
				//DB2 insert 실패
				logger.error("[DB1] data insert success , [DB2] data insert fail");
			}
				
		} else {
			//DB1 insert 실패
			logger.error("[DB1] data insert fail");
		}
		
	}

	@Async
	public void updateWeather(WeatherVO vo) {
		logger.info(Thread.currentThread().getName() + " 쓰레드 작업 시작");
		boolean result = weatherService.updateWeather1(vo);
			
		if(result) {
			boolean result2 = weatherService.updateWeather2(vo);
			
			if(result2) {
				//성공
				logger.info("data update success");
				logger.info(vo.toString());
			} else {
				//DB2 insert 실패
				logger.error("[DB1] data update success , [DB2] data update fail");
				logger.info(vo.toString());
			}
				
		} else {
			//DB1 insert 실패
			logger.error("[DB1] data update fail");
			logger.info(vo.toString());
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info(Thread.currentThread().getName() + " 쓰레드 작업 종료!");
	}
	
	public void process(String city) {
		String json = apiService.getAPI(city);
		WeatherVO vo = apiService.parsing(json);
		
		insertWeather(vo);
	}
	
	@Async
	public void totalProcess(WeatherVO vo) {
		logger.info(Thread.currentThread().getName() + " 쓰레드 작업 시작");
		String json = apiService.getAPI(vo.getCity());
		WeatherVO getVo = apiService.parsing(json);
		
		boolean result = weatherService.updateWeather1(getVo);
			
		if(result) {
			boolean result2 = weatherService.updateWeather2(getVo);
			
			if(result2) {
				//성공
				logger.info("data update success");
				logger.info(getVo.toString());
			} else {
				//DB2 insert 실패
				logger.error("[DB1] data update success , [DB2] data update fail");
				logger.info(getVo.toString());
			}
				
		} else {
			//DB1 insert 실패
			logger.error("[DB1] data update fail");
			logger.info(getVo.toString());
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.info(Thread.currentThread().getName() + " 쓰레드 작업 종료!");
	}
	
}
