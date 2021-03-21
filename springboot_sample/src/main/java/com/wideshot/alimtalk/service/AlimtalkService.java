package com.wideshot.alimtalk.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wideshot.alimtalk.dao.Service1Mapper;
import com.wideshot.alimtalk.dao2.Service2Mapper;
import com.wideshot.alimtalk.model.AllimTalkTemplateVO;


@Service
public class AlimtalkService {
	
	@Autowired
	Service1Mapper service1Mapper;
	
	@Autowired
	Service2Mapper service2Mapper;
	
	public List<AllimTalkTemplateVO> test() {
		System.out.println("test()!");
		
		List<AllimTalkTemplateVO> list = service1Mapper.selectTemplateApiList();
		
		return list;
	}
}
