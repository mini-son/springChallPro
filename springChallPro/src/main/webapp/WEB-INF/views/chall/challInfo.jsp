<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>challInfo.jsp</h1>
	<%-- model.addAttribute("memberDTO",memberDTO);--%>
	challDTO=${challDTO}<hr/>
	  <table id="challTable" border="1">
    <tbody>   
      <tr>
        <th>글번호</th><td>${challDTO.chall_no}</td>
      </tr>
      <tr>
        <th>챌린지 제목</th><td>${challDTO.chall_title}</td>
      </tr>
      <tr>
        <th>카테고리명</th><td>${challDTO.cate_name}</td>
      </tr>
      <tr>
        <th>작성자 닉네임</th><td>${challDTO.nickname}</td>
      </tr>
      <tr>
        <th>작성일</th><td>${challDTO.chall_write_date}</td>
      </tr>
      <tr>
        <th>내용</th><td>${challDTO.chall_con}</td>
      </tr>
      <tr>
        <th>인증문구</th><td>${challDTO.certifi_words}</td>
      </tr>
      <tr>
				<td colspan="2">
      		<a href="${cPath}/chall/list">목록보기</a>
      		<a href="${cPath}/chall/modify?chall_no=${challDTO.chall_no}">수정(폼페이지 보여줘)</a>
      		<a href="${cPath}/chall/delete?chall_no=${challDTO.chall_no}">삭제</a>
      	</td> 
      </tr>
    </tbody>
    <tbody>
    </tbody>
  </table>
</body>
</html>