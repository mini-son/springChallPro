package com.mycom.chall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mycom.chall.domain.ChallDTO;

public interface ChallRepository {
	
	//회원수조회
	public int selectTotalChallCNT() throws DataAccessException;

	//chall_no로 챌린지조회
	public ChallDTO selectChallByNo(int chall_no) throws DataAccessException;
	
	//목록조회
	public  List<HashMap<String,Object>> selectChallList() throws DataAccessException;
	
	//(update용)회원삭제
	public int deleteChall(int chall_no) throws DataAccessException;
	
	//회원가입
	public int insertChall(ChallDTO challDTO) throws DataAccessException;
	
	//수정처리
	public int updateChall(Map<String, Object> map) throws DataAccessException;
	
}
