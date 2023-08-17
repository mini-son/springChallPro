<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<!-- jQuery연동 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	//<input type="button" id="modifyBtn" value="수정"/>
	$("#modifyBtn").on("click",function(){
		
		let challtitleObjV = $("#chall_title").val();
		if(challtitleObjV==""){
			alert("제목은 필수입력입니다");
			$("#chall_title").focus();
			return;
		}
		
		let challconObjV = $("#chall_con").val();
		if(challconObjV==""){
			alert("내용은 필수입력입니다");
			$("#chall_con").focus();
			return;
		}
		
		$("#challModifyForm").submit();
	});
});
</script>
</head>
<body>
<pre>http://localhost:8081/app/chall/modify</pre>
	<h1>modifyForm.jsp</h1>
	challDTO=${challDTO}
	<form id="challModifyForm" action="modify" method="POST">
		<input type="hidden" name="no" value="${challDTO.chall_no}"/>
	  <table id="challModifyTable" border="1">
    <tbody>   
      <tr>
 		  <th>글번호</th>
        <td><input type="text" name="chall_no" id="chall_no" required="required" value="${challDTO.chall_no}"/></td>
      </tr>
      <tr>
        <th>카테고리번호</th>
        <td><input type="text" name="cate_no" id="cate_no" required="required" value="${challDTO.cate_no}"/></td>
      </tr>
      <tr>
        <th>제목</th>
        <td><input type="text" name="chall_title" id="chall_title" readonly="readonly" value="${challDTO.chall_title}"/></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><input type="text" name="chall_con" id="chall_con" readonly="readonly" value="${challDTO.chall_con}"/></td>
      </tr>
      <tr>
        <th>인증문구</th>
        <td><input type="text" name="certifi_words" id="certifi_words" required="required" value="${challDTO.certifi_words}"/></td>
      </tr>
      <tr>
      	<td colspan="2">
      		<a href="${cPath}/chall/list">목록보기</a>
      		<input type="button" id="modifyBtn" value="수정"/>
      	</td>
      </tr>
    </tbody>
    <tbody>
    </tbody>
  </table>
  </form>
</body>
</html>