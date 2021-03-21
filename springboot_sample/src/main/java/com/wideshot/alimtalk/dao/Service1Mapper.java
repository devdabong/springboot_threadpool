package com.wideshot.alimtalk.dao;

import java.util.List;

import com.wideshot.alimtalk.model.AllimTalkTemplateVO;

public interface Service1Mapper {
	
	/**
	 * 템플릿 카테고리 코드 없는 데이터 개수 조회
	 * 
	 * @return
	 */
	Integer selectTemplateApiExceptCount();
	
	/**
	 * 템플릿 카테고리 코드 없는 템플릿 목록
	 * 
	 * @return
	 */
	List<AllimTalkTemplateVO> selectTemplateApiExceptList();
	
	/**
	 * 카카오 API 템플릿 조회할 리스트
	 * 
	 * @return
	 */
	List<AllimTalkTemplateVO> selectTemplateApiList();
	
	/**
	 * 템플릿 카테고리 코드 업데이트
	 * 
	 * @param AllimTalkTemplateVO
	 */
	void updateTemplateCategoryCode(AllimTalkTemplateVO template);
}
