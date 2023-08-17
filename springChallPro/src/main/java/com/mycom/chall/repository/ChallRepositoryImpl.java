package com.mycom.chall.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycom.chall.domain.ChallDTO;

//InterfaceMemberRepository의 구현클래스가 될 얘정
//public class MemberRepositoryImpl implements MemberRepository
//DAO역할을 하는 클래스. DB작업
//Controller->Service->DAO->myBatis->DB
@Repository
public class ChallRepositoryImpl implements ChallRepository {
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//생성자
	//메서드
	//회원수 조회
	@Override
	public int selectTotalChallCNT()  throws DataAccessException{
		int totalMemberCNT = (Integer)sqlSession.selectOne("chall.totalChallCNT");
		return totalMemberCNT;
	}
	
	//chall_no로 챌린지조회
	//파라미터 String memberid - 조회하고 싶은 회원의 id
	//리턴 MemberDTO- no,memberid,password,name,regdate,isshow
	@Override
	public ChallDTO selectChallByNo(int chall_no)  throws DataAccessException{
		ChallDTO challDTO=(ChallDTO)sqlSession.selectOne("chall.selectByNo",chall_no);
		return challDTO;
	}
	
	//목록조회
	/*리턴 List<HashMap<String,Object>>
	HashMap은 Key, Value를 필요로 한다.
	이 때 Key는 컬럼명, Value는 해당 컬럼의 값이다.
	예) 컬럼명 no,memberid,password,name,regdate,isshow
	예) 컬럼값 2, hongid, 1234, 홍GD, 2020-07-01 10:43:10,Y
	Key no에는 숫자타입2가 저장
	Key memberid에는 문자타입 hongid가 저장
	한명의 회원 정보는 HashMap저장.
	다수의 회원정보들이므로 List에 넣어줬다.*/
	/*	<select id="selectMemberList" resultType="hashmap">
		select no,memberid,password,name,regdate,isshow*/
	@Override
	public  List<HashMap<String,Object>> selectChallList()  throws DataAccessException{
		//sqlSession참조변수.메서드명("네임스페이스명.실행하려는id")
		 List<HashMap<String,Object>> challList = sqlSession.selectList("chall.selectChallList");
		 return challList;
	}
	
	//(update용)회원삭제
	//파라미터  String memberid-삭제하고 싶은 회원id
	//리턴 int - (update용)회원삭제 성공하면 1을 반환
	@Override
	public int deleteChall(int chall_no)  throws DataAccessException{
		int rowCnt = sqlSession.delete("chall.deleteChall",chall_no);
		//update가 적용된 row수를 반환
		//여기에서는 pk인 회원id로 업데이트되므로 성공하면 1을 반환
		return rowCnt;
	}
	
	//챌린지 등록
	//<insert id="insertMember" parameterType="com.mycom.member.domain.memberDTO">
	//파라미터 MemberDTO memberDTO-회원가입에 필요한 data
	//리턴 int - 입력성공시 1을 반환
	@Override
	public int insertChall(ChallDTO challDTO)  throws DataAccessException{
		return sqlSession.insert("chall.insertChall",challDTO);
		//입력성공시 1을 반환
	}
	
	//수정처리
	/*파라미터:form을 통해서 유저가 입력(선택)한 값 가져오기,(no,id),new이름,new비번 등
		회원번호의  key는 "no			회원id의  key는 "memberid"
		회원명의 key는 "name"		회원명의  key는 "password"*/
	//리턴 int - 수정성공시 1을 반환
	@Override
	public int updateChall(Map<String, Object> map)  throws DataAccessException{
		return sqlSession.update("chall.updateChall", map);
		//수정성공시 1을 반환
	}
	
}
