package com.mycom.chall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.chall.domain.ChallDTO;
import com.mycom.chall.domain.User;
import com.mycom.chall.service.ChallService;

//Controller->Service->DAO(repository)->myBatis->DB
@Controller
@RequestMapping("/chall")
public class ChallController {
	//필드
	@Autowired
	private ChallService challService;
	
/*	//생성자
	//메서드
	//전체회원수 조회
	//요청주소 http://localhost:8081/app/totalMember
	//get방식
	@RequestMapping("/totalMember")
	public void  getTotalMemberCNT(Model model) throws Exception {
		//1.파라미터받기
		//2.비지니스로직<->Service<->DAO(repository)<->myBatis<->DB
		int totalMemberCNT = challService.getTotalChallCNT();
		
		//3.Model
		model.addAttribute("totalMemberCNT",totalMemberCNT);
		System.out.println("전체회원수 totalMemberCNT:"+totalMemberCNT);
		//4.View->여기에서는 WEB-INF/views/member/totalMember.jsp 존재하지 않으므로 404에러발생
		//return "member/totalMember";
	}
		*/
	//chall_no로 챌린지조회
	//요청주소 http://localhost:8081/app/chall/getChall?chall_no=챌린지번호
	@RequestMapping("/getChall")
	public String getChallByNo(Model model,
																		@RequestParam("chall_no") int chall_no) throws Exception {
		//파라미터받기 - 회원id
		//String memberid=request.getParameter("mid");
		
		//2.비지니스로직<->Service<->DAO(Repository)<->myBatis<->DB
		ChallDTO challDTO = challService.getChallByNo(chall_no);
		System.out.println(challDTO);
		
		//3.Model
		model.addAttribute("challDTO",challDTO);
		//4.View
		return "/chall/challInfo";
	}

	//목록조회
	//요청주소 http://localhost:8081/app/chall/list
	//요청방식 get
	//view	 /WEB-INF/views/chall/list.jsp
	@RequestMapping("/list")
	public void getChallList(Model model) throws Exception {
		/*리턴 List<HashMap<String,Object>>
		HashMap은 Key, Value를 필요로 한다.
		이 때 Key는 컬럼명, Value는 해당 컬럼의 값이다.
		예) 컬럼명 no,memberid,password,name,regdate,isshow
		예) 컬럼값 2, hongid, 1234, 홍GD, 2020-07-01 10:43:10,Y
		Key no에는 숫자타입2가 저장
		Key memberid에는 문자타입 hongid가 저장
		한명의 회원 정보는 HashMap저장.
		다수의 회원정보들이므로 List에 넣어줬다.*/
		List<HashMap<String, Object>> challlist = challService.getChallList();
		model.addAttribute("challlist", challlist);
		
		//return "/chall/list";
	}
	
	//수정-수정폼보여주기요청=>get방식
	//요청주소 http://localhost:8081/app/chall/modify
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public ModelAndView modifyFormChall(ModelAndView mv,HttpSession session,@RequestParam("chall_no") int chall_no) throws Exception{
		//1.파라미터받기 mid=회원id
		//로그인한 회원의 id가 작성자와 일치하면 수정가능하다.
		//여기에서는 로그인했다고 가정하고 진행
		User user = new User( "hong", "홍길동","길동동");
		session.setAttribute("AUTH_USER", user);
	/*session.setAttribute("AUTH_USERID", "hongid");
		session.setAttribute("AUTH_USERNAME", "홍GD");
		session.setAttribute("AUTH_USER_NICKNAME", "의적");*/
		user = (User)session.getAttribute("AUTH_USER");//여기에서는 로그인한 user라고 가정하고 진행
		//int mem_no = user.getMem_no();
		//위의 코드를 아래와 같이 한 줄로 작성할 수 있다.
		//String memberid = ((User)session.getAttribute("AUTH_USER")).getId();
		
		//2.비지니스로직
		ChallDTO challDTO = challService.getChallByNo(chall_no);
		System.out.println(challDTO);
		
		//3.Model
		mv.addObject("challDTO",challDTO);
		
		//4.View
		mv.setViewName("/chall/modifyForm");
		return mv;
	}

