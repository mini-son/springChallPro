<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cPath" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>우리들의 미니멀 챌린지::작심삼일</title>
 <link rel="stylesheet" href="../../../css/bootstrap.min.css"> 
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.8/dist/web/static/pretendard-dynamic-subset.css" />
<!-- 사용자 정의 CSS 파일을 Bootstrap CSS 파일 이후에 포함시킵니다. -->
	<link rel="stylesheet" href="/css/sidebarNav.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>

    
  </style>
   <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

</head>
    

<body>

    


<%-- --- 챌린지 카드 3열로 --- --%>
<div class="container">
  <div class="row">
  <c:forEach var="chall" items="${challPage.content}" varStatus="status">
    <div class="col-4">
      <div class="card mb-2 ml-2 mt-4">
         <a href="<%=request.getContextPath()%>/chall/read.do?no=${chall.challNo}&pageNo=${nowPage}">
        <img class="card-img-top" src="/img/${chall.cateNo}.jpg" style="height:225px"/>
         <c:if test="${chall.memNo == 1}">
            <span class="badge bg-primary" style="width:50px; margin: 15px;">공식</span>
          </c:if>
          <c:if test="${chall.memNo != 1}">
            <span class="badge bg-light" style="width:100px; margin: 15px;">${chall.nickname}</span>
          </c:if>
         <div class="card-body">
          <a>${chall.challTitle}</a>
          <p class="card-text comment" style="float:right;">${chall.cateName}</p>
        </div> <%-- card-body --%>
        </a>
      </div> <%-- card --%>
   	 </div> <%--col-4 --%>
    </c:forEach>
	</div><%-- container --%>
  
  </div> <!-- 검색~본문 -->

      
      
</body>

</html>
