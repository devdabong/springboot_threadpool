package com.wideshot.alimtalk;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.wideshot.alimtalk.model.WeatherVO;
import com.wideshot.alimtalk.service.AlimtalkService;
import com.wideshot.alimtalk.service.ApiService;
import com.wideshot.alimtalk.service.ThreadService;
import com.wideshot.alimtalk.service.WeatherService;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	@Autowired
	AlimtalkService alimtalkService;

	@Autowired
	WeatherService weatherService;

	@Autowired
	ApiService apiService;
	
	@Autowired
	ThreadService threadService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("count= " + alimtalkService.test());
		System.out.println("hello world");

		logger.trace("Trace Level 테스트");
		logger.debug("DEBUG Level 테스트");
		logger.info("INFO Level 테스트");
		logger.warn("Warn Level 테스트");
		logger.error("ERROR Level 테스트");
		
		// 테스트용 샘플 데이터 DB insert
		//initDB();
		
		// 1. DB 조회 (승인 건만)
		// - 리스트에 조회한 DB 데이터를 담아.
		List<WeatherVO> list = getList();
		
		logger.info(list.toString());
		
		// 2. API 호출 (성공 : DB update, 실패 : 파일 로그)
		// FOR 문으로 API 호출 후 바로 DB update
		for (int i = 0; i < list.size(); i++) {
			threadService.totalProcess(list.get(i));
			
//			String json = apiService.getAPI(list.get(i).getCity());
//			WeatherVO vo = apiService.parsing(json);
//			
//			threadService.updateWeather(vo);
		}
		
	}
	
	public void initDB() {
		List<WeatherVO> weatherList = new ArrayList<WeatherVO>();
		
		List<String> list = new ArrayList<String>();
		list.add(0, "Seoul");
		list.add(1, "김포시");	
		list.add(2, "시흥시");	
		list.add(3, "광명시");
		list.add(4, "부산광역시");
		list.add(5, "포항시");
		list.add(6, "강서구");
		list.add(7, "강남구");
		list.add(8, "강동구");
		list.add(9, "춘천시");
		list.add(10, "강릉시");
		list.add(11, "공주시");
		list.add(12, "청주시");
		list.add(13, "천안시");
		
		for (int i = 0; i < list.size(); i++) {
			threadService.process(list.get(i));
		}
	}
	
	public List<WeatherVO> getList() {
		return weatherService.selectWeatherList();
	}
}