	//수정처리=>post방식
	//요청주소 http://localhost:8081/app/chall/modify
/*memberDTO로 받았을 때
 	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public void modifyMember(MemberDTO memberDTO){
			//1.파라미터받기 - form을 통해서 유저가 입력(선택)한 값 가져오기,(no,id),new이름,new비번 등
			System.out.println(memberDTO);
			
			//2.비지니스로직
			//3.Model
			//4.View
	}*/
	//Map으로 받았을 때
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public ModelAndView modifyChall(@RequestParam Map<String,Object> map,ModelAndView mv) throws Exception{
		//1.파라미터받기 - form을 통해서 유저가 입력(선택)한 값 가져오기,(no,id),new이름,new비번 등
		System.out.println("map.get(cate_no):"+map.get("cate_no"));
		System.out.println("map.get(chall_title):"+map.get("chall_title"));
		System.out.println("map.get(chall_con):"+map.get("chall_con"));
		System.out.println("map.get(certifi_words):"+map.get("certifi_words"));
		System.out.println("map.get(chall_no):"+map.get("chall_no"));
		
		//2.비지니스로직
		/*파라미터:form을 통해서 유저가 입력(선택)한 값 가져오기,(no,id),new이름,new비번 등
		회원번호의  key는 "no			회원id의  key는 "memberid"
		회원명의 key는 "name"		회원명의  key는 "password"*/
		//리턴 int - 수정성공시 1을 반환
		int resultInt = challService.modifyChall(map);
		
		//3.Model
		//4.View
		if(resultInt==1) {//수정성공시 회원목록페이지로 이동
			mv.setViewName("redirect:/chall/list");
		}else{//수정성공시 수정폼 페이지로 이동
			mv.setViewName("redirect:/chall/modify");
		}
		return mv;
	}
	
	//삭제
	//요청주소 http://localhost:8081/app/chall/delete?chall_no=챌린지번호
	@RequestMapping("/delete")
	public ModelAndView deleteChall(ModelAndView mv,
									@RequestParam("chall_no") int chall_no) throws Exception  {
		//1.파라미터받기 mid=회원id
		//2.비지니스로직
		//파라미터  String mid-삭제하고 싶은 회원id
		//리턴 int - (update용)회원삭제 성공하면 1을 반환
		int rowCnt = challService.deleteChall(chall_no);
		
		//3.Model
		//4.View
		if(rowCnt!=1) {//삭제실패시 상세페이지로 이동
			mv.setViewName("redirect:/chall/getChall?chall_no"+chall_no);
		}else{//삭제성공시 목록페이지로 이동
			mv.setViewName("redirect:/chall/list");
		}
		return mv;
	}
		
	//등록-챌린지 등록을 위한 폼보여줘 요청
	//요청주소 http://localhost:8081/app/chall/write
	//요청방식 get
	//view	/WEB-INF/views/member/join.jsp
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public void writeForm(){
		//1.파라미터받기
		//2.비지니스로직
		//3.Model
		//4.View
	}

	//챌린지등록 처리
	//요청주소 http://localhost:8081/app/chall/write
	//요청방식 post
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public ModelAndView write(ModelAndView mv,ChallDTO challDTO) throws Exception{
		//1.파라미터받기 - form을 통해서 유저가 입력(선택)한 값 가져오기,id,이름,비번 등
		System.out.println(challDTO);
		
		//2.비지니스로직
		//파라미터 MemberDTO memberDTO-회원가입에 필요한 data
		//리턴 int - 입력성공시 1을 반환
		int insertedRows = challService.insertChall(challDTO);
		
		//3.Model
		//4.View
		if(insertedRows==1) {//회원가입성공시 회원목록페이지로 이동
			mv.setViewName("redirect:/chall/write");
		}else{//회원가입실패시 가입폼 페이지로 이동
			mv.setViewName("redirect:/chall/join");
		}
		return mv;
	}
	
}
