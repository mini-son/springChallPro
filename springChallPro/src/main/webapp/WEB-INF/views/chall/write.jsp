<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="cPath" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>챌린지 등록</title>
<!-- jQuery연동 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
 $(document).ready(function(){
	//<input type="button" id="joinBtn" value="가입"/>
	$("#writeBtn").on("click",function(){
		let challtitleObjV = $("#chall_title").val();
		if(challtitleObjV==""){
			alert("제목은 필수입력입니다");
			$("#chall_title").focus();
			return;
		}
		
		let challconObjV = $("#chall_con").val();
		if(challconObjV==""){
			alert("내용은필수입력입니다");
			$("#chall_con").focus();
			return;
		}
		
		$("#challWriteForm").submit();
	});
}); 
</script>
</head>
<body>
<pre>http://localhost:8081/app/chall/write</pre>
	<h1>write.jsp</h1>
	
	<form id="challWriteForm" action="write" method="POST">
	  <table id="challWriteTable" border="1">
    <tbody>   
      <tr>
 		 <%-- <th>번호</th>
        <td><input type="">${memberDTO.no}</td>
      </tr> --%>
       <select id="numberSelect" name="cate_no" id="cate_no"  class="form-control">
            <option value="1">운동</option>
            <option value="2">생활습관</option>
            <option value="3">자기계발</option>
        </select>
      <tr>
        <th>제목</th>
        <td><input type="text" name="chall_title" id="chall_title" required="required"/></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><input type="text" name="chall_con" id="chall_con" required="required"/></td>
      </tr>
      <tr>
        <th>인증문구</th>
        <td><input type="text" name="certifi_words" id="certifi_words" required="required"/></td>
      </tr>
      <tr>
        <th>mem_no</th>
        <td><input type="text" name="mem_no" id="mem_no" required="required"/></td>
      </tr>
      <%--<tr>
        <th>isshow</th><td>${memberDTO.isshow}</td>
      </tr>--%>
      <tr>
      	<td colspan="2">
      		<a href="${cPath}/chall/list">목록보기</a>
      		<input type="button" id="writeBtn" value="등록하기"/>
      	</td>
      </tr>
    </tbody>
    <tbody>
    </tbody>
  </table>
  </form>
</body>
</html>