package com.wideshot.alimtalk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wideshot.alimtalk.model.AllimTalkTemplateVO;
import com.wideshot.alimtalk.service.AlimtalkService;

@Controller
public @ResponseBody class AlimtalkController {

	@Autowired
	AlimtalkService alimtalkService;
	
	@RequestMapping("/test")
	public String test() {
		List<AllimTalkTemplateVO> list = alimtalkService.test();
		
		System.out.println(list);
		
		return "test";
	}
}
