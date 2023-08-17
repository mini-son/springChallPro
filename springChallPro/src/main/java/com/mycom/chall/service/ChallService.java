package com.mycom.chall.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycom.chall.domain.ChallDTO;

public interface ChallService {

	//회원수 조회
	public int getTotalChallCNT() throws Exception;
	
	//chall_no로 챌린지조회
	public ChallDTO getChallByNo(int chall_no)throws Exception;
	
	//목록조회
	public  List<HashMap<String,Object>> getChallList() throws Exception;
	
	//삭제
	public int deleteChall(int chall_no) throws Exception;
	
	//회원가입
	public int insertChall(ChallDTO challDTO) throws Exception;
	
	//수정처리
	public int modifyChall(Map<String, Object> map)  throws Exception;
}
